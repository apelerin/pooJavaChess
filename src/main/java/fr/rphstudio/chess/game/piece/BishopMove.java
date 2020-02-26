package fr.rphstudio.chess.game.piece;

import fr.rphstudio.chess.game.Board;
import fr.rphstudio.chess.interf.IChess;
import fr.rphstudio.chess.interf.IMove;

import java.util.ArrayList;
import java.util.List;

public class BishopMove implements IMove {

    @Override
    // Il prend en paramètre la position de la pièce sur laquelle on a cliqué, et le board
    public List<IChess.ChessPosition> getMove(IChess.ChessPosition p, Board chessBoard) {
        //On créer des variables qui contiennent la position de la pièce cliquée
        int x = p.x; //horizontale
        int y = p.y; //verticale
        //On créer une liste de ChessPosition
        ArrayList<IChess.ChessPosition> position = new ArrayList<IChess.ChessPosition>();
        //On fait la droite de la pièce
        for (int i = p.y-1, j = p.x+1; i >= 0 && j < 8; i--, j++){
            IChess.ChessPosition pos = new IChess.ChessPosition();
            pos.y = i;
            pos.x = j;
            if (chessBoard.getPiece(pos.x, pos.y) != null ){
                if (chessBoard.getPiece(pos.x, pos.y).getColor() != chessBoard.getPiece(p.x, p.y).getColor())
                    position.add(pos);
                break;
            }
            else
                position.add(pos);
        }

        //Diagonale haut droite
        for (int i = p.y-1, j = p.x+1; i >= 0 && j < 8; i--, j++){
            IChess.ChessPosition pos = new IChess.ChessPosition();
            pos.y = i;
            pos.x = j;
            if (chessBoard.getPiece(pos.x, pos.y) != null ){
                if (chessBoard.getPiece(pos.x, pos.y).getColor() != chessBoard.getPiece(p.x, p.y).getColor())
                    position.add(pos);
                break;
            }
            else
                position.add(pos);
        }
        //Diagonale haut gauche
        for (int i = p.y-1, j = p.x-1; i >= 0 && j >= 0; i--, j--){
            IChess.ChessPosition pos = new IChess.ChessPosition();
            pos.y = i;
            pos.x = j;
            if (chessBoard.getPiece(pos.x, pos.y) != null ){
                if (chessBoard.getPiece(pos.x, pos.y).getColor() != chessBoard.getPiece(p.x, p.y).getColor())
                    position.add(pos);
                break;
            }
            else
                position.add(pos);
        }
        //Diagonale bas gauche
        for (int i = p.y+1, j = p.x-1; i < 8 && j >= 0; i++, j--){
            IChess.ChessPosition pos = new IChess.ChessPosition();
            pos.y = i;
            pos.x = j;
            if (chessBoard.getPiece(pos.x, pos.y) != null ){
                if (chessBoard.getPiece(pos.x, pos.y).getColor() != chessBoard.getPiece(p.x, p.y).getColor())
                    position.add(pos);
                break;
            }
            else
                position.add(pos);
        }
        //Diagonale bas droite
        for (int i = p.y+1, j = p.x+1; i < 8 && j < 8; i++, j++){
            IChess.ChessPosition pos = new IChess.ChessPosition();
            pos.y = i;
            pos.x = j;
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
