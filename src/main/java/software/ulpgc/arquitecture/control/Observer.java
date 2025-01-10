package software.ulpgc.arquitecture.control;

import software.ulpgc.arquitecture.model.Cell;

public interface Observer {
    void update(Cell cell);
}
