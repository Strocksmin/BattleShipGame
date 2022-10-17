import com.company.main.Battleships;
import com.company.main.Fleet;
import com.company.main.Gameboard;
import com.company.main.Player;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static com.company.main.Main.convertColumnInput;
import static com.company.main.Main.convertRowInput;
import static org.junit.Assert.*;

public class OthersTest {
    @Test
    @DisplayName("Player: Проверка уничтожения всех кораблей")
    void testAllShipsSunk() {
        Player player = new Player(1);

        Battleships battleships1 = new Battleships(Fleet.values()[0].name(), Fleet.values()[0].getLength());
        battleships1.storeShipCoordinates(3,3);
        battleships1.storeShipCoordinates(3,4);
        battleships1.storeShipCoordinates(3,5);
        battleships1.storeShipCoordinates(3,6);
        battleships1.storeShipCoordinates(3,7);

        player.ships.add(battleships1);
        battleships1.removeShipCoordinate(3,3);
        battleships1.removeShipCoordinate(3,4);
        battleships1.removeShipCoordinate(3,5);
        battleships1.removeShipCoordinate(3,6);
        battleships1.removeShipCoordinate(3,7);

        assertTrue(player.allShipsSunk());
    }

    @Test
    @DisplayName("Player: Проверка не уничтожения всех кораблей")
    void testAllShipsSunkFalse() {
        Player player = new Player(1);

        Battleships battleships1 = new Battleships(Fleet.values()[0].name(), Fleet.values()[0].getLength());
        battleships1.storeShipCoordinates(3,3);
        battleships1.storeShipCoordinates(3,4);
        battleships1.storeShipCoordinates(3,5);
        battleships1.storeShipCoordinates(3,6);
        battleships1.storeShipCoordinates(3,7);

        player.ships.add(battleships1);
        battleships1.removeShipCoordinate(3,3);
        battleships1.removeShipCoordinate(3,4);
        battleships1.removeShipCoordinate(3,5);

        assertFalse(player.allShipsSunk());
    }

    @Test
    @DisplayName("Main: Проверка конвертирования ввода координат по x")
    void testConvertRowInput() {
        assertEquals(convertRowInput("J3"), 9);
        assertEquals(convertRowInput("j3"), 9);
        assertEquals(convertRowInput("A5"), 0);
    }



    @Test
    @DisplayName("Main: Проверка конвертирования ввода координат по y")
    void testConvertColumnInput() {
        assertEquals(convertColumnInput("J3"), 2);
        assertEquals(convertColumnInput("j3"), 2);
        assertEquals(convertColumnInput("A5"), 4);
    }

    @Test
    @DisplayName("Main: Проверка игры")
    void testGame() {
        Player player1 = new Player(1);
        Player player2 = new Player(2);

        Gameboard gameboard = new Gameboard();
        char[][] gm1 = player1.gameBoard.getGameBoard();
        char[][] gm2 = player2.gameBoard.getGameBoard();

        Battleships battleships1 = new Battleships(Fleet.values()[0].name(), Fleet.values()[0].getLength());
        battleships1.storeShipCoordinates(convertRowInput("C3"), convertColumnInput("C3"));
        battleships1.storeShipCoordinates(convertRowInput("C3"), convertColumnInput("C4"));
        battleships1.storeShipCoordinates(convertRowInput("C3"), convertColumnInput("C5"));
        battleships1.storeShipCoordinates(convertRowInput("C3"), convertColumnInput("C6"));
        battleships1.storeShipCoordinates(convertRowInput("C3"), convertColumnInput("C7"));

        Battleships battleships2 = new Battleships(Fleet.values()[0].name(), Fleet.values()[0].getLength());
        battleships2.storeShipCoordinates(convertRowInput("A3"), convertColumnInput("A3"));
        battleships2.storeShipCoordinates(convertRowInput("A3"), convertColumnInput("A4"));
        battleships2.storeShipCoordinates(convertRowInput("A3"), convertColumnInput("A5"));
        battleships2.storeShipCoordinates(convertRowInput("A3"), convertColumnInput("A6"));
        battleships2.storeShipCoordinates(convertRowInput("A3"), convertColumnInput("A7"));

        player1.ships.add(battleships1);
        battleships1.removeShipCoordinate(convertRowInput("C3"), convertColumnInput("C3"));
        battleships1.removeShipCoordinate(convertRowInput("C3"), convertColumnInput("C4"));
        battleships1.removeShipCoordinate(convertRowInput("C3"), convertColumnInput("C5"));
        battleships1.removeShipCoordinate(convertRowInput("C3"), convertColumnInput("C6"));
        battleships1.removeShipCoordinate(convertRowInput("C3"), convertColumnInput("C7"));

        player2.ships.add(battleships2);
        battleships2.removeShipCoordinate(convertRowInput("A3"), convertColumnInput("A3"));
        battleships2.removeShipCoordinate(convertRowInput("A3"), convertColumnInput("A4"));
        battleships2.removeShipCoordinate(convertRowInput("A3"), convertColumnInput("A5"));
        battleships2.removeShipCoordinate(convertRowInput("A3"), convertColumnInput("A6"));

        assertTrue(player1.allShipsSunk());
        assertFalse(player2.allShipsSunk());
    }
}
