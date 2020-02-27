
package fr.rphstudio.chess.game.piece;

import fr.rphstudio.chess.game.Board;
import fr.rphstudio.chess.interf.IChess;
import fr.rphstudio.chess.interf.IMove;

import java.util.ArrayList;
import java.util.List;

public class QueenMove implements IMove {
    /**
     * initiate the function that will move
     * the pieces on the board according
     * to his position
     * @param p
     * @param chessBoard
     * @return
     */
    @Override
    // Il prend en paramètre la position de la pièce sur laquelle on a cliqué, et le board
    public List<IChess.ChessPosition> getMove(IChess.ChessPosition p, Board chessBoard) {
        //On créer des variables qui contiennent la position de la pièce cliquée
        int x = p.x; //horizontale
        int y = p.y; //verticale
        //On créer une liste de ChessPosition
        ArrayList<IChess.ChessPosition> position = new ArrayList<IChess.ChessPosition>();
        //On fait la droite de la pièce
        for (int i = p.x+1; i < 8; i++){
            //On créer une nouvelle position
            IChess.ChessPosition pos = new IChess.ChessPosition();
            //On créer les variables égales aux axes de la position de la pièce
            pos.y = y;
            pos.x = i;
            //Si on rencontre une pièce, alors on s'arrête à la position de cette pièce, on peut la prendre si elle est d'une couleur différente
            if (chessBoard.getPiece(pos.x, pos.y) != null ){
                if (chessBoard.getPiece(pos.x, pos.y).getColor() != chessBoard.getPiece(p.x, p.y).getColor())
                    position.add(pos);
                break;
            }
            else
                //On ajoute la nouvelle position à la liste de positions créées si il n'y a rien sur cette case
                position.add(pos);
        }
            //La même pour la gauche
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
        //La même pour le haut
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
        //La même pour le bas
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
