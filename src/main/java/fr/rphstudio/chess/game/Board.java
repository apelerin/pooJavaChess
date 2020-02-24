package fr.rphstudio.chess.game;

import java.util.ArrayList;

public class Board {
    // TODO change type of the ArrayList to match pieces
    // TODO and complete the board correctly according to
    private ArrayList<String> pieceList;
    private int rowInitWhitePawn = 6;
    private int rangeInitBlackPawn = 1;
    private int[][] posInitWhiteTower = {{7, 0}, {7, 7}};
    private int[][] posInitBlackTower = {{0, 0}, {0, 7}};
    private int[][] postInitBlackKnight = {{0, 1}, {0, 6}};
    private int[][] postInitWhiteKnight = {{7, 1}, {7, 6}};
    private int[][] postInitBlackBishop = {{2, 0}, {0, 6}};
    private int[][] postInitWhiteBishop = {{7, 2}, {7, 5}};
    private int[] postInitBlackQueen = {0, 4};
    private int[] postInitWhiteQueen = {7, 3};
    private int[] postInitBlackKing = {0, 3};
    private int[] postInitWhiteKing = {7, 4};

    public Board() {
        for(int i = 0; i < 7; i++) {
            pieceList.add("WhitePawn" + );
        }
    }
}
