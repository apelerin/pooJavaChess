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

    public RemovedPieces(ChessType type, int i) {
        this.index = i;
        this.type = type;
    }

    public int getIndex() {
        return index;
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

    public static void seekAndDestroy(ArrayList<RemovedPieces> list, int indexToRemove) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getIndex() == indexToRemove) {
                list.remove(i);
            }
        }
    }
}
