package com.company.main;

public class Gameboard {
    private char[][] gameBoard;
    private char[][] fogOfWarBoard;
    private String[] columnHeader;
    private String[] rowHeader;

    Gameboard() {
        gameBoard = new char[10][10];
        fogOfWarBoard = new char[10][10];
        columnHeader = new String[]{
                " ", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10"};
        rowHeader = new String[]{
                "A", "B", "C", "D", "E", "F", "G", "H", "I", "J"};

        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                gameBoard[i][j] = '~';
                fogOfWarBoard[i][j] = '~';
            }
        }
    }
}
