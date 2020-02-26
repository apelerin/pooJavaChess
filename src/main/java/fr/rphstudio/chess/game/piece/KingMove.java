package fr.rphstudio.chess.game.piece;

import fr.rphstudio.chess.game.Board;
import fr.rphstudio.chess.interf.IChess;
import fr.rphstudio.chess.interf.IMove;

import java.util.ArrayList;
import java.util.List;

public class KingMove implements IMove {

    @Override
    public List<IChess.ChessPosition> getMove(IChess.ChessPosition p, Board chessBoard) {
        int x = p.x;
        int y = p.y;
        ArrayList<IChess.ChessPosition> position = new ArrayList<IChess.ChessPosition>();
        IChess.ChessPosition pos = new IChess.ChessPosition();
        pos.y = y;
        pos.x = x;
        if (chessBoard.getPiece(x, y).getColor() == IChess.ChessColor.CLR_WHITE && p.y == 6){
            if (chessBoard.getPiece(pos.x, pos.y-1) == null ){
                pos.y--;
                position.add(pos);
                if (chessBoard.getPiece(pos.x, pos.y-1) == null) {
                    IChess.ChessPosition pos2 = new IChess.ChessPosition(pos.x, pos.y);
                    pos2.y--;
                    position.add(pos2);
                }
                /*if (chessBoard.getPiece(x-1, y-1) != null){
                    IChess.ChessPosition pos3 = new IChess.ChessPosition(pos.x, pos.y);
                    pos.x = x-1;
                    pos.y = y-1;
                    position.add(pos3);
                }
                if (chessBoard.getPiece(x+1, y-1) != null){
                    IChess.ChessPosition pos4 = new IChess.ChessPosition(pos.x, pos.y);
                    pos.x = x+1;
                    pos.y = y-1;
                    position.add(pos4);
                }*/
            }
        }
        else if (chessBoard.getPiece(x, y).getColor() == IChess.ChessColor.CLR_BLACK && p.y == 1){
            if (chessBoard.getPiece(pos.x, pos.y+1) == null ){
                pos.y++;
                position.add(pos);
                if (chessBoard.getPiece(pos.x, pos.y+1) == null) {
                    IChess.ChessPosition pos2 = new IChess.ChessPosition(pos.x, pos.y);
                    pos2.y++;
                    position.add(pos2);
                }
                /*if (chessBoard.getPiece(x-1, y+1) != null){
                    IChess.ChessPosition pos3 = new IChess.ChessPosition(pos.x, pos.y);
                    pos.x = x-1;
                    pos.y = y+1;
                    position.add(pos3);
                }
                if (chessBoard.getPiece(x+1, y+1) != null){
                    IChess.ChessPosition pos4 = new IChess.ChessPosition(pos.x, pos.y);
                    pos.x = x+1;
                    pos.y = y+1;
                    position.add(pos4);
                }*/
            }
        }
        else if (chessBoard.getPiece(x, y).getColor() == IChess.ChessColor.CLR_BLACK){
            if (chessBoard.getPiece(pos.x, pos.y+1) == null ) {
                pos.y++;
                position.add(pos);
            }
            /*if (chessBoard.getPiece(x-1, y+1) != null){
                IChess.ChessPosition pos3 = new IChess.ChessPosition(pos.x, pos.y);
                pos.x = x-1;
                pos.y = y+1;
                position.add(pos3);
            }
            if (chessBoard.getPiece(x+1, y+1) != null){
                IChess.ChessPosition pos4 = new IChess.ChessPosition(pos.x, pos.y);
                pos.x = x+1;
                pos.y = y+1;
                position.add(pos4);
            }*/
        }
        else if (chessBoard.getPiece(x, y).getColor() == IChess.ChessColor.CLR_WHITE){
            if (chessBoard.getPiece(pos.x, pos.y-1) == null ) {
                pos.y--;
                position.add(pos);
            }
            /*if (chessBoard.getPiece(x-1, y-1) != null){
                IChess.ChessPosition pos3 = new IChess.ChessPosition(pos.x, pos.y);
                pos.x = x-1;
                pos.y = y-1;
                position.add(pos3);
            }
            if (chessBoard.getPiece(x+1, y-1) != null){
                IChess.ChessPosition pos4 = new IChess.ChessPosition(pos.x, pos.y);
                pos.x = x+1;
                pos.y = y-1;
                position.add(pos4);
            }*/
        }
        return position;
    }
}
