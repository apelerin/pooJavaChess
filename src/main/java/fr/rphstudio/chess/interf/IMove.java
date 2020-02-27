package fr.rphstudio.chess.interf;

import java.util.List;

import fr.rphstudio.chess.game.Board;
import fr.rphstudio.chess.interf.IChess.*;
import fr.rphstudio.chess.game.Board;




public interface IMove {
    /**
     * initiate the function that will move
     * the pieces on the board according
     * to his position
     * @param p
     * @param chessBoard
     * @return
     */
    public List<ChessPosition> getMove(ChessPosition p, Board chessBoard);
}
