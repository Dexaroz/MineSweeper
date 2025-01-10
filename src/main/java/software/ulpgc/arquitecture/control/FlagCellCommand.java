package software.ulpgc.arquitecture.control;

public class FlagCellCommand implements Command {
    private final BoardPresenter presenter;

    public FlagCellCommand(BoardPresenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void execute() {

    }
}
