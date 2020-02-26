package fr.rphstudio.chess.game.piece;

import fr.rphstudio.chess.game.Board;
import fr.rphstudio.chess.interf.IChess;
import fr.rphstudio.chess.interf.IMove;

import java.util.ArrayList;
import java.util.List;

public class KnightMove implements IMove {

    @Override
    public List<IChess.ChessPosition> getMove(IChess.ChessPosition p, Board chessBoard) {
        int x = p.x;
        int y = p.y;
        ArrayList<IChess.ChessPosition> position = new ArrayList<IChess.ChessPosition>();
            IChess.ChessPosition pos = new IChess.ChessPosition();
            pos.y = y-2;
            pos.x = x+1;
            if (chessBoard.getPiece(pos.x, pos.y) != null ) {
                if (chessBoard.getPiece(pos.x, pos.y).getColor() != chessBoard.getPiece(p.x, p.y).getColor())
                    position.add(pos);
            }
            else
                    position.add(pos);
        return position;
    }
}
