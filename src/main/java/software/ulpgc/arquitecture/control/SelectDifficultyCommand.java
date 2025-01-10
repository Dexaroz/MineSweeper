package software.ulpgc.arquitecture.control;

import software.ulpgc.arquitecture.model.Board;
import software.ulpgc.arquitecture.view.BoardDisplay;
import software.ulpgc.arquitecture.view.SelectDifficultyDialog;

public class SelectDifficultyCommand implements Command{
    private final SelectDifficultyDialog dialog;
    private final BoardPresenter presenter;
    private final BoardDisplay display;

    public SelectDifficultyCommand(SelectDifficultyDialog dialog, BoardPresenter presenter, BoardDisplay display) {
        this.dialog = dialog;
        this.presenter = presenter;
        this.display = display;
    }

    @Override
    public void execute() {
        display.draw();
    }
}
