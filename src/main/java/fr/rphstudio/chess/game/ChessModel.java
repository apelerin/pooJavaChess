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

    /**
     * creation of a new board (table)
     * it takes chessboard as a parameter
     *
     */
    private ChessModel() {
        chessBoard = new Board();
    }

    /**
     * instance creation
     * @return that return the single instance
     */
    public static ChessModel getInstance()
    {
        if (single_instance == null)
            single_instance = new ChessModel();

        return single_instance;
    }

    /**
     * function to reset the board and start a new game
     * @param "white Removed Pieces permet de Remove les pieces blanches
     * @param "black Removed Pieces permet de Remove les pieces noir
     */
    @Override
    public void reinit() {
        chessBoard = new Board();
        whiteRemovedPieces = new ArrayList<ChessType>();
        blackRemovedPieces = new ArrayList<ChessType>();
        // TODO reinit the time
    }

    /**
     *this allows you to choose and know the type of parts
     * @param p x/y position on the board where we want to get the piece type.
     * @return
     * @throws EmptyCellException
     * @throws OutOfBoardException
     */

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

    /**
     * this allows you to know the color of the pieces in relation to their positions
     * @param p x/y position on the board where we want to get the piece color.
     * @return
     * @throws EmptyCellException
     * @throws OutOfBoardException
     */

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
        catch (ArrayIndexOutOfBoundsException aio) {
            throw new OutOfBoardException();
        }
    }

    /**
     *this function lets you know the number of pieces remaining
     * @param color the requested color of the pieces to count.
     * @return
     */
    @Override
    public int getNbRemainingPieces(ChessColor color) {

        return chessBoard.getNbRemainingPieces(color);
    }


    @Override
    public List<ChessPosition> getPieceMoves(ChessPosition p) {
        return chessBoard.getPiece(p.x, p.y).getPieceMove().getMove(p, chessBoard);
    }
    /**
     * this function allows you to list the position of the part and then move them
     * @param p0 source position on the board.
     * @param p1 destination position on the board.
     */
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

    /**
     * get king state of the game in appel in the function
     * @param color the requested king color.
     * @return
     */
    @Override
    public ChessKingState getKingState(ChessColor color) {
        return chessBoard.checkState(color);
    }


    /**
     * function allowing to remove a part
     * @param color color of the removed pieces
     * @return function whiteRemovedPieces
     * @return function blackRemovedPieces
     */
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
