package avduhova.lubov.chess_pieces;

import avduhova.lubov.ChessBoard;

public class Queen extends ChessPiece {
    public Queen(String color) {
        super(color);
    }

    @Override
    public String getColor() {
        return super.getColor();
    }


    @Override
    public boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {
        // Проверяем, не находится ли ферзь в той же точке
        if (line == toLine && column == toColumn) {
            return false;
        }

        // Проверяем, не выходит ли ферзь за пределы доски
        if (toLine < 0 || toLine > 7 || toColumn < 0 || toColumn > 7) {
            return false;
        }

        // Проверка на то, что ход ферзя по горизонтали, вертикали или диагонали
        if ((line == toLine && column != toColumn) || (line != toLine && column == toColumn) || (Math.abs(toLine - line) == Math.abs(toColumn - column))) {
            // Проверка на то, что на клетку, куда собирается пойти ферзь, не стоит фигура своего цвета
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
            } else if (column == toColumn) {
                // Проверяем вертикаль
                for (int i = Math.min(line, toLine) + 1; i < Math.max(line, toLine); i++) {
                    if (chessBoard.board[i][column] != null) {
                        return false; // На пути другая фигура
                    }
                }
            } else {
                // Проверяем диагональ
                int directionX = (toColumn - column) > 0 ? 1 : -1;
                int directionY = (toLine - line) > 0 ? 1 : -1;
                for (int i = 1; i < Math.abs(toLine - line); i++) {
                    if (chessBoard.board[line + i * directionY][column + i * directionX] != null) {
                        return false; // На пути другая фигура
                    }
                }
            }
        }
        return false; // Если не выполняется ни одно из условий, ход невозможен
    }

    @Override
    public String getSymbol() {
        return "Q";
    }
}

