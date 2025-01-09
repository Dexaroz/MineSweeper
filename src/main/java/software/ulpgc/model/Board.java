package software.ulpgc.model;

import java.util.Random;

public class Board {
    private final int rows;
    private final int columns;
    private final int mineCount;
    private final int revealedCells;
    private final Cell[][] cells;

    public Board(int rows, int columns, int mineCount) {
        this.rows = rows;
        this.columns = columns;
        this.mineCount = mineCount;
        this.revealedCells = 0;
        this.cells = new Cell[rows][columns];
    }

    public Board(int rows, int columns, int mineCount, Cell[][] cells, int revealedCells) {
        this.rows = rows;
        this.columns = columns;
        this.mineCount = mineCount;
        this.revealedCells = revealedCells;
        this.cells = cells;

        if (hasYouWin()){
            System.out.println("FELICIDADES JEFE");
        }
    }

    public Board initializeBoard(){
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                cells[i][j] = new Cell(false, false, false, 0);
            }
        }

        return this;
    }

    public Board placeMines(long seed){
        Random random = new Random(seed);
        int placedMines = 0;

        while (placedMines < mineCount) {
            int row = random.nextInt(rows);
            int column = random.nextInt(columns);

            if (!cells[row][column].hasMine()) {
                cells[row][column] = new Cell(true, false, false, 0);
                placedMines++;
            }
        }

        return this;
    }

    public Board revealCell(int row, int col){
        Cell cell = cells[row][col];

        if (!hasYouLost(cell)){
            cells[row][col] = new Cell(cell.hasMine(), false, true, countAdjacentMines(row, col));
            int revealedCount = 1;

            if (countAdjacentMines(row, col) == 0){
                revealedCount = revealAdjacentCells(row, col, revealedCount);
            }

            return new Board(this.rows, this.columns, this.mineCount, this.cells, revealedCells + revealedCount);
        }

        return this;
    }

    public void toggleFlag(int row, int col){
        Cell cell = cells[row][col];

        if (!cell.isRevealed()){
            cells[row][col] = new Cell(cell.hasMine(), !cell.isFlagged(), false, cell.adjacentMines());
        }
    }

    private int countAdjacentMines(int row, int col) {
        int mines = 0;

        for (int i = row - 1; i <= row; i++) {
            for (int j = col - 1; j <= col; j++) {
                if (cells[i][j].hasMine()){
                    mines++;
                }
            }
        }

        return mines;
    }

    private boolean hasYouLost(Cell cell){
        if (cell.hasMine()){
            System.out.println("PERDISTE JEFE");
            return true;
        }
        return false;
    }

    private boolean hasYouWin(){
        int totalCell = rows * columns;
        return revealedCells == totalCell - mineCount;
    }

    private int revealAdjacentCells(int row, int col, int revealedCount) {
        for (int i = row - 1; i <= row; i++) {
            for (int j = col - 1; j <= col; j++) {
                revealedCount = getRevealedCount(revealedCount, i, j);
            }
        }
        return revealedCount;
    }

    private int getRevealedCount(int revealedCount, int i, int j) {
        if (i >= 0 && i < rows && j >= 0 && j < columns) {
            Cell adjacentCell = cells[i][j];
            revealedCount = getRevealedCount(revealedCount, i, j, adjacentCell);
        }
        return revealedCount;
    }

    private int getRevealedCount(int revealedCount, int i, int j, Cell adjacentCell) {
        if (!adjacentCell.isRevealed() && !adjacentCell.isFlagged()) {
            int adjacentMines = countAdjacentMines(i, j);
            cells[i][j] = new Cell(false, false, true, adjacentMines);
            revealedCount++;

            if (adjacentMines == 0) {
                revealedCount = revealAdjacentCells(i, j, revealedCount);
            }
        }
        return revealedCount;
    }
}
