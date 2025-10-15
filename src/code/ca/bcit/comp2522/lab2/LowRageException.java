package ca.bcit.comp2522.lab2;

/**
 * Custom exception to be thrown when an orc's rage is too low to deal damage.
 *
 * @author Jacob, Meiko, Samuel, Son
 * @version 1.0
 */
public class LowRageException extends RuntimeException
{
    /**
     * Default constructor of RuntimeException.
     *
     * @param message Error message.
     */
    public LowRageException(String message)
    {
        super(message);
    }
}
