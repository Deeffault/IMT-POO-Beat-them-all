package org.example.utils;

import org.example.utils.Area;

import java.util.ArrayList;

public class Map {
    public String getName() {
        return name;
    }

    private String name;
    private int start;
    private int end;
    private int length;

    public int getCurrentPosition() {
        return currentPosition;
    }

    private int currentPosition;
    private ArrayList<Area> areas;

    public Map(String name, int start, int end) {
        this.name = name;
        this.start = start;
        this.end = end;
        this.length = end - start + 1;
        this.currentPosition = start;
        this.areas = new ArrayList<>();
        initialize();
    }

    private void initialize() {
        generateAreas();
    }

    public boolean isEndOfMap() {
        return currentPosition > end;
    }

    private void generateAreas() {
        for (int i = start; i <= end; i++) {
            Area newArea = new Area();
            newArea.generateEnemies();
            areas.add(newArea);
        }
    }


    // Getters and setters
    // ...

    public Area getCurrentArea() {
        if (currentPosition >= start && currentPosition <= end) {
            return areas.get(currentPosition - start);
        }
        return null;
    }

    public void moveToNextArea() {
        if (!isEndOfMap()) {
            currentPosition++;
        }
    }
}
