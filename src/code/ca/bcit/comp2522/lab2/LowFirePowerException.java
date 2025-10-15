package ca.bcit.comp2522.lab2;

/**
 * Custom exception to be thrown when a dragon's firepower is too low to breathe fire.
 *
 * @author Jacob, Meiko, Samuel, Son
 * @version 1.0
 */
public class LowFirePowerException extends Exception
{
    private final String message;

    /**
     * Constructs a new LowFirePowerException with a detailed message
     * indicating which dragon has low firepower.
     *
     * @param name The name of the dragon. Must not be null or blank.
     */
    public LowFirePowerException(final String name)
    {
        super();

        validateName(name);

        final StringBuilder sb;
        sb = new StringBuilder();
        sb.append("Dragon ");
        sb.append(name);
        sb.append(" does not have enough firepower to breathe fire.");

        this.message = sb.toString();
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
            throw new IllegalArgumentException("Name must not be null or empty.");
        }
    }

    /**
     * Returns the detail message string of this throwable.
     *
     * @return the detail message string of this {@code LowFirePowerException} instance.
     */
    public String getMessage()
    {
        return this.message;
    }
}
