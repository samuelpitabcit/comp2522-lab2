package ca.bcit.comp2522.lab2;

import java.time.LocalDate;

/**
 * Orc class that extends from Creature. It has rage abilities that
 * deals damage to other creatures.
 *
 * @author Jacob, Meiko, Samuel, Son
 * @version 1.0
 */
public class Orc extends Creature
{
    private static final int MIN_RAGE = 0;
    private static final int MAX_RAGE = 30;
    private static final int RAGE_ADD = 5;
    private static final int RAGE_BASE_DAMAGE = 30;
    private static final int RAGE_HIGH_DAMAGE = RAGE_BASE_DAMAGE * 2;
    private static final int RAGE_HIGH_THRESHOLD = 20;

    private int rage;

    /**
     * Constructs a new Orc instance.
     *
     * @param name        The name of the creature.
     * @param dateOfBirth The date of birth of the creature.
     * @param health      The initial health of the creature.
     */
    public Orc(final String name,
               final LocalDate dateOfBirth,
               final int health,
               final int rage)
    {
        super(name, dateOfBirth, health);

        validateRage(rage);
        this.rage = rage;
    }

    private static void validateRage(final int rage)
    {
        if (rage < MIN_RAGE || rage > MAX_RAGE)
        {
            throw new IllegalArgumentException(
                "Rage value must be set between " + MIN_RAGE + " and " + MAX_RAGE);
        }
    }

    /**
     * Executes the Orc's berserk attack on another creature.
     * <p>
     * This method first checks if the Orc has sufficient rage. If it does,
     * it increases the Orc's rage, and then deals either base damage or
     * high damage to the target creature based on the resulting rage level.
     * </p>
     *
     * @param creature The target creature to attack.
     * @throws LowRageException If the current rage is too low (less than {@value RAGE_ADD}) to perform the attack.
     */
    public void berserk(final Creature creature)
    {
        if (this.rage < RAGE_ADD)
        {
            throw new LowRageException("Rage value is too low to deal damage");
        }

        this.rage += RAGE_ADD;

        if (this.rage > RAGE_HIGH_THRESHOLD)
        {
            creature.takeDamage(RAGE_HIGH_DAMAGE);
        }
        else
        {
            creature.takeDamage(RAGE_BASE_DAMAGE);
        }
    }

    /**
     * Displays the details of the Orc, including the inherited creature details
     * and its current rage.
     * <p>
     * This method overrides the base {@code getDetails()} method.
     * </p>
     */
    @Override
    public void getDetails()
    {
        super.getDetails();
        System.out.println("Rage: " + this.rage);
    }
}
