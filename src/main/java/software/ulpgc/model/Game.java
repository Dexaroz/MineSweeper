package software.ulpgc.model;

public class Game {
    private final Board board;
    private final Difficulty difficulty;

    public Game(Difficulty difficulty) {
        this.board = new Board(difficulty.getRows(), difficulty.getColumns(), difficulty.getMineCount());
        this.difficulty = difficulty;
    }

    public Board getBoard() {
        return board;
    }
}