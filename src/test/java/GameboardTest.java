import com.company.main.Battleships;
import com.company.main.Fleet;
import com.company.main.Gameboard;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class GameboardTest {

    @Test
    @DisplayName("Проверка обновления игровой доски по горизонтали")
    void testUpdateBoardCol() {
        Gameboard gameboard = new Gameboard();
        char[][] gm = gameboard.getGameBoard();
        char[][] empty = new char[10][10];
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                empty[i][j] = '~';
            }
        }
        for (int i = 0; i < 10; i++) {
            assertTrue(Arrays.equals(empty[i], gm[i]));
        }
        Battleships battleships = new Battleships(Fleet.values()[0].name(), Fleet.values()[0].getLength());
        battleships.storeShipCoordinates(3,3);
        battleships.storeShipCoordinates(3,4);
        battleships.storeShipCoordinates(3,5);
        battleships.storeShipCoordinates(3,6);
        battleships.storeShipCoordinates(3,7);
        gameboard.updateBoard(3, 3,3,7, battleships);
        for (int i = 3; i <= 7; i++) {
            empty[3][i] = 'O';
        }
        for (int i = 0; i < 10; i++) {
            assertTrue(Arrays.equals(empty[i],gm[i]));
        }
    }

    @Test
    @DisplayName("Проверка обновления игровой доски по вертикали")
    void testUpdateBoardRow() {
        Gameboard gameboard = new Gameboard();
        char[][] gm = gameboard.getGameBoard();
        char[][] empty = new char[10][10];
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                empty[i][j] = '~';
            }
        }
        for (int i = 0; i < 10; i++) {
            assertTrue(Arrays.equals(empty[i], gm[i]));
        }
        Battleships battleships = new Battleships(Fleet.values()[0].name(), Fleet.values()[0].getLength());
        battleships.storeShipCoordinates(3,3);
        battleships.storeShipCoordinates(4,3);
        battleships.storeShipCoordinates(5,3);
        battleships.storeShipCoordinates(6,3);
        battleships.storeShipCoordinates(7,3);
        gameboard.updateBoard(3, 3,7,3, battleships);
        for (int i = 3; i <= 7; i++) {
            empty[i][3] = 'O';
        }
        for (int i = 0; i < 10; i++) {
            assertTrue(Arrays.equals(empty[i], gm[i]));
        }
    }

    @Test
    @DisplayName("Проверка близости двух кораблей")
    void testCheckProximity() {
        Gameboard gameboard = new Gameboard();
        char[][] gm = gameboard.getGameBoard();
        char[][] empty = new char[10][10];

        Battleships battleships = new Battleships(Fleet.values()[0].name(), Fleet.values()[0].getLength());
        battleships.storeShipCoordinates(3,3);
        battleships.storeShipCoordinates(4,3);
        battleships.storeShipCoordinates(5,3);
        battleships.storeShipCoordinates(6,3);
        battleships.storeShipCoordinates(7,3);
        gameboard.updateBoard(3, 3,7,3, battleships);
        assertFalse(gameboard.checkProximity(3, 5, 7, 5));
        assertTrue(gameboard.checkProximity(3, 3,7,3));
        assertTrue(gameboard.checkProximity(3, 4,7,4));
        assertTrue(gameboard.checkProximity(3, 1,5,5));
        assertFalse(gameboard.checkProximity(7, 5,7,5));
        assertFalse(gameboard.checkProximity(7, 5,9,9));
    }
}
