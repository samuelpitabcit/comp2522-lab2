package ca.bcit.comp2522.lab2;

import java.time.LocalDate;

public class Dragon extends Creature {

    /**
     * Constructs a new Creature instance.
     *
     * @param name        The name of the creature.
     * @param dateOfBirth The date of birth of the creature.
     * @param health      The initial health of the creature.
     */
    public Dragon(final String name, final LocalDate dateOfBirth, final int health) {
        super(name, dateOfBirth, health);
    }
}
