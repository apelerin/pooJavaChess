package fr.rphstudio.chess.game.piece;

import fr.rphstudio.chess.game.Board;
import fr.rphstudio.chess.interf.IChess;
import fr.rphstudio.chess.interf.IMove;
import java.util.ArrayList;
import java.util.List;

public class RookMove implements IMove {
    /**
     * initiate the function that will move
     * the pieces on the board according
     * to his position
     * @param p
     * @param chessBoard
     * @return
     */
    @Override
    public List<IChess.ChessPosition> getMove(IChess.ChessPosition p, Board chessBoard) {
        int x = p.x;
        int y = p.y;
        ArrayList<IChess.ChessPosition> position = new ArrayList<IChess.ChessPosition>();
        for (int i = p.x+1; i < 8; i++){
            IChess.ChessPosition pos = new IChess.ChessPosition();
            pos.y = y;
            pos.x = i;
            if (chessBoard.getPiece(pos.x, pos.y) != null ){
                if (chessBoard.getPiece(pos.x, pos.y).getColor() != chessBoard.getPiece(p.x, p.y).getColor())
                    position.add(pos);
                break;
            }
            else
                position.add(pos);
        }
        for (int i = p.x-1; i >= 0; i--){
            IChess.ChessPosition pos = new IChess.ChessPosition();
            pos.y = y;
            pos.x = i;
            if (chessBoard.getPiece(pos.x, pos.y) != null ){
                if (chessBoard.getPiece(pos.x, pos.y).getColor() != chessBoard.getPiece(p.x, p.y).getColor())
                    position.add(pos);
                break;
            }
            else
                position.add(pos);
        }
        for (int i = p.y-1; i >= 0; i--){
            IChess.ChessPosition pos = new IChess.ChessPosition();
            pos.y = i;
            pos.x = x;
            if (chessBoard.getPiece(pos.x, pos.y) != null ){
                if (chessBoard.getPiece(pos.x, pos.y).getColor() != chessBoard.getPiece(p.x, p.y).getColor())
                    position.add(pos);
                break;
            }
            else
                position.add(pos);
        }
        for (int i = p.y+1; i < 8; i++){
            IChess.ChessPosition pos = new IChess.ChessPosition();
            pos.y = i;
            pos.x = x;
            if (chessBoard.getPiece(pos.x, pos.y) != null ){
                if (chessBoard.getPiece(pos.x, pos.y).getColor() != chessBoard.getPiece(p.x, p.y).getColor())
                    position.add(pos);
                break;
            }
            else
                position.add(pos);
        }
        return position;
    }
}