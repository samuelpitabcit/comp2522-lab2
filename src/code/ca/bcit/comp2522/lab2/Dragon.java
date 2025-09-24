package ca.bcit.comp2522.lab2;

import java.time.LocalDate;

/**
 * @author Samuel Pita
 * @version 1.0
 */
public class Dragon extends Creature {

    private static final int MIN_FIRE_POWER = 10;
    private static final int MAX_FIRE_POWER = 100;

    private int firePower;

    /**
     * Constructs a new Creature instance.
     *
     * @param name        The name of the creature.
     * @param dateOfBirth The date of birth of the creature.
     * @param health      The initial health of the creature.
     */
    public Dragon(final String name,
                  final LocalDate dateOfBirth,
                  final int health,
                  final int firePower) {
        super(name, dateOfBirth, health);

        validateFirePower(firePower);
        this.firePower = firePower;
    }

    private static void validateFirePower(final int firePower) {
        if (firePower < MIN_FIRE_POWER || firePower > MAX_FIRE_POWER)
            throw new IllegalArgumentException("Fire power must be set between " + MIN_FIRE_POWER + " and " + MAX_FIRE_POWER);
    }
}
