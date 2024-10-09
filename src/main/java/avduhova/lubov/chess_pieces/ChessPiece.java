package avduhova.lubov.chess_pieces;

import avduhova.lubov.ChessBoard;

public abstract class ChessPiece {
    private final String color;
    private boolean check;

    public ChessPiece(String color) {
        this.color = color;
        check = true;
    }

    public abstract boolean canMoveToPosition(ChessBoard chessBoard,
                                              int line,
                                              int column,
                                              int toLine, int toColumn);

    public abstract String getSymbol();

    public String getColor() {
        return color;
    }

    public void setCheck(boolean check) {
        this.check = check;
    }

    public boolean isCheck() {
        return check;
    }

}
