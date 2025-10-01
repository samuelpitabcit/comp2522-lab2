package ca.bcit.comp2522.lab2;

import java.time.LocalDate;

/**
 * Dragon class that extends from Creature. It has firepower abilities.
 *
 * @author Jacob, Meiko, Samuel, Son
 * @version 1.0
 */
public class Dragon extends Creature
{
    // Firepower constants.
    private static final int FIRE_POWER_USAGE = 10;
    private static final int FIRE_POWER_DAMAGE = 20;
    private static final int MIN_FIRE_POWER = 0;
    private static final int MAX_FIRE_POWER = 100;

    // Instance variables.
    private int firePower;

    /**
     * Constructs a new Dragon instance.
     *
     * @param name        The name of the creature.
     * @param dateOfBirth The date of birth of the creature.
     * @param health      The initial health of the creature.
     * @param firePower   The initial firepower of the dragon.
     * @throws IllegalArgumentException If the firepower is not within the valid range of
     *                                  {@value MIN_FIRE_POWER} to {@value MAX_FIRE_POWER}.
     */
    public Dragon(final String name,
                  final LocalDate dateOfBirth,
                  final int health,
                  final int firePower)
    {
        super(name, dateOfBirth, health);

        validateFirePower(firePower);
        this.firePower = firePower;
    }

    private static void validateFirePower(final int firePower)
    {
        if (firePower < MIN_FIRE_POWER || firePower > MAX_FIRE_POWER)
        {
            throw new IllegalArgumentException(
                "Fire power must be set between " + MIN_FIRE_POWER + " and " + MAX_FIRE_POWER);
        }
    }

    /**
     * Reduces the dragon's firepower and inflicts damage on another creature.
     * The firepower is reduced by {@value FIRE_POWER_USAGE} and the target creature
     * takes {@value FIRE_POWER_DAMAGE} damage.
     *
     * @param creature The creature to inflict damage upon.
     * @throws LowFirePowerException If the dragon's current firepower is less than
     *                               the required {@value FIRE_POWER_USAGE}.
     */
    public void breatheFire(final Creature creature) throws LowFirePowerException
    {
        if (this.firePower < FIRE_POWER_USAGE)
        {
            throw new LowFirePowerException(
                "Cannot breathe fire; firePower is less than " + FIRE_POWER_USAGE);
        }

        this.firePower -= FIRE_POWER_USAGE;
        creature.takeDamage(FIRE_POWER_DAMAGE);
    }

    /**
     * Restores the dragon's firepower by a specified amount.
     * The dragon's firepower will not exceed {@value MAX_FIRE_POWER}.
     *
     * @param firePowerAmount The amount of firepower to restore.
     */
    public void restoreFirePower(final int firePowerAmount)
    {
        this.firePower += firePowerAmount;

        if (this.firePower > MAX_FIRE_POWER)
        {
            this.firePower = MAX_FIRE_POWER;
        }
    }

    /**
     * Prints the details of the dragon, including its name, birthdate,
     * health, and firepower.
     * <br>
     * This method overrides the parent class's {@code getDetails()} method.
     */
    @Override
    public void getDetails()
    {
        super.getDetails();
        System.out.println("Fire Power: " + this.firePower);
    }
}
