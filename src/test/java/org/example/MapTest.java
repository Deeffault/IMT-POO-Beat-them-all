package org.example;

import org.example.characters.Hero;
import org.example.characters.SpecialCapacity;
import org.example.utils.Map;
import org.junit.jupiter.api.Test;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import static org.junit.jupiter.api.Assertions.*;

class MapTest {
    private static final Logger logger = LogManager.getLogger(MapTest.class);

    @Test
    void isEndOfMap() {
        Map map = new Map("Map de Test", 1, 7);
        for (int i = 0; i <= map.getLength() - 1; i++) {
            logger.info("Current position: " + map.getCurrentPosition());
            map.moveToNextArea();
        }
        logger.info("Is end of map: " + map.isEndOfMap());
        assertTrue(map.isEndOfMap());

    }

    @Test
    void generateAreas() {
        Map map = new Map("Map de Test", 1, 2);
        assertEquals(2, map.getAreasSize());
    }

    @Test
    void generateEnemies() {
        Map map = new Map("Map de Test", 1, 3);

        // Check if the first area has enemies
        assertNotEquals(0, map.getAreas().get(2).getNbEnemies());
    }
}