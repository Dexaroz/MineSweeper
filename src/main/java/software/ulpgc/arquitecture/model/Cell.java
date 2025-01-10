package software.ulpgc.arquitecture.model;

public record Cell(boolean hasMine, boolean isFlagged, boolean isRevealed, int adjacentMines) {
}
