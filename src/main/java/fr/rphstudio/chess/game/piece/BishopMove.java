package fr.rphstudio.chess.game.piece;

import fr.rphstudio.chess.interf.IChess;
import fr.rphstudio.chess.interf.IMove;

import java.util.ArrayList;
import java.util.List;

public class BishopMove implements IMove {

    @Override
    public List<IChess.ChessPosition> getMove(IChess.ChessPosition p) {
        return new ArrayList<IChess.ChessPosition>();
    }
}
