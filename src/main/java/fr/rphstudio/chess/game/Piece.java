package fr.rphstudio.chess.game;

import fr.rphstudio.chess.interf.IChess.*;

public class Piece{
    private ChessType chessType;
    private ChessColor chessColor;

    public ChessType getType() {
        return this.chessType;
    }
    public ChessColor getColor() {
        return this.chessColor;
    }

    public Piece(ChessType type, ChessColor color) {
        this.chessType = type;
        this.chessColor = color;
    }
}

