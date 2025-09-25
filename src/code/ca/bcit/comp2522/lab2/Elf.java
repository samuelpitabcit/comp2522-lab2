package ca.bcit.comp2522.lab2;

import java.time.LocalDate;

/**
 * Elf class that extends from Creature. It has spell-casting abilities, using mana.
 *
 * @author Jacob, May, Samuel, Son
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

    public Elf(final String name,
               final LocalDate dateOfBirth,
               final int health,
               final int mana)
    {
        super(name, dateOfBirth, health);

        validateMana(mana);
        this.mana = mana;
    }

    private static void validateMana(final int mana)
    {
        if (mana < MIN_MANA || mana > MAX_MANA)
        {
            throw new IllegalArgumentException(
                "Mana must be set between " + MIN_MANA + " and " + MAX_MANA);
        }
    }

    public void castSpell(final Creature creature) throws LowManaException
    {
        if (this.mana < MANA_USAGE)
        {
            throw new LowManaException("Cannot cast a spell; mana is less than " + MANA_USAGE);
        }

        this.mana -= MANA_USAGE;
        creature.takeDamage(MANA_DAMAGE);
    }

    public void restoreMana(final int manaAmount)
    {
        this.mana += manaAmount;

        if (this.mana > MAX_MANA)
        {
            this.mana = MAX_MANA;
        }
    }

    @Override
    public void getDetails()
    {
        super.getDetails();
        System.out.println("Mana: " + this.mana);
    }
}
