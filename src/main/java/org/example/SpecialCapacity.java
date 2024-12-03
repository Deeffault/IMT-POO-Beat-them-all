package org.example;

/**
 * This enum represents the special capacities that a hero can have in the game.
 */
public enum SpecialCapacity {
    /**
     * The healing capacity allows the hero to heal themselves.
     */
    HEALING,

    /**
     * The matrix capacity allows the hero to dodge attacks.
     */
    MATRIX,

    /**
     * The one-shot capacity allows the hero to defeat an enemy in one hit.
     */
    ONE_SHOT,

    /**
     * Indicates that the hero has no special capacity.
     * Used most of the time in tests.
     */
    NONE,
}