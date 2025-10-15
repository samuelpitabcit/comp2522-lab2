package ca.bcit.comp2522.lab2;

/**
 * Custom exception to be thrown when an elf's mana is too low to cast spells.
 *
 * @author Jacob, Meiko, Samuel, Son
 * @version 1.0
 */
public class LowManaException extends Exception
{
    private final String message;

    /**
     * Constructs a new LowManaException with a detailed message
     * indicating which elf has low mana.
     *
     * @param name The name of the elf. Must not be null or blank.
     * @throws IllegalArgumentException if the provided name is null or blank.
     */
    public LowManaException(final String name)
    {
        super();

        validateName(name);

        final StringBuilder sb;
        sb = new StringBuilder();
        sb.append("Elf ");
        sb.append(name);
        sb.append(" does not have enough mana to cast spells.");

        this.message = sb.toString();
    }

    private static void validateName(final String name)
    {
        if (name == null || name.isBlank())
        {
            throw new IllegalArgumentException("Name must not be null or empty.");
        }
    }

    /**
     * Returns the detail message string of this throwable.
     *
     * @return the detail message string of this {@code LowManaException} instance.
     */
    public String getMessage()
    {
        return this.message;
    }
}
