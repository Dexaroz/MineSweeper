package software.ulpgc.app.swing.adapters;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class EventAdapter {
    private MouseListener mouseListener(){
        return new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {

            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        };
    }
}
