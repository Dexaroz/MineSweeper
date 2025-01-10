package software.ulpgc.app.swing;

import software.ulpgc.arquitecture.model.Board;
import software.ulpgc.arquitecture.view.BoardDisplay;
import javax.swing.*;
import java.awt.*;

public class SwingBoardDisplay extends JPanel implements BoardDisplay  {


    private final Board board;
    private int cellWidth;
    private int cellHeight;


    public SwingBoardDisplay(Board board){
        this.board = board;
        cellHeight = (this.getHeight()-5)/board.getColumns();
        cellWidth = (this.getWidth()-5)/board.getRows();
    }

    public void paint(Graphics g){
        g.setColor(Color.BLACK);

    }


    @Override
    public void show(Board board) {
        repaint();
    }

    @Override
    public void on(Clicked clicked) {

    }
}