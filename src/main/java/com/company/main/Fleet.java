package com.company.main;

public enum Fleet {
    AIRCRAFT_CARRIER("Aircraft Carrier", 5),
    BATTLESHIP("Battleship", 4),
    SUBMARINE("Submarine", 3),
    CRUISER("Cruiser", 3),
    DESTROYER("Destroyer", 2);

    String name;
    int length;

    Fleet(String name, int length) {
        this.name = name;
        this.length = length;

    }

    public int getLength() {
        return length;
    }
}
