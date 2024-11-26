package org.example;

import java.util.ArrayList;

public class Map {

    String name;
    int start;
    int end;
    int length;
    int currentPosition;
    Area area;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public int getEnd() {
        return end;
    }

    public void setEnd(int end) {
        this.end = end;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public int getCurrentPosition() {
        return currentPosition;
    }

    public void setCurrentPosition(int currentPosition) {
        this.currentPosition = currentPosition;
    }

    public Area getArea() {
        return area;
    }

    public void setArea(Area area) {
        this.area = area;
    }

    public Map(String name, int start, int end, int length, int currentPosition) {
        this.name = name;
        this.start = start;
        this.end = end;
        this.length = length;
        this.currentPosition = currentPosition;
        initialize();
    }
    private void initialize() {
        generateAreas();
    }
    public boolean isEndOfMap() {
        return currentPosition >= length;
    }

    public void generateAreas(){
        for (int i=start; i<=end; i++){
            area.generateEnemies();
            area = area.nextArea;
        }
    }

}