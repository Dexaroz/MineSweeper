package software.ulpgc.arquitecture.model;

import software.ulpgc.arquitecture.control.Observer;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Board {
    private final int rows;
    private final int columns;
    private final int mineCount;
    private final List<Observer> observers = new ArrayList<>();
    private final Cell[][] cells;

    public Board(int rows, int columns, int mineCount) {
        this.rows = rows;
        this.columns = columns;
        this.mineCount = mineCount;
        this.cells = new Cell[rows][columns];
    }

    public Board(int rows, int columns, int mineCount, Cell[][] cells) {
        this.rows = rows;
        this.columns = columns;
        this.mineCount = mineCount;
        this.cells = cells;
    }

    public void addObserver(Observer observer){
        observers.add(observer);
    }

    public void notifyObservers(Cell cell){
        for (Observer observer : observers){
            observer.update(cell);
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

    public void revealCell(int row, int col){
        Cell cell = cells[row][col];
        if (!cell.isRevealed()){
            cells[row][col] = new Cell(cell.hasMine(), false, true, countAdjacentMines(row, col));
            notifyObservers(cell);
        }

        if (countAdjacentMines(row, col) == 0){
            revealAdjacentCells(row, col);
        }
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

    private void revealAdjacentCells(int row, int col) {
        for (int i = row - 1; i <= row; i++) {
            for (int j = col - 1; j <= col; j++) {
                getRevealedCount(i, j);
            }
        }
    }

    private void getRevealedCount(int i, int j) {
        if (i >= 0 && i < rows && j >= 0 && j < columns) {
            Cell adjacentCell = cells[i][j];
            getRevealedCount(i, j, adjacentCell);
        }
    }

    private void getRevealedCount(int i, int j, Cell adjacentCell) {
        if (!adjacentCell.isRevealed() && !adjacentCell.isFlagged()) {
            int adjacentMines = countAdjacentMines(i, j);
            cells[i][j] = new Cell(false, false, true, adjacentMines);

            if (adjacentMines == 0) {
                revealAdjacentCells(i, j);
            }
        }
    }

    public int getRows() {
        return rows;
    }

    public int getColumns() {
        return columns;
    }

    public int getMineCount() {
        return mineCount;
    }
}
