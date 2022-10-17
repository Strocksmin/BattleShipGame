import com.company.main.Battleships;
import com.company.main.Fleet;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.awt.*;

import static org.junit.Assert.assertEquals;

public class BattleshipsTest {

    @Test
    @DisplayName("Проверка хранения координаты корабля")
    void testStoreShipCoordinates() {
        Battleships battleships = new Battleships(Fleet.values()[0].name(), Fleet.values()[0].getLength());
        battleships.storeShipCoordinates(3,3);
        assertEquals(1, battleships.getShipsCoordinates().size());
    }

}
