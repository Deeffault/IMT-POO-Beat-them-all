package org.example;

import java.util.Random;
import java.util.ArrayList;

public class Map {

    String name;
    int start;
    int end;
    int length;
    int currentPosition;
    ArrayList<Integer> areas;

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

    public ArrayList<Integer> getAreas() {
        return areas;
    }

    public void setAreas(ArrayList<Integer> areas) {
        this.areas = areas;
    }

    public Map(String name, int start, int end, int length, int currentPosition) {
        this.name = name;
        this.start = start;
        this.end = end;
        this.length = length;
        this.currentPosition = currentPosition;
    }

    public boolean isEndOfMap() {
        return currentPosition >= length;
    }

    public void generateEnemies(){
        for (int i = this.start;i < this.end; i++){
            Random numberEnemies = new Random();
            areas.add(numberEnemies.nextInt(1,5));
        }
    }
}