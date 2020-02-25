package fr.rphstudio.chess.game;

import fr.rphstudio.chess.interf.IChess.ChessType;
import fr.rphstudio.chess.interf.IChess.ChessColor;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import static fr.rphstudio.chess.interf.IChess.ChessType.*;

public class Board {
    private Piece[][] pieceList = new Piece[8][8];
    private int rowInitWhitePawn = 6;
    private int rowInitBlackPawn = 1;

    public Piece getPiece(int x, int y) {
        return pieceList[x][y];
    }

    HashMap<int[], ChessType> mapWhitePiece = new HashMap<int[], ChessType>() {
        {
            put(new int[]{7, 0}, TYP_ROOK);
            put(new int[]{7, 7}, TYP_ROOK);
            put(new int[]{7, 1}, TYP_KNIGHT);
            put(new int[]{7, 6}, TYP_KNIGHT);
            put(new int[]{7, 2}, TYP_BISHOP);
            put(new int[]{7, 5}, TYP_BISHOP);
            put(new int[]{7, 4}, TYP_KING);
            put(new int[]{7, 3}, TYP_QUEEN);
        }
    };

    HashMap<int[], ChessType> mapBlackPiece = new HashMap<int[], ChessType>() {
        {
            put(new int[]{0, 0}, TYP_ROOK);
            put(new int[]{0, 7}, TYP_ROOK);
            put(new int[]{0, 1}, TYP_KNIGHT);
            put(new int[]{0, 6}, TYP_KNIGHT);
            put(new int[]{2, 0}, TYP_BISHOP);
            put(new int[]{0, 5}, TYP_BISHOP);
            put(new int[]{0, 3}, TYP_KING);
            put(new int[]{0, 4}, TYP_QUEEN);
        }
    };

    public Board() {
        for(int row = 0; row <= 7; row++) {
            for(int col = 0 ; col <= 7; col++) {
                if (row == rowInitBlackPawn)
                    pieceList[row][col] = new Piece(TYP_PAWN, ChessColor.CLR_BLACK);
                else if (row == rowInitWhitePawn)
                    pieceList[row][col] = new Piece(TYP_PAWN, ChessColor.CLR_WHITE);
            }
        }
        iterCreateMap(mapWhitePiece, ChessColor.CLR_WHITE);
        iterCreateMap(mapBlackPiece, ChessColor.CLR_BLACK);
    }

    private void iterCreateMap (HashMap<int[], ChessType> mapPiece, ChessColor color){
        for (Map.Entry<int[], ChessType> entry : mapPiece.entrySet()) {
            pieceList[entry.getKey()[0]][entry.getKey()[1]] = new Piece(entry.getValue(), color);
        }
    }
}
