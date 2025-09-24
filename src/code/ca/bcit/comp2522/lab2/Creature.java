package ca.bcit.comp2522.lab2;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

/**
 * Creature class.
 *
 * @author Samuel Pita
 * @version 1.0
 */
public class Creature
{
    private static final int MIN_HEALTH = 0;
    private static final int MAX_HEALTH = 100;

    private final String name;
    private final LocalDate dateOfBirth;
    private int health;

    /**
     * Constructs a new Creature instance.
     *
     * @param name        The name of the creature.
     * @param dateOfBirth The date of birth of the creature.
     * @param health      The initial health of the creature.
     */
    public Creature(final String name,
                    final LocalDate dateOfBirth,
                    final int health)
    {
        validateName(name);
        validateDateOfBirth(dateOfBirth);
        validateHealth(health);

        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.health = health;
    }

    private static void validateName(final String name)
    {
        if (name == null || name.isEmpty())
        {
            throw new IllegalArgumentException("Name is null or empty");
        }
    }

    private static void validateDateOfBirth(final LocalDate dateOfBirth)
    {
        final LocalDate currentDate;

        currentDate = LocalDate.now();

        if (dateOfBirth.isAfter(currentDate))
        {
            throw new IllegalArgumentException("Birth date must not be set in the future.");
        }
    }

    private static void validateHealth(final int health)
    {
        final int minHealthSetting;
        final int maxHealthSetting;

        minHealthSetting = 1;
        maxHealthSetting = MAX_HEALTH;

        if (health < minHealthSetting || health > maxHealthSetting)
        {
            throw new IllegalArgumentException("Health must be between " + minHealthSetting + " and " + maxHealthSetting);
        }
    }

    /**
     * Checks if the creature is alive.
     * A creature is considered alive if its health is greater than {@value #MIN_HEALTH}.
     *
     * @return {@code true} if the creature's health is greater than {@value #MIN_HEALTH},
     * otherwise {@code false}.
     */
    public boolean isAlive()
    {
        return this.health > MIN_HEALTH;
    }

    /**
     * Inflicts damage on the creature, reducing its health.
     * The creature's health will not fall below {@value #MIN_HEALTH}.
     *
     * @param damage The amount of damage to inflict. Must be a non-negative number.
     */
    public void takeDamage(final int damage)
    {
        if (damage < 0)
        {
            throw new DamageException("Damage value is negative");
        }

        this.health -= damage;

        if (this.health < MIN_HEALTH)
        {
            this.health = MIN_HEALTH;
        }
    }

    /**
     * Heals the creature, increasing its health.
     * The creature's health will not exceed {@value #MAX_HEALTH}.
     *
     * @param healAmount The amount of health to restore. Must be a non-negative number.
     */
    public void heal(final int healAmount)
    {
        if (healAmount < 0)
        {
            throw new HealingException("Healing value is negative");
        }

        this.health += healAmount;

        if (this.health > MAX_HEALTH)
        {
            this.health = MAX_HEALTH;
        }
    }

    /**
     * Calculates the creature's age in full years based on its date of birth.
     *
     * @return The number of full years since the creature's birthdate.
     */
    public long getAgeYears()
    {
        final LocalDate currentDate;

        currentDate = LocalDate.now();

        // Use ChronoUnit to get the number of years between two dates.
        return ChronoUnit.YEARS.between(currentDate, this.dateOfBirth);
    }

    /**
     * Prints the name, date of birth, and health of the Creature in the console.
     */
    public void getDetails()
    {
        System.out.println("Name: " + this.name);
        System.out.println("Date of birth: " + this.dateOfBirth);
        System.out.println("Health: " + this.health);
    }
}