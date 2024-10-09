package avduhova.lubov.chess_pieces;

import avduhova.lubov.ChessBoard;

public class Horse extends ChessPiece {
    public Horse(String color) {
        super(color);
    }

    @Override
    public String getColor() {
        return super.getColor();
    }


    @Override
    public boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {
        // Проверяем, не находится ли слон в той же точке
        if (line == toLine && column == toColumn) {
            return false;
        }
        // Проверяем, не выходит ли конь за пределы доски
        if (toLine < 0 || toLine > 7 || toColumn < 0 || toColumn > 7) {
            return false;
        }

        // Проверка на то, что ход коня соответствует "Г" -образному движению
        if ((Math.abs(toLine - line) == 2 && Math.abs(toColumn - column) == 1) ||
                (Math.abs(toLine - line) == 1 && Math.abs(toColumn - column) == 2)) {

            // Проверка на то, что на клетку, куда собирается пойти конь, не стоит фигура своего цвета
            return chessBoard.board[toLine][toColumn] == null || !chessBoard.board[toLine][toColumn].getColor().equals(getColor());


            // Конь может прыгать, поэтому эта проверка не нужна
        }
        return false; // Если не выполняется ни одно из условий, ход невозможен
    }

    @Override
    public String getSymbol() {
        return "H";
    }
}

