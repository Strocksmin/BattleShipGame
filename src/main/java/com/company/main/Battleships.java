package com.company.main;

import java.awt.*;
import java.util.HashSet;
import java.util.Set;

public class Battleships {
    String name;
    int length;
    Set<Point> shipsCoordinates;

    public Battleships(String name, int length) {
        this.name = name;
        this.length = length;
        shipsCoordinates = new HashSet<>();
    }

    public Set<Point> getShipsCoordinates() {
        return shipsCoordinates;
    }

    public void storeShipCoordinates(int row, int col) {

    }
}
