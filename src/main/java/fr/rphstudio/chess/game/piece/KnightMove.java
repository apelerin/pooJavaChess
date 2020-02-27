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
        IChess.ChessPosition pos1 = new IChess.ChessPosition(x+1, y-2);
        IChess.ChessPosition pos2 = new IChess.ChessPosition(x-1, y-2);
        IChess.ChessPosition pos3 = new IChess.ChessPosition(x+2, y-1);
        IChess.ChessPosition pos4 = new IChess.ChessPosition(x-2, y-1);
        IChess.ChessPosition pos5 = new IChess.ChessPosition(x-2, y+1);
        IChess.ChessPosition pos6 = new IChess.ChessPosition(x-1, y+2);
        IChess.ChessPosition pos7 = new IChess.ChessPosition(x+2, y+1);
        IChess.ChessPosition pos8 = new IChess.ChessPosition(x+1, y+2);
        if (pos1.x < 8 && pos1.y >= 0){
            if (chessBoard.getPiece(pos1.x, pos1.y) != null){
                if (chessBoard.getPiece(pos1.x, pos1.y).getColor() != chessBoard.getPiece(x, y).getColor()){
                    position.add(pos1);
                }
            }
            else
                position.add(pos1);
        }
        if (pos2.x >= 0 && pos2.y >= 0) {
            if (chessBoard.getPiece(pos2.x, pos2.y) != null) {
                if (chessBoard.getPiece(pos2.x, pos2.y).getColor() != chessBoard.getPiece(x, y).getColor()) {
                    position.add(pos2);
                }
            }
            else
                position.add(pos2);
        }
        if (pos3.x < 8 && pos3.y >= 0) {
            if (chessBoard.getPiece(pos3.x, pos3.y) != null) {
                if (chessBoard.getPiece(pos3.x, pos3.y).getColor() != chessBoard.getPiece(x, y).getColor()) {
                    position.add(pos3);
                }
            }
            else
                position.add(pos3);
        }
        if (pos4.x >=0 && pos4.y >= 0) {
            if (chessBoard.getPiece(pos4.x, pos4.y) != null) {
                if (chessBoard.getPiece(pos4.x, pos4.y).getColor() != chessBoard.getPiece(x, y).getColor()) {
                    position.add(pos4);
                }
            } else
                position.add(pos4);
        }
        if (pos5.x >=0 && pos5.y < 8) {
            if (chessBoard.getPiece(pos5.x, pos5.y) != null) {
                if (chessBoard.getPiece(pos5.x, pos5.y).getColor() != chessBoard.getPiece(x, y).getColor()) {
                    position.add(pos5);
                }
            }
            else
                position.add(pos5);
        }
        if (pos6.x >=0 && pos6.y < 8) {
            if (chessBoard.getPiece(pos6.x, pos6.y) != null) {
                if (chessBoard.getPiece(pos6.x, pos6.y).getColor() != chessBoard.getPiece(x, y).getColor()) {
                    position.add(pos6);
                }
            }
            else
                position.add(pos6);
        }
        if (pos7.x < 8 && pos7.y < 8) {
            if (chessBoard.getPiece(pos7.x, pos7.y) != null) {
                if (chessBoard.getPiece(pos7.x, pos7.y).getColor() != chessBoard.getPiece(x, y).getColor()) {
                    position.add(pos7);
                }
            }
            else
                position.add(pos7);
        }
        if (pos8.x < 8 && pos8.y < 8) {
            if (chessBoard.getPiece(pos8.x, pos8.y) != null) {
                if (chessBoard.getPiece(pos8.x, pos8.y).getColor() != chessBoard.getPiece(x, y).getColor()) {
                    position.add(pos8);
                }
            }
            else
                position.add(pos8);
        }
        return position;
    }
}
