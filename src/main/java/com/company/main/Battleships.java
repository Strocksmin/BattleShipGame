package com.company.main;

import java.awt.*;
import java.util.HashSet;
import java.util.Set;

public class Battleships {
    String name;
    int length;
    Set<Point> shipsCoordinates;

    Battleships(String name, int length) {
        this.name = name;
        this.length = length;
        shipsCoordinates = new HashSet<>();
    }
}
