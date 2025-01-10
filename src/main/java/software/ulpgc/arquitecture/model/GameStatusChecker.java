package software.ulpgc.arquitecture.model;

import software.ulpgc.arquitecture.control.Observer;

public class GameStatusChecker implements Observer {
    private final Game game;

    public GameStatusChecker(Game game) {
        this.game = game;
    }

    public boolean isWinCondition(){
        int totalCell = board.getRows() * board.getColumns();
        return board.getRevealedCells() == totalCell - board.getMineCount();
    }

    public boolean isLoseCondition(Cell cell){
        if (cell.hasMine()) {
            System.out.println("Perdiste");
        }
    }

    @Override
    public void update(Cell cell) {

    }
}
