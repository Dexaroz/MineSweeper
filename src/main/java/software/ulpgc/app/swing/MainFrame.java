package software.ulpgc.app.swing;

import software.ulpgc.arquitecture.control.Command;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class MainFrame extends JFrame {

    private final Map<String,Command> commands;

    public MainFrame() throws HeadlessException {
        this.setTitle("Minesweeper");
        this.setSize(800,600);
        this.setMinimumSize(new Dimension(600, 600));
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        addMiddlePanel();
        commands = new HashMap<>();
        //this.addSelector();
    }

    public void put(String name, Command command){
        commands.put(name,command);
    }

    private void addMiddlePanel() {
        this.setLayout(new GridBagLayout());
    }

    /*private JPanel addSelector() {
        JPanel panel = new JPanel();
        panel.add(selector());
        return panel;
    }

    private JComboBox selector() {
        JComboBox comboBox = new JComboBox<>();
        comboBox.addItem("easy");
        comboBox.addItem("medium");
        comboBox.addItem("hard");
        comboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (commands.containsKey("select")) {
                    commands.get("select").execute();
                }
            }
        });
        return comboBox;
    }
    */


}
