package com.company.main;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Main {

    public static void main(String[] args) {

        Player player1 = new Player(1);
        Player player2 = new Player(2);
        List<Player> gamePlayers = new ArrayList<>();
        gamePlayers.add(player1);
        gamePlayers.add(player2);

        Scanner input = new Scanner(System.in);
        String firstCoordinate;
        String secondCoordinate;
        int startRow = 0;
        int startCol = 0;
        int endRow = 0;
        int endCol = 0;

        for (Player player : gamePlayers) {
            System.out.println(player.name + ", расположите свои корабли");
            System.out.println();
            player.gameBoard.printGameBoard();

            for (Battleships ship : player.ships) {
                System.out.printf("Укажите координаты %s (%d cells):%n", ship.name, ship.length);
                System.out.println();
                boolean inputIsGood = false;

                while (!inputIsGood) {
                    firstCoordinate = input.next().toUpperCase();
                    secondCoordinate = input.next().toUpperCase();

                    if (firstCoordinate.length() > 3 || secondCoordinate.length() > 3 || convertRowInput(firstCoordinate) > 9 || convertColumnInput(firstCoordinate) > 9) {
                        System.out.printf("Ошибка! Координаты указаны неверно");
                        continue;
                    }

                    startRow = convertRowInput(firstCoordinate);
                    startCol = convertColumnInput(firstCoordinate);

                    endRow = convertRowInput(secondCoordinate);
                    endCol = convertColumnInput(secondCoordinate);

                    int choiceShipLength = Math.abs(startCol - endCol) + Math.abs(startRow - endRow) + 1;

                    if (choiceShipLength != ship.length) {
                        System.out.printf("Ошибка! Неправильная длина %s! Попробуйте снова:%n", ship.name);
                        continue;
                    }
                    if (player.gameBoard.checkProximity(startRow, startCol, endRow, endCol)) {
                        System.out.println("Ошибка! Вы расположили корабль слишком близко к другому кораблю. Попробуйте снова:");
                        continue;
                    }

                    inputIsGood = true;
                }

                player.gameBoard.updateBoard(startRow, startCol, endRow, endCol, ship);
                player.gameBoard.printGameBoard();
            }
            clearScreenAfterEnter(input);

        }
        System.out.println("Игра начинается!");
        System.out.println();

        Player[] playerArr = new Player[2];
        playerArr[0] = player1;
        playerArr[1] = player2;
        int currentPlayer = 0;
        int oppositePlayer = 1;

        boolean playerIsShot = false;

        boolean winGame = false;
        while(!winGame) {
            for (int i = 0; i < playerArr.length; i++) {
                playerArr[oppositePlayer].gameBoard.printFogOfWarBoard();
                System.out.println("---------------------");
                playerArr[currentPlayer].gameBoard.printGameBoard();
                System.out.println();
                System.out.println(playerArr[currentPlayer].name + ", ваш ход:");

                firstCoordinate = input.next().toUpperCase();
                startRow = convertRowInput(firstCoordinate);
                startCol = convertColumnInput(firstCoordinate);

                if (firstCoordinate.length() > 2 && startCol != 9) {
                    System.out.println("Ошибка! Вы ввели неправильные координаты! Попробуйте снова:");
                    continue;
                }
                if (startRow < 0 || startRow > 9 || startCol < 0 || startCol > 9) {
                    System.out.println("Ошибка! Вы ввели неправильные координаты! Попробуйте снова:");
                    continue;
                }
                boolean hitOne = (playerArr[oppositePlayer].gameBoard.takeAShot(startRow, startCol));
                playerArr[oppositePlayer].gameBoard.printFogOfWarBoard();

                if (hitOne) {
                    for (Battleships ship : playerArr[oppositePlayer].ships) {
                        if (ship.isShipHit(startRow, startCol)) {
                            ship.removeShipCoordinate(startRow, startCol);
                            //// -- -- - ///
                            //playerArr[oppositePlayer].gameBoard.getGameBoard()[startRow][startCol] = 'Ø';
                            if (ship.isShipSunk()) {
                                System.out.printf("Вы потопили %s! Выберите новую цель:%n", ship.name);
                            } else {
                                System.out.printf("Вы попали по кораблю %s! Попробуйте снова:%n", ship.name);
                            }
                        }
                    }

                    // попал
                    playerIsShot = true;

                } else {
                    playerIsShot = false;
                    System.out.printf("Вы промахнулись! Попробуйте снова!%n");
                }
                if (playerArr[oppositePlayer].allShipsSunk()) {
                    winGame = true;
                    endGame(playerArr[currentPlayer].name);
                }
                if (!playerIsShot) clearScreenAfterEnter(input);

                if (!playerIsShot) {
                    if (currentPlayer == 0) {
                        currentPlayer = 1;
                        oppositePlayer = 0;
                    } else {
                        currentPlayer = 0;
                        oppositePlayer = 1;
                    }
                }

            }
        }
        System.out.printf("Вы потопили последний вражеский корабль. Вы победили! Поздравляем%n");
    }
    public static int convertRowInput(String coordinate) {
        return coordinate.toUpperCase().charAt(0) - 65;
    }

    public static int convertColumnInput(String coordinate) {
        if (coordinate.length() > 2 && coordinate.startsWith("10", 1)) {
            return  9;
        } else {
            return coordinate.charAt(1) - 49;
        }
    }
    static void clearScreenAfterEnter(Scanner input) {
        System.out.println("Нажмите Enter и уступите ход другому игроку");
        String junk = input.nextLine();
        junk = input.nextLine();
        for (int i = 0; i < 30; i++) {
            System.out.println();
        }
    }
    static void endGame(String name) {
        System.out.printf("Вы потопили последний вражеский корабль. Вы победили! Поздравляем %s!%n", name);
        System.exit(0);
    }
}
