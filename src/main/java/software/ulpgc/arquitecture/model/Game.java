package software.ulpgc.arquitecture.model;

public class Game {
    private final Board board;
    private final Difficulty difficulty;
    private GameStatus gameStatus;
    private final GameStatusChecker gameStatusChecker;


    public Game(Difficulty difficulty) {
        this.board = new Board(difficulty.getRows(), difficulty.getColumns(), difficulty.getMineCount()).initializeBoard();
        this.difficulty = difficulty;
        this.gameStatusChecker = new GameStatusChecker(this);
        board.addObserver(gameStatusChecker);
        this.gameStatus = GameStatus.Current;
    }

    public void checkGameStatus() {

    }

    public Board getBoard() {
        return board;
    }
}