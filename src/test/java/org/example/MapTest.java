package org.example;


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
            map.moveToNextArea();
        }
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

        // Check if the second area has enemies
        assertNotEquals(0, map.getAreas().get(1).getNbEnemies());
    }
}