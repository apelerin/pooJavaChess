package fr.rphstudio.chess.game;

import fr.rphstudio.chess.interf.IChess.*;

/**
 * Class destined to keep track of removed pieces
 */
public class RemovedPieces {
    /**
     * Index destined to go along the one in OneMove
     */
    private int index;
    private ChessColor color;
    private ChessType type;
    
    public RemovedPieces(int i, ChessColor color, ChessType type) {
        this.index = i;
        this.color = color;
        this.type = type;
    }
}
