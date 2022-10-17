package com.company.main;

import java.util.ArrayList;
import java.util.List;

public class Player {
    public Gameboard gameBoard;
    public List<Battleships> ships;
    String name = "Игрок ";

    Player(int num) {
        this.gameBoard = new Gameboard();
        this.name += num;
        this.ships = new ArrayList<>();
        for (Fleet craft : Fleet.values()) {
            Battleships tempShip = new Battleships(craft.name, craft.length);
            ships.add(tempShip);
        }
    }
}
