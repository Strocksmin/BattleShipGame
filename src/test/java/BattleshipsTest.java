import com.company.main.Battleships;
import com.company.main.Fleet;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.awt.*;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class BattleshipsTest {

    @Test
    @DisplayName("Проверка хранения координаты корабля")
    void testStoreShipCoordinates() {
        Battleships battleships = new Battleships(Fleet.values()[0].name(), Fleet.values()[0].getLength());
        battleships.storeShipCoordinates(3,3);
        assertEquals(1, battleships.getShipsCoordinates().size());
    }

    @Test
    @DisplayName("Проверка удаления координаты корабля")
    void testRemoveShipCoordinate() {
        Battleships battleships = new Battleships(Fleet.values()[0].name(), Fleet.values()[0].getLength());
        battleships.storeShipCoordinates(3,3);
        battleships.storeShipCoordinates(3,4);
        battleships.removeShipCoordinate(3,4);
        assertEquals(1, battleships.getShipsCoordinates().size());
    }

    @Test
    @DisplayName("Проверка попадания по кораблю")
    void testIsShipHit() {
        Battleships battleships = new Battleships(Fleet.values()[0].name(), Fleet.values()[0].getLength());
        battleships.storeShipCoordinates(3,3);
        assertTrue(battleships.isShipHit(3,3));
    }

    @Test
    @DisplayName("Проверка потопления корабля")
    void testIsShipSunk() {
        Battleships battleships = new Battleships(Fleet.values()[0].name(), Fleet.values()[0].getLength());
        battleships.storeShipCoordinates(3,3);
        battleships.removeShipCoordinate(3,3);
        assertTrue(battleships.isShipSunk());
    }

}
