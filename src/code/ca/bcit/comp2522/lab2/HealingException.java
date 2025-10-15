package ca.bcit.comp2522.lab2;

/**
 * Custom exception to be thrown when the healing value passed is invalid.
 *
 * @author Jacob, Samuel
 * @version 1.0
 */
public class HealingException extends RuntimeException
{
    /**
     * Default constructor of RuntimeException.
     *
     * @param message Error message.
     */
    public HealingException(String message)
    {
        super(message);
    }
}
