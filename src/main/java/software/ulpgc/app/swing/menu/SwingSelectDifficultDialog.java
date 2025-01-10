package software.ulpgc.app.swing.menu;

import software.ulpgc.arquitecture.model.Difficulty;
import software.ulpgc.arquitecture.view.SelectDifficultyDialog;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class SwingSelectDifficultDialog extends JPanel implements SelectDifficultyDialog {

    private final List<Difficulty> difficulties;
    private final JComboBox<Difficulty> selector;

    public SwingSelectDifficultDialog(List<Difficulty> difficulties) {
        this.difficulties = difficulties;
        this.add(selector = selector());
    }

    private JComboBox<Difficulty> selector() {
        JComboBox<Difficulty> comboBox = new JComboBox<>();
        comboBox.setOpaque(true);
        comboBox.setBackground(new Color(255, 255, 255));

        comboBox.setForeground(Color.WHITE);
        comboBox.setBackground(new Color(44, 44, 46));

        for (Difficulty difficulty : difficulties)
            comboBox.addItem(difficulty);
        return comboBox;
    }

    @Override
    public Difficulty getDifficulty() {
        return difficulties.get(selector.getSelectedIndex());
    }
}
