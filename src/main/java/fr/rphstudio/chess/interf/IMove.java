package fr.rphstudio.chess.interf;

import java.util.List;
import fr.rphstudio.chess.interf.IChess.*;
import fr.rphstudio.chess.game.Board;

public interface IMove {

    public List<ChessPosition> getMove(ChessPosition p, Board chessBoard);


}
