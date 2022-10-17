import com.company.main.Battleships;
import com.company.main.Fleet;
import com.company.main.Gameboard;
import com.company.main.Player;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class OthersTest {
    @Test
    @DisplayName("Player: Проверка уничтожения всех кораблей")
    void testAllShipsSunk() {
        Player player = new Player(1);

        Gameboard gameboard = new Gameboard();
        char[][] gm = gameboard.getGameBoard();
        char[][] empty = new char[10][10];
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                empty[i][j] = '~';
            }
        }

        Battleships battleships = new Battleships(Fleet.values()[0].name(), Fleet.values()[0].getLength());
        battleships.storeShipCoordinates(3,3);
        battleships.storeShipCoordinates(3,4);
        battleships.storeShipCoordinates(3,5);
        battleships.storeShipCoordinates(3,6);
        battleships.storeShipCoordinates(3,7);

        player.ships.add(battleships);
        battleships.removeShipCoordinate(3,3);
        battleships.removeShipCoordinate(3,4);
        battleships.removeShipCoordinate(3,5);
        battleships.removeShipCoordinate(3,6);
        battleships.removeShipCoordinate(3,7);

        assertTrue(player.allShipsSunk());
    }

    @Test
    @DisplayName("Player: Проверка не уничтожения всех кораблей")
    void testAllShipsSunkFalse() {
        Player player = new Player(1);

        Gameboard gameboard = new Gameboard();
        char[][] gm = gameboard.getGameBoard();
        char[][] empty = new char[10][10];
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                empty[i][j] = '~';
            }
        }

        Battleships battleships = new Battleships(Fleet.values()[0].name(), Fleet.values()[0].getLength());
        battleships.storeShipCoordinates(3,3);
        battleships.storeShipCoordinates(3,4);
        battleships.storeShipCoordinates(3,5);
        battleships.storeShipCoordinates(3,6);
        battleships.storeShipCoordinates(3,7);

        player.ships.add(battleships);
        battleships.removeShipCoordinate(3,3);
        battleships.removeShipCoordinate(3,4);
        battleships.removeShipCoordinate(3,5);

        assertFalse(player.allShipsSunk());
    }
}
