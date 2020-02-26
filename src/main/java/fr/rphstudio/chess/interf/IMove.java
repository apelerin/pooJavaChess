package fr.rphstudio.chess.interf;

import java.util.List;

import fr.rphstudio.chess.game.Board;
import fr.rphstudio.chess.interf.IChess.*;

public interface IMove {

    public List<ChessPosition> getMove(ChessPosition p, Board chessBoard);


}
