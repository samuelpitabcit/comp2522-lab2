package ca.bcit.comp2522.lab2;

/**
 * Custom exception to be thrown when a dragon's firepower is too low to breathe fire.
 *
 * @author Jacob, Meiko, Samuel, Son
 * @version 1.0
 */
public class LowFirePowerException extends Exception
{
    public LowFirePowerException(String message)
    {
        super(message);
    }
}
