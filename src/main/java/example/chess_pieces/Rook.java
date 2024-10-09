package example.chess_pieces;

import org.example.ChessBoard;

public class Rook extends ChessPiece {
    public Rook(String color) {
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
        // Проверяем, не выходит ли слон за пределы доски
        if (toLine < 0 || toLine > 7 || toColumn < 0 || toColumn > 7) {
            return false;
        }

        // Проверка на то, что ход ладьи по горизонтали или вертикали
        if ((line == toLine && column != toColumn) || (line != toLine && column == toColumn)) {
            // Проверка на то, что на клетку, куда собирается пойти ладья, не стоит фигура своего цвета
            if (chessBoard.board[toLine][toColumn] != null && chessBoard.board[toLine][toColumn].getColor().equals(getColor())) {
                return false;
            }

            // Проверка на то, что между начальной и конечной клеткой нет других фигур
            if (line == toLine) {
                // Проверяем горизонталь
                for (int i = Math.min(column, toColumn) + 1; i < Math.max(column, toColumn); i++) {
                    if (chessBoard.board[line][i] != null) {
                        return false; // На пути другая фигура
                    }
                }
            } else {
                // Проверяем вертикаль
                for (int i = Math.min(line, toLine) + 1; i < Math.max(line, toLine); i++) {
                    if (chessBoard.board[i][column] != null) {
                        return false; // На пути другая фигура
                    }
                }
            }

            // Проверка на "съедание"
            if (chessBoard.board[toLine][toColumn] != null && !chessBoard.board[toLine][toColumn].getColor().equals(getColor())) {
                return true;
            }

            return true;
        }
        return false; // Если не выполняется ни одно из условий, ход невозможен
    }


    @Override
    public String getSymbol() {
        return "R";
    }
}

