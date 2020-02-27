package fr.rphstudio.chess.game;

import fr.rphstudio.chess.interf.EmptyCellException;
import fr.rphstudio.chess.interf.IChess;
import fr.rphstudio.chess.interf.OutOfBoardException;

import java.util.ArrayList;
import java.util.List;

public class ChessModel implements IChess {
    private static ChessModel single_instance = null;
    private Board chessBoard;
    private ArrayList<ChessType> whiteRemovedPieces = new ArrayList<ChessType>();
    private ArrayList<ChessType> blackRemovedPieces = new ArrayList<ChessType>();

    private ChessModel() {
        chessBoard = new Board();
    }

    public static ChessModel getInstance()
    {
        if (single_instance == null)
            single_instance = new ChessModel();

        return single_instance;
    }

    @Override
    public void reinit() {

    }

    @Override
    public ChessType getPieceType(ChessPosition p) throws EmptyCellException, OutOfBoardException {
        int positionX = p.x;
        int positionY = p.y;
        try {
            return chessBoard.getPiece(positionX, positionY).getType();
        }
        catch (NullPointerException npe) {
            throw new EmptyCellException();
        }
    }

    @Override
    public ChessColor getPieceColor(ChessPosition p) throws EmptyCellException, OutOfBoardException {
        int positionX = p.x;
        int positionY = p.y;
        try {
            return chessBoard.getPiece(positionX, positionY).getColor();
        }
        catch (NullPointerException npe) {
            throw new EmptyCellException();
        }
    }

    @Override
    public int getNbRemainingPieces(ChessColor color) {

        return chessBoard.getNbRemainingPieces(color);
    }

    @Override
    public List<ChessPosition> getPieceMoves(ChessPosition p) {
        return chessBoard.getPiece(p.x, p.y).getPieceMove().getMove(p, chessBoard);
    }

    @Override
    public void movePiece(ChessPosition p0, ChessPosition p1) {
        Piece movingPiece = chessBoard.getPiece(p0.x, p0.y);
        movingPiece.nbrMoves++;
        if (chessBoard.getPiece(p0.x, p0.y).getType() == ChessType.TYP_KING){
            if (p1.x + p0.x == 11 ){
                Piece rookCastle = new Piece(ChessType.TYP_ROOK, chessBoard.getPiece(p0.x, p0.y).getColor());
                chessBoard.removeMovingPiece(p0);
                chessBoard.removeMovingPiece(p1);
                ChessPosition kingPlacement = new ChessPosition(p0.x+2, p0.y);
                ChessPosition rookPlacement = new ChessPosition(p1.x-2, p1.y);
                chessBoard.replacingPiece(movingPiece, kingPlacement);
                chessBoard.replacingPiece(rookCastle, rookPlacement);
                return;
            }
            if (p1.x + p0.x == 4 ){
                Piece rookCastle = new Piece(ChessType.TYP_ROOK, chessBoard.getPiece(p0.x, p0.y).getColor());
                chessBoard.removeMovingPiece(p0);
                chessBoard.removeMovingPiece(p1);
                ChessPosition kingPlacement = new ChessPosition(p0.x-2, p0.y);
                ChessPosition rookPlacement = new ChessPosition(p1.x+3, p1.y);
                chessBoard.replacingPiece(movingPiece, kingPlacement);
                chessBoard.replacingPiece(rookCastle, rookPlacement);
                return;
            }
        }
        if (chessBoard.getPiece(p1.x, p1.y) != null) {
            Piece pieceEaten = chessBoard.getPiece(p1.x, p1.y);
            if (pieceEaten.getColor() == ChessColor.CLR_WHITE) {
                whiteRemovedPieces.add(pieceEaten.getType());
            }
            else {
                blackRemovedPieces.add(pieceEaten.getType());
            }
        }
        chessBoard.removeMovingPiece(p0);
        chessBoard.replacingPiece(movingPiece, p1);
    }

    @Override
    public ChessKingState getKingState(ChessColor color) {
        return ChessKingState.KING_SAFE;
    }

    @Override
    public List<ChessType> getRemovedPieces(ChessColor color) {
        if (color == ChessColor.CLR_WHITE) {
            return whiteRemovedPieces;
        }
        return blackRemovedPieces;
    }

    @Override
    public boolean undoLastMove() {
        return false;
    }

    @Override
    public long getPlayerDuration(ChessColor color, boolean isPlaying) {
        return 0;
    }

}
