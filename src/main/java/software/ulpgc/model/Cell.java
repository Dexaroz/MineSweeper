package software.ulpgc.model;

public record Cell(boolean hasMine, boolean isFlagged, boolean isRevealed, int adjacentMines) {
}
