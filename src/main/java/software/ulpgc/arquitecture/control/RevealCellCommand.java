package software.ulpgc.arquitecture.control;

public class RevealCellCommand implements Command{
    private final BoardPresenter presenter;

    public RevealCellCommand(BoardPresenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void execute() {

    }
}
