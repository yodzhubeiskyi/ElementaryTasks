package com.oessoft.output;

import com.oessoft.model.ChessBoard;
import com.oessoft.service.ChessBoardService;
import com.oessoft.service.MainMenuService;

public class ChessBoardOutput {
    private ChessBoard chessBoard;

    public ChessBoardOutput(ChessBoardService chessBoardService) {
        chessBoard = chessBoardService.getChessBoard();
    }

    public void printChessBoard() {
        if (chessBoard != null) {
            for (int i = 0; i < chessBoard.getHeight(); i++) {
                StringBuilder outputBuilder = new StringBuilder();
                for (int j = 0; j < chessBoard.getWidth(); j++) {
                    outputBuilder.append(chessBoard.getGrid()[i][j]);
                }
                System.out.println(outputBuilder);
            }
        }
        MainMenuService.showTaskSelection();
    }
}
