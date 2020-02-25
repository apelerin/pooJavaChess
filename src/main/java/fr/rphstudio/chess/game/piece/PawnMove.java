package fr.rphstudio.chess.game.piece;

import fr.rphstudio.chess.game.Board;
import fr.rphstudio.chess.interf.IChess;
import fr.rphstudio.chess.interf.IMove;

import java.util.ArrayList;
import java.util.List;

public class PawnMove implements IMove {

    @Override
    public List<IChess.ChessPosition> getMove(IChess.ChessPosition p, Board chessBoard) {
        int x = p.x;
        int y = p.y;
        IChess.ChessPosition pos = new IChess.ChessPosition( p.x+1 , p.y+1 );
//        pos.x = p.x + 1;
//        pos.y = p.y + 1;
        ArrayList<IChess.ChessPosition> position = new ArrayList<IChess.ChessPosition>();
        position.add(pos);
        return position;
    }
}
