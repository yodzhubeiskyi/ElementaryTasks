package com.oessoft.service;

import com.oessoft.input.ChessBoardInput;
import com.oessoft.model.ChessBoard;

public class ChessBoardService {
    private int[] chessBoardParameters;
    private ChessBoard chessBoard;

    public ChessBoardService(String[] args) {
        ChessBoardInput chessBoardInput = new ChessBoardInput(args);
        chessBoardParameters = chessBoardInput.getChessBoardParameters();
        if (chessBoardParameters != null) {
            chessBoard = new ChessBoard(chessBoardParameters[0], chessBoardParameters[1]);
            chessBoard.setGrid(createChessBoardGrid());
        } else {
            chessBoard = null;
        }
    }

    public String[][] createChessBoardGrid() {
        String[][] chessBoardGrid = new String[chessBoardParameters[0]][chessBoardParameters[1]];
        for (int i = 0; i < chessBoardParameters[0]; i++) {
            for (int j = 0; j < chessBoardParameters[1]; j++) {
                if (((i + j) % 2) == 0) {
                    chessBoardGrid[i][j] = "*";
                } else {
                    chessBoardGrid[i][j] = " ";
                }
            }
        }
        return chessBoardGrid;
    }

    public ChessBoard getChessBoard() {
        return chessBoard;
    }
}
