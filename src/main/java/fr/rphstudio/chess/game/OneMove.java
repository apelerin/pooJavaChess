package fr.rphstudio.chess.game;

import fr.rphstudio.chess.interf.IChess.*;

/**
 * Represent one move that has been done, it is meant to be contain in a list
 */
public class OneMove {
    static int index = 0;

    private int indexItem;
    private ChessPosition pieceMoved;
    private ChessPosition pieceMovedPos;
    private boolean hasEaten;
    private ChessPosition pieceEaten;
    private ChessPosition pieceEatenPos;

    public OneMove(int index) {
        this.indexItem = index;
        index++;
    }
}
