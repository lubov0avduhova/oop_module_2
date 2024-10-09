package example.chess_pieces;

import org.example.ChessBoard;

public class King extends ChessPiece {
    public King(String color) {
        super(color);
    }

    @Override
    public String getColor() {
        return super.getColor();
    }


    @Override
    public boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {
        // Проверяем, не находится ли Король в той же точке
        if (line == toLine && column == toColumn) {
            return false;
        }

        // Проверяем, не выходит ли Король за пределы доски
        if (toLine < 0 || toLine > 7 || toColumn < 0 || toColumn > 7) {
            return false;
        }

        // Проверяем может ли ходить Король в любую сторону на 1
        return (Math.abs(toLine - line) <= 1) && (Math.abs(toColumn - column) <= 1);// Если не выполняется ни одно из условий, ход невозможен
    }


    @Override
    public String getSymbol() {
        return "K";
    }

    public boolean isUnderAttack(ChessBoard board, int line, int column) {
        // Проверяем все фигуры противника
        for (int i = 0; i < board.board.length; i++) {
            for (int j = 0; j < board.board.length; j++) {
                ChessPiece piece = board.board[i][j];
                if (piece != null && !piece.getColor().equals(getColor()) && piece.canMoveToPosition(board, i, j, line, column)) {
                    return true; // Фигура противника может атаковать клетку
                }
            }
        }
        return false; // Клетка не находится под атакой
    }
}

