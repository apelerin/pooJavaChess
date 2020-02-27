package fr.rphstudio.chess.game;

import fr.rphstudio.chess.game.piece.*;
import fr.rphstudio.chess.interf.IChess.*;
import fr.rphstudio.chess.interf.IMove;

public class Piece{
    private ChessType chessType;
    private ChessColor chessColor;
    private IMove pieceMove;

    public ChessType getType() {
        return this.chessType;
    }
    public ChessColor getColor() {
        return this.chessColor;
    }
    public IMove getPieceMove() {
        return this.pieceMove;
    }
    public int nbrMoves = 0;

    public Piece(ChessType type, ChessColor color) {
        this.chessType = type;
        this.chessColor = color;
        switch (this.chessType) {
            case TYP_ROOK: this.pieceMove = new RookMove();
                break;
            case TYP_BISHOP: this.pieceMove = new BishopMove();
                break;
            case TYP_QUEEN: this.pieceMove = new QueenMove();
                break;
            case TYP_KING: this.pieceMove = new KingMove();
                break;
            case TYP_KNIGHT: this.pieceMove = new KnightMove();
                break;
            case TYP_PAWN: this.pieceMove = new PawnMove();
                break;
        }
    }

}

