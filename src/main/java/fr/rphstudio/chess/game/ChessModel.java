package fr.rphstudio.chess.game;

import fr.rphstudio.chess.interf.EmptyCellException;
import fr.rphstudio.chess.interf.IChess;
import fr.rphstudio.chess.interf.OutOfBoardException;

import java.util.ArrayList;
import java.util.List;

public class ChessModel implements IChess {
    private static ChessModel single_instance = null;
    private Board chessBoard;
    private ArrayList<RemovedPieces> whiteRemovedPieces = new ArrayList<>();
    private ArrayList<RemovedPieces> blackRemovedPieces = new ArrayList<>();
    ArrayList<OneMove> lastMoves = new ArrayList<>();
    private TimerSet timerW = new TimerSet();
    private TimerSet timerB = new TimerSet();

    /**
     * Initialize the chessBoard
     *
     *
     */
    private ChessModel() {
        chessBoard = new Board();
    }

    /**
     * instance creation according to singleton
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
     *
     */
    @Override
    public void reinit() {
        chessBoard = new Board();
        whiteRemovedPieces = new ArrayList<RemovedPieces>();
        blackRemovedPieces = new ArrayList<RemovedPieces>();
        ArrayList<OneMove> lastMoves = new ArrayList<>();
        timerW = new TimerSet();
        timerB = new TimerSet();
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
        catch (ArrayIndexOutOfBoundsException aio) {
            throw new OutOfBoardException();
        }
    }

    /**
     * this allows you to know the color of the pieces by supplying it's position
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
     * this function lets you know the number of pieces remaining by color
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
     * this function allows you to list the position of a piece
     * @param p0 source position on the board.
     * @param p1 destination position on the board.
     */
    @Override
    public void movePiece(ChessPosition p0, ChessPosition p1) {
        Piece movingPiece = chessBoard.getPiece(p0.x, p0.y);
        movingPiece.incrementNbrMoves();
        if (chessBoard.getPiece(p0.x, p0.y).getType() == ChessType.TYP_KING){
            if (p0.x == 4 && p1.x == 7){
                Piece rookCastle = new Piece(ChessType.TYP_ROOK, chessBoard.getPiece(p0.x, p0.y).getColor());
                chessBoard.removeMovingPiece(p0);
                chessBoard.removeMovingPiece(p1);
                ChessPosition kingPlacement = new ChessPosition(p0.x+2, p0.y);
                ChessPosition rookPlacement = new ChessPosition(p1.x-2, p1.y);
                chessBoard.replacingPiece(movingPiece, kingPlacement);
                chessBoard.replacingPiece(rookCastle, rookPlacement);
                lastMoves.add(new OneMove(rookCastle, rookPlacement, p1, true));
                return;
            }
            if (p0.x == 4 && p1.x == 0){
                Piece rookCastle = new Piece(ChessType.TYP_ROOK, chessBoard.getPiece(p0.x, p0.y).getColor());
                chessBoard.removeMovingPiece(p0);
                chessBoard.removeMovingPiece(p1);
                ChessPosition kingPlacement = new ChessPosition(p0.x-2, p0.y);
                ChessPosition rookPlacement = new ChessPosition(p1.x+3, p1.y);
                chessBoard.replacingPiece(movingPiece, kingPlacement);
                chessBoard.replacingPiece(rookCastle, rookPlacement);
                lastMoves.add(new OneMove(rookCastle, rookPlacement, p1, true));
                return;
            }
        }
        if (chessBoard.getPiece(p0.x, p0.y).getType() == ChessType.TYP_PAWN) {
            if (p1.y == 0 || p1.y == 7) {
                Piece newQueen = new Piece(ChessType.TYP_QUEEN, chessBoard.getPiece(p0.x, p0.y).getColor());
                chessBoard.removeMovingPiece(p0);
                chessBoard.removeMovingPiece(p1);
                chessBoard.replacingPiece(newQueen, p1);
                return;
            }
        }
        if (chessBoard.getPiece(p1.x, p1.y) != null) {
            Piece pieceEaten = chessBoard.getPiece(p1.x, p1.y);
            lastMoves.add(new OneMove(movingPiece, p0, pieceEaten, p1));
            int index = lastMoves.get(lastMoves.size() - 1).getIndexItem();
            if (pieceEaten.getColor() == ChessColor.CLR_WHITE) {
                whiteRemovedPieces.add(new RemovedPieces(pieceEaten.getType(), index));
            }
            else {
                blackRemovedPieces.add(new RemovedPieces(pieceEaten.getType(), index));
            }
            chessBoard.removeMovingPiece(p0);
            chessBoard.replacingPiece(movingPiece, p1);
        } else {
            lastMoves.add(new OneMove(movingPiece, p0, p1));
            chessBoard.removeMovingPiece(p0);
            chessBoard.replacingPiece(movingPiece, p1);
        }
    }

    /**
     * get king state of the color passed in param
     * @param color the requested king color.
     * @return
     */
    @Override
    public ChessKingState getKingState(ChessColor color) {
        return chessBoard.checkState(color);
    }


    /**
     * function allowing to remove a piece
     * @param color color of the removed pieces
     * @return ArrayList whiteRemovedPieces
     * @return ArrayList blackRemovedPieces
     */
    @Override
    public List<ChessType> getRemovedPieces(ChessColor color) {
        if (color == ChessColor.CLR_WHITE) {
            return RemovedPieces.convertToList(whiteRemovedPieces);
        }
        return RemovedPieces.convertToList(blackRemovedPieces);
    }

    @Override
    public boolean undoLastMove() {
        if (lastMoves.size() == 1) {
            lastMoves.get(0).undoMove(chessBoard);
            lastMoves.remove(0);
            return false;
        }
        OneMove last = lastMoves.get(lastMoves.size() - 1);
        if (last.undoMove(chessBoard)) {
            RemovedPieces.seekAndDestroy(blackRemovedPieces, last.getIndexItem());
            RemovedPieces.seekAndDestroy(whiteRemovedPieces, last.getIndexItem());
        }
        lastMoves.remove(lastMoves.size() - 1);
        return true;
    }

    @Override
    public long getPlayerDuration(ChessColor color, boolean isPlaying) {
        if (color == ChessColor.CLR_WHITE && isPlaying){
            return timerW.setTimer();
        }
        if (color == ChessColor.CLR_BLACK && isPlaying){
            return timerB.setTimer();
        }
        return 0;
    }
}
