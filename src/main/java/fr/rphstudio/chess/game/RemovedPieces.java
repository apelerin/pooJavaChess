package fr.rphstudio.chess.game;

import fr.rphstudio.chess.interf.IChess.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Class destined to keep track of removed pieces
 */
public class RemovedPieces {
    /**
     * Index destined to go along the one in OneMove
     */
    private int index;
    private ChessType type;

    public RemovedPieces(ChessType type) {
        //this.index = i;
        this.type = type;
    }

    public ChessType getType() {
        return type;
    }

    public static List<ChessType> convertToList(ArrayList<RemovedPieces> listRemovedPiece) {
        ArrayList<ChessType> list = new ArrayList<>();
        for (int i = 0; i < listRemovedPiece.size(); i++) {
            list.add(listRemovedPiece.get(i).getType());
        }
        return list;
    }
}
