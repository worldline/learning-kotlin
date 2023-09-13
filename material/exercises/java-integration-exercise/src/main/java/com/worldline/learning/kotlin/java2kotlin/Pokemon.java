package com.worldline.learning.kotlin.java2kotlin;

/**
 * Defines a <b>Pokemon</b> object.
 *
 * <b>Pokemon</b> are cute little characters from a <i>video game</i>.
 *
 * @author antoine
 */
public class Pokemon {

    /**
     * Defines the <b>maximum level</b> a Pokemon can reach
     */
    public static final Integer MAX_LEVEL = 100;

    public Pokemon(final String name) {
        this.name = name;
    }

    public Pokemon(final String name, final String owner) {
        this(name);
        this.owner = owner;
    }

    private final String name;
    private String owner = "Nobody!";
    private int experience = 1;

    public String getName() {
        return this.name;
    }

    public String getOwner() {
        return this.owner;
    }

    public int getLevel() {
        return this.experience / 100;
    }

    public void setOwner(final String owner) {
        this.owner = owner;
    }

    public void winExperience(final int experience) {
        this.experience += experience;
    }

    @Override
    public String toString() {
        return name + "!";
    }

    public static void main(final String[] args) {
        final Pokemon pikachu = new Pokemon("Pikachu");
        System.out.println(pikachu.toString());
    }
}
