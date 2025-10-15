package ca.bcit.comp2522.lab2;

/**
 * Custom exception to be thrown when the damage passed is invalid.
 *
 * @author Jacob, Samuel
 * @version 1.0
 */
public class DamageException extends RuntimeException
{
    /**
     * Default constructor of RuntimeException.
     *
     * @param message Error message.
     */
    public DamageException(String message)
    {
        super(message);
    }
}
