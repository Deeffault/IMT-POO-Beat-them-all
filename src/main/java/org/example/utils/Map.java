package org.example.utils;

/**
 * Represents a map in the game.
 */
public class Map {

    String name;
    int start;
    int end;
    int length;
    int currentPosition;
    Area area;

    /**
     * Gets the name of the map.
     *
     * @return the name of the map
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name of the map.
     *
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets the start position of the map.
     *
     * @return the start position
     */
    public int getStart() {
        return start;
    }

    /**
     * Sets the start position of the map.
     *
     * @param start the start position to set
     */
    public void setStart(int start) {
        this.start = start;
    }

    /**
     * Gets the end position of the map.
     *
     * @return the end position
     */
    public int getEnd() {
        return end;
    }

    /**
     * Sets the end position of the map.
     *
     * @param end the end position to set
     */
    public void setEnd(int end) {
        this.end = end;
    }

    /**
     * Gets the length of the map.
     *
     * @return the length of the map
     */
    public int getLength() {
        return length;
    }

    /**
     * Sets the length of the map.
     *
     * @param length the length to set
     */
    public void setLength(int length) {
        this.length = length;
    }

    /**
     * Gets the current position on the map.
     *
     * @return the current position
     */
    public int getCurrentPosition() {
        return currentPosition;
    }

    /**
     * Sets the current position on the map.
     *
     * @param currentPosition the current position to set
     */
    public void setCurrentPosition(int currentPosition) {
        this.currentPosition = currentPosition;
    }

    /**
     * Gets the current area on the map.
     *
     * @return the current area
     */
    public Area getArea() {
        return area;
    }

    /**
     * Sets the current area on the map.
     *
     * @param area the area to set
     */
    public void setArea(Area area) {
        this.area = area;
    }

    /**
     * Constructs a new Map with the specified parameters.
     *
     * @param name the name of the map
     * @param start the start position
     * @param end the end position
     * @param length the length of the map
     * @param currentPosition the current position on the map
     */
    public Map(String name, int start, int end, int length, int currentPosition) {
        this.name = name;
        this.start = start;
        this.end = end;
        this.length = length;
        this.currentPosition = currentPosition;
        this.area = new Area(); // Initialize the area
        initialize();
    }

    /**
     * Initializes the map by generating areas.
     */
    private void initialize() {
        generateAreas();
    }

    /**
     * Checks if the current position is at the end of the map.
     *
     * @return true if the current position is at the end of the map, false otherwise
     */
    public boolean isEndOfMap() {
        return currentPosition >= length;
    }

    /**
     * Generates areas on the map and populates them with enemies.
     */
    public void generateAreas() {
        Area currentArea = this.area;
        for (int i = start; i <= end; i++) {
            currentArea.generateEnemies();
            if (i < end) {
                currentArea.nextArea = new Area();
                currentArea = currentArea.nextArea;
            }
        }
    }
}