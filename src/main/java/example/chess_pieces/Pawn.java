package example.chess_pieces;

import org.example.ChessBoard;

public class Pawn extends ChessPiece {
    public Pawn(String color) {
        super(color);
    }

    @Override
    public String getColor() {
        return super.getColor();
    }

    @Override
    public boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {
        // Проверяем, не находится ли пешка в той же точке
        if (line == toLine && column == toColumn) {
            return false;
        }
        // Проверяем, не выходит ли пешка за пределы доски
        if (toLine < 0 || toLine > 7 || toColumn < 0 || toColumn > 7) {
            return false;
        }

        // Проверяем может ли ходить пешка буквой "Г"
        if (getColor().equals("White")) {
            if (toLine > line) { // Белая пешка ходит вверх
                // Проверяем, первый ли ход (на 2 клетки)
                if (line == 1 && toLine == 3 && column == toColumn) {
                    return true;
                }
                // Проверяем, обычный ли ход (на 1 клетку)
                return toLine == line + 1 && column == toColumn;
            } else {
                return false; // Белая пешка не может ходить назад
            }
        } else { // Черная пешка
            if (toLine < line) { // Черная пешка ходит вниз
                // Проверяем, первый ли ход (на 2 клетки)
                if (line == 6 && toLine == 4 && column == toColumn) {
                    return true;
                }
                // Проверяем, обычный ли ход (на 1 клетку)
                return toLine == line - 1 && column == toColumn;
            } else {
                return false; // Черная пешка не может ходить назад
            }
        }// Если не выполняется ни одно из условий, ход невозможен

    }

    @Override
    public String getSymbol() {
        return "P";
    }
}
