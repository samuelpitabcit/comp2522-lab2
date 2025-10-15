package ca.bcit.comp2522.lab2;

/**
 * Custom exception to be thrown when an orc's rage is too low to deal damage.
 *
 * @author Jacob, Meiko, Samuel, Son
 * @version 1.0
 */
public class LowRageException extends RuntimeException
{
    private final String message;

    /**
     * Constructs a new LowRageException with a detailed message
     * indicating which orc has low rage.
     *
     * @param name The name of the orc. Must not be null or blank.
     * @throws IllegalArgumentException if the provided name is null or blank.
     */
    public LowRageException(final String name)
    {
        super();

        validateName(name);

        final StringBuilder sb;
        sb = new StringBuilder();
        sb.append("Orc ");
        sb.append(name);
        sb.append(" does not have enough rage to deal damage.");

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
     * @return the detail message string of this {@code LowRageException} instance.
     */
    public String getMessage()
    {
        return this.message;
    }
}
