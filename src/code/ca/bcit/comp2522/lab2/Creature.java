package ca.bcit.comp2522.lab2;

/**
 * Creature class with name, birthdate, and health parameters.
 *
 * @author Jacob, Samuel
 * @version 1.0
 */
public class Creature
{
    // Damage constants.
    private static final int MIN_DAMAGE = 0;

    // Healing constants.
    private static final int MIN_HEAL_AMOUNT = 0;

    // Health constants.
    private static final int MIN_HEALTH_SETTING = 1;
    private static final int MIN_HEALTH = 10;
    private static final int MAX_HEALTH = 1080;

    // Instance identifiers.
    private final String name;
    private final Date dateOfBirth;
    private int health;

    /**
     * Constructs a new Creature instance.
     *
     * @param name        The name of the creature.
     * @param dateOfBirth The date of birth of the creature.
     * @param health      The initial health of the creature.
     */
    public Creature(final String name,
                    final Date dateOfBirth,
                    final int health)
    {
        validateName(name);
        validateHealth(health);

        this.name        = name;
        this.dateOfBirth = dateOfBirth;
        this.health      = health;
    }

    /**
     * Throws if the name is null or blank.
     *
     * @param name The name.
     */
    private static void validateName(final String name)
    {
        if (name == null || name.isBlank())
        {
            throw new IllegalArgumentException("Name is null or empty");
        }
    }

    /**
     * Throws if the health value is less than the {@value MIN_HEALTH_SETTING}
     * or greater than {@value MAX_HEALTH}.
     *
     * @param health The health.
     */
    private static void validateHealth(final int health)
    {
        if (health < MIN_HEALTH_SETTING || health > MAX_HEALTH)
        {
            throw new IllegalArgumentException(
                "Health must be between " + MIN_HEALTH_SETTING + " and " + MAX_HEALTH);
        }
    }

    /**
     * Gets the creature's name.
     *
     * @return The name of the creature.
     */
    public String getName()
    {
        return name;
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
     * @param damage The amount of damage to inflict. Must be at least
     *               {@value MIN_DAMAGE}.
     * @throws DamageException If the damage amount is less than {@value MIN_DAMAGE}.
     */
    public void takeDamage(final int damage)
    {
        if (damage < MIN_DAMAGE)
        {
            throw new DamageException("Damage value is less than " + MIN_DAMAGE);
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
     * @param healAmount The amount of health to restore. Must be at least
     *                   {@value MIN_HEAL_AMOUNT}.
     * @throws HealingException If the heal amount is less than {@value MIN_HEAL_AMOUNT}.
     */
    public void heal(final int healAmount)
    {
        if (healAmount < MIN_HEAL_AMOUNT)
        {
            throw new HealingException("Healing value is less than " + MIN_HEAL_AMOUNT);
        }

        this.health += healAmount;

        if (this.health > MAX_HEALTH)
        {
            this.health = MAX_HEALTH;
        }
    }

    /**
     * Calculates the creature's age in years based on its date of birth.
     *
     * @return The number of years since the creature's birthdate.
     */
    public int getAgeYears()
    {
        return Date.CURRENT_YEAR - this.dateOfBirth.getYear();
    }

    /**
     * Prints the name, date of birth, and health of the Creature in the console.
     */
    public void getDetails()
    {
        System.out.println("Name: " + this.name);
        System.out.println("Date of birth: " + this.dateOfBirth.getYyyyMmDd());
        System.out.println("Health: " + this.health);
    }
}