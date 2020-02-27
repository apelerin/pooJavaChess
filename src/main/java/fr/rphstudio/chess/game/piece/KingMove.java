package fr.rphstudio.chess.game.piece;
import fr.rphstudio.chess.game.Board;
import fr.rphstudio.chess.interf.IChess;
import fr.rphstudio.chess.interf.IMove;
import java.util.ArrayList;
import java.util.List;

import static fr.rphstudio.chess.interf.IChess.ChessType.TYP_ROOK;

public class KingMove implements IMove {
    @Override
    public List<IChess.ChessPosition> getMove(IChess.ChessPosition p, Board chessBoard) {
        int x = p.x;
        int y = p.y;
        //bas
        IChess.ChessPosition pos = new IChess.ChessPosition(x, y+1);
        //bas droite
        IChess.ChessPosition pos1 = new IChess.ChessPosition(x+1, y+1);
        //droite
        IChess.ChessPosition pos2 = new IChess.ChessPosition(x+1, y);
        //haut droite
        IChess.ChessPosition pos3 = new IChess.ChessPosition(x+1, y-1);
        //haut
        IChess.ChessPosition pos4 = new IChess.ChessPosition(x, y-1);
        //haut gauche
        IChess.ChessPosition pos5 = new IChess.ChessPosition(x-1, y-1);
        //gauche
        IChess.ChessPosition pos6 = new IChess.ChessPosition(x-1, y);
        //bas gauche
        IChess.ChessPosition pos7 = new IChess.ChessPosition(x-1, y+1);
        ArrayList<IChess.ChessPosition> position = new ArrayList<IChess.ChessPosition>();

        if (pos.y < 8){
            if (chessBoard.getPiece(pos.x, pos.y) != null){
                if (chessBoard.getPiece(pos.x, pos.y).getColor() != chessBoard.getPiece(x, y).getColor()){
                    position.add(pos);
                }
            }
            else
                position.add(pos);
        }

        if (pos1.y < 8 && pos1.x < 8){
            if (chessBoard.getPiece(pos1.x, pos1.y) != null){
                if (chessBoard.getPiece(pos1.x, pos1.y).getColor() != chessBoard.getPiece(x, y).getColor()){
                    position.add(pos1);
                }
            }
            else
                position.add(pos1);
        }

        if (pos2.y < 8){
            if (chessBoard.getPiece(pos2.x, pos2.y) != null){
                if (chessBoard.getPiece(pos2.x, pos2.y).getColor() != chessBoard.getPiece(x, y).getColor()){
                    position.add(pos2);
                }
            }
            else
                position.add(pos2);
        }

        if (pos3.x < 8 && pos3.y >= 0){
            if (chessBoard.getPiece(pos3.x, pos3.y) != null){
                if (chessBoard.getPiece(pos3.x, pos3.y).getColor() != chessBoard.getPiece(x, y).getColor()){
                    position.add(pos3);
                }
            }
            else
                position.add(pos3);
        }
        if (pos4.y >= 0 ){
            if (chessBoard.getPiece(pos4.x, pos4.y) != null){
                if (chessBoard.getPiece(pos4.x, pos4.y).getColor() != chessBoard.getPiece(x, y).getColor()){
                    position.add(pos4);
                }
            }
            else
                position.add(pos4);
        }
        if (pos5.x >= 0 && pos5.y >= 0){
            if (chessBoard.getPiece(pos5.x, pos5.y) != null){
                if (chessBoard.getPiece(pos5.x, pos5.y).getColor() != chessBoard.getPiece(x, y).getColor()){
                    position.add(pos5);
                }
            }
            else
                position.add(pos5);
        }
        if (pos6.x >= 0){
            if (chessBoard.getPiece(pos6.x, pos6.y) != null){
                if (chessBoard.getPiece(pos6.x, pos6.y).getColor() != chessBoard.getPiece(x, y).getColor()){
                    position.add(pos6);
                }
            }
            else
                position.add(pos6);
        }
        if (pos7.x >= 0 && pos7.y < 8){
            if (chessBoard.getPiece(pos7.x, pos7.y) != null){
                if (chessBoard.getPiece(pos7.x, pos7.y).getColor() != chessBoard.getPiece(x, y).getColor()){
                    position.add(pos7);
                }
            }
            else
                position.add(pos7);
        }
        checkShortCastle(p, chessBoard, position);
        checkLongCastle(p, chessBoard, position);

        return position;
    }

    public void checkShortCastle(IChess.ChessPosition p, Board chessBoard, ArrayList<IChess.ChessPosition> position){
        IChess.ChessPosition castleShort = new IChess.ChessPosition(p.x+3, p.y);
        if (chessBoard.getPiece(p.x, p.y).nbrMoves == 0 && chessBoard.getPiece(p.x+3, p.y).getType() == TYP_ROOK && chessBoard.getPiece(p.x+3, p.y).nbrMoves == 0){
            if (chessBoard.getPiece(p.x+1, p.y) == null && chessBoard.getPiece(p.x+2, p.y) == null){
                position.add(castleShort);
            }
        }
    }
    public void checkLongCastle(IChess.ChessPosition p, Board chessBoard, ArrayList<IChess.ChessPosition> position){
        IChess.ChessPosition castleShort = new IChess.ChessPosition(p.x-4, p.y);
        if (chessBoard.getPiece(p.x, p.y).nbrMoves == 0 && chessBoard.getPiece(p.x-4, p.y).getType() == TYP_ROOK && chessBoard.getPiece(p.x-4, p.y).nbrMoves == 0){
            if (chessBoard.getPiece(p.x-1, p.y) == null && chessBoard.getPiece(p.x-2, p.y) == null && chessBoard.getPiece(p.x-3, p.y) == null){
                position.add(castleShort);
            }
        }
    }
}