package ca.bcit.comp2522.lab2;

import java.time.LocalDate;

/**
 * Elf class that extends from Creature. It has spell-casting abilities, using mana.
 *
 * @author Jacob, Meiko, Samuel, Son
 * @version 1.0
 */
public class Elf extends Creature
{
    // Mana constants.
    private static final int MANA_DAMAGE = 10;
    private static final int MANA_USAGE = 5;
    private static final int MIN_MANA = 0;
    private static final int MAX_MANA = 50;

    // Instance variables.
    private int mana;

    /**
     * Constructs a new Elf instance.
     *
     * @param name        The name of the creature.
     * @param dateOfBirth The date of birth of the creature.
     * @param health      The initial health of the creature.
     * @param mana        The initial mana of the elf.
     */
    public Elf(final String name,
               final Date dateOfBirth,
               final int health,
               final int mana)
    {
        super(name, dateOfBirth, health);

        validateMana(mana);
        this.mana = mana;
    }

    /**
     * Throws if the mana is less than {@value MIN_MANA} or greater than
     * {@value MAX_MANA}.
     *
     * @param mana The mana.
     */
    private static void validateMana(final int mana)
    {
        if (mana < MIN_MANA || mana > MAX_MANA)
        {
            throw new IllegalArgumentException(
                "Mana must be set between " + MIN_MANA + " and " + MAX_MANA);
        }
    }

    /**
     * Reduces the elf's mana and inflicts damage on another creature.
     * The mana is reduced by {@value MANA_USAGE} and the target creature
     * takes {@value MANA_DAMAGE} damage.
     *
     * @param creature The creature to inflict damage upon.
     * @throws LowManaException If the elf's current mana is less than
     *                          the required {@value MANA_USAGE}.
     */
    public void castSpell(final Creature creature) throws LowManaException
    {
        if (this.mana < MANA_USAGE)
        {
            throw new LowManaException(this.getName());
        }

        this.mana -= MANA_USAGE;
        creature.takeDamage(MANA_DAMAGE);
    }

    /**
     * Restores the elf's mana by a specified amount.
     * The elf's mana will not exceed {@value MAX_MANA}.
     *
     * @param manaAmount The amount of mana to restore.
     */
    public void restoreMana(final int manaAmount)
    {
        this.mana += manaAmount;

        if (this.mana > MAX_MANA)
        {
            this.mana = MAX_MANA;
        }
    }

    /**
     * Prints the details of the elf, including its name, health, and mana.
     * This method overrides the parent class's {@code getDetails()} method.
     */
    @Override
    public void getDetails()
    {
        super.getDetails();
        System.out.println("Mana: " + this.mana);
    }
}
