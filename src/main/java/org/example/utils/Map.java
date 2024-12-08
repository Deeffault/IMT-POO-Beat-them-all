package org.example.utils;

import java.util.ArrayList;

/**
 * Represents a map in the game, which consists of multiple areas.
 * The map has a start and end position, and the player moves through the areas.
 */
public class Map {

    private String name;
    private int start;
    private int end;

    private int length;

    private int currentPosition;
    private ArrayList<Area> areas;

    /**
     * Constructs a new Map with the specified name, start, and end positions.
     *
     * @param name  the name of the map
     * @param start the starting position of the map
     * @param end   the ending position of the map
     */
    public Map(String name, int start, int end) {
        this.name = name;
        this.start = start;
        this.end = end;
        this.length = end - start + 1;
        this.currentPosition = start;
        this.areas = new ArrayList<>();
        initialize();
    }

    /**
     * Initializes the map by generating the areas.
     */
    private void initialize() {
        generateAreas();
    }

    /**
     * Generates the areas for the map and populates them with enemies.
     */
    private void generateAreas() {
        for (int i = start; i <= end; i++) {
            Area newArea = new Area();
            if (i != start && i != end) {
                newArea.generateEnemies();
            }
            areas.add(newArea);
        }
    }

    /**
     * Returns the name of the map.
     *
     * @return the name of the map
     */
    public String getName() {
        return name;
    }

    /**
     * Returns the current position of the player on the map.
     *
     * @return the current position
     */
    public int getCurrentPosition() {
        return currentPosition;
    }

    /**
     * Returns map length
     *
     * @return map length
     */
    public int getLength() {
        return length;
    }

    /**
     * Returns areas list of the map
     *
     * @return Areas list
     */
    public ArrayList<Area> getAreas() {
        return areas;
    }

    /**
     * Returns the number of areas in the map.
     *
     * @return the number of areas
     */
    public int getAreasSize() {
        return areas.size();
    }

    /**
     * Checks if the player has reached the end of the map.
     *
     * @return true if the player is at the end of the map, false otherwise
     */
    public boolean isEndOfMap() {
        return currentPosition > end;
    }

    /**
     * Returns the current area the player is in.
     *
     * @return the current area
     */
    public Area getCurrentArea() {
        if (currentPosition >= start && currentPosition <= end) {
            return areas.get(currentPosition - start);
        }
        return null;
    }

    /**
     * Moves the player to the next area on the map.
     */
    public void moveToNextArea() {
        if (!isEndOfMap()) {
            currentPosition++;
        }
    }

    public void displayMap() {
        System.out.println("╔══════════════════════════════╗");
        System.out.println(" Carte : " + name + "   ");
        System.out.println("╚══════════════════════════════╝");
        System.out.println("Votre position : " + currentPosition + "/" + end);
        System.out.println("══════════════════════════════");

        for (int i = 0; i < areas.size(); i++) {
            if (i == currentPosition - start) {
                System.out.print("🏃 "); // Symbole pour le joueur
            } else {
                System.out.print("⬜ "); // Symbole pour une zone
            }
        }
        System.out.println();
        System.out.println("══════════════════════════════");
    }

}