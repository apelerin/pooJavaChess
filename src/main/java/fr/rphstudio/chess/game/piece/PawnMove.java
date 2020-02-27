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
        ArrayList<IChess.ChessPosition> position = new ArrayList<IChess.ChessPosition>();

        IChess.ChessPosition pos = new IChess.ChessPosition(x,y);

        if (chessBoard.getPiece(x, y).getColor() == IChess.ChessColor.CLR_WHITE && p.y == 6){
            if (chessBoard.getPiece(pos.x, pos.y-1) == null ) {
                IChess.ChessPosition pos1 = new IChess.ChessPosition(x, y - 1);
                position.add(pos1);
                if (chessBoard.getPiece(pos.x, pos.y - 2) == null) {
                    IChess.ChessPosition pos2 = new IChess.ChessPosition(pos.x, pos.y - 2);
                    position.add(pos2);
                }
            }
                if (x-1 >= 0 && y-1 >= 0 && chessBoard.getPiece(x-1, y-1) != null && chessBoard.getPiece(x-1, y-1).getColor() != chessBoard.getPiece(x, y).getColor()){
                    IChess.ChessPosition pos3 = new IChess.ChessPosition(pos.x, pos.y);
                    pos3.x = x-1;
                    pos3.y = y-1;
                    position.add(pos3);
                }
                if (x+1 < 8 && y-1 >= 0 && chessBoard.getPiece(x+1, y-1) != null && chessBoard.getPiece(x+1, y-1).getColor() != chessBoard.getPiece(x, y).getColor()){
                    IChess.ChessPosition pos4 = new IChess.ChessPosition(pos.x, pos.y);
                    pos4.x = x+1;
                    pos4.y = y-1;
                    position.add(pos4);
                }
        }
        else if (chessBoard.getPiece(x, y).getColor() == IChess.ChessColor.CLR_BLACK && p.y == 1){
            if (chessBoard.getPiece(pos.x, pos.y+1) == null ) {
                IChess.ChessPosition pos1 = new IChess.ChessPosition(x, y + 1);
                position.add(pos1);
                if (chessBoard.getPiece(pos.x, pos.y+2) == null) {
                    IChess.ChessPosition pos2 = new IChess.ChessPosition(pos.x, pos.y);
                    pos2.y= pos2.y+2;
                    position.add(pos2);
                }
            }
                if (x-1 >= 0 && y+1 < 8 && chessBoard.getPiece(x-1, y+1) != null && chessBoard.getPiece(x-1, y+1).getColor() != chessBoard.getPiece(x, y).getColor()){
                    IChess.ChessPosition pos3 = new IChess.ChessPosition(pos.x, pos.y);
                    pos3.x = x-1;
                    pos3.y = y+1;
                    position.add(pos3);
                }
                if (x+1 < 8 && y+1 < 8 && chessBoard.getPiece(x+1, y+1) != null && chessBoard.getPiece(x+1, y+1).getColor() != chessBoard.getPiece(x, y).getColor()){
                    IChess.ChessPosition pos4 = new IChess.ChessPosition(pos.x, pos.y);
                    pos4.x = x+1;
                    pos4.y = y+1;
                    position.add(pos4);
                }
        }
        else if (chessBoard.getPiece(x, y).getColor() == IChess.ChessColor.CLR_BLACK){
            if (chessBoard.getPiece(pos.x, pos.y+1) == null ) {
                IChess.ChessPosition pos1 = new IChess.ChessPosition(x, y+1);
                position.add(pos1);
            }
            if (x-1 >= 0 && y+1 < 8 && chessBoard.getPiece(x-1, y+1) != null && chessBoard.getPiece(x-1, y+1).getColor() != chessBoard.getPiece(x, y).getColor()){
                IChess.ChessPosition pos3 = new IChess.ChessPosition(pos.x, pos.y);
                pos3.x = x-1;
                pos3.y = y+1;
                position.add(pos3);
            }
            if (x+1 < 8 && y+1 < 8 && chessBoard.getPiece(x+1, y+1) != null && chessBoard.getPiece(x+1, y+1).getColor() != chessBoard.getPiece(x, y).getColor()){
                IChess.ChessPosition pos4 = new IChess.ChessPosition(pos.x, pos.y);
                pos4.x = x+1;
                pos4.y = y+1;
                position.add(pos4);
            }
        }
        else if (chessBoard.getPiece(x, y).getColor() == IChess.ChessColor.CLR_WHITE){
            if (chessBoard.getPiece(pos.x, pos.y-1) == null ) {
                IChess.ChessPosition pos1 = new IChess.ChessPosition(x, y-1);
                position.add(pos1);
            }
            if (x-1 >= 0 && y-1 >= 0 && chessBoard.getPiece(x-1, y-1) != null && chessBoard.getPiece(x-1, y-1).getColor() != chessBoard.getPiece(x, y).getColor()){
                IChess.ChessPosition pos3 = new IChess.ChessPosition(pos.x-1, pos.y-1);
                position.add(pos3);
            }
            if (x+1 < 8 && y-1 >= 0 && chessBoard.getPiece(x+1, y-1) != null && chessBoard.getPiece(x+1, y-1).getColor() != chessBoard.getPiece(x, y).getColor()){
                IChess.ChessPosition pos4 = new IChess.ChessPosition(pos.x+1, pos.y-1);
                position.add(pos4);
            }
        }
        return position;
    }
}
