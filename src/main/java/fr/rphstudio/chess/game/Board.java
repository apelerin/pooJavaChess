package fr.rphstudio.chess.game;

import fr.rphstudio.chess.interf.IChess.*;

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

    public void removeMovingPiece(ChessPosition pos) {
        pieceList[pos.x][pos.y] = null;
    }

    public void replacingPiece(Piece movingPiece, ChessPosition pos) {
        pieceList[pos.x][pos.y] = movingPiece;
    }

    HashMap<int[], ChessType> mapWhitePiece = new HashMap<int[], ChessType>() {
        {
            put(new int[]{7, 0}, TYP_ROOK);
            put(new int[]{7, 7}, TYP_ROOK);
            //put(new int[]{7, 1}, TYP_KNIGHT);
            //put(new int[]{7, 6}, TYP_KNIGHT);
            //put(new int[]{7, 2}, TYP_BISHOP);
            //put(new int[]{7, 5}, TYP_BISHOP);
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
            put(new int[]{0, 2}, TYP_BISHOP);
            put(new int[]{0, 5}, TYP_BISHOP);
            put(new int[]{0, 4}, TYP_KING);
            put(new int[]{0, 3}, TYP_QUEEN);
        }
    };

    public Board() {
        for (int row = 0; row <= 7; row++) {
            for (int col = 0; col <= 7; col++) {
                if (row == rowInitBlackPawn)
                    pieceList[col][row] = new Piece(TYP_PAWN, ChessColor.CLR_BLACK);
                else if (row == rowInitWhitePawn)
                    pieceList[col][row] = new Piece(TYP_PAWN, ChessColor.CLR_WHITE);
            }
        }
        iterCreateMap(mapWhitePiece, ChessColor.CLR_WHITE);
        iterCreateMap(mapBlackPiece, ChessColor.CLR_BLACK);
    }

    private void iterCreateMap(HashMap<int[], ChessType> mapPiece, ChessColor color) {
        for (Map.Entry<int[], ChessType> entry : mapPiece.entrySet()) {
            pieceList[entry.getKey()[1]][entry.getKey()[0]] = new Piece(entry.getValue(), color);
        }
    }

    public int getNbRemainingPieces(ChessColor color) {
        int nbrPieces = 0;
        for (int i = 0; i < pieceList.length; i++) {
            for (int j = 0; j < pieceList[i].length; j++) {
                if (pieceList[i][j] == null)
                    continue;
                else if (pieceList[i][j].getColor() == color) {
                    nbrPieces++;
                }
            }
        }
        return nbrPieces;
    }
}
