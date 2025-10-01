package ca.bcit.comp2522.lab2;

/**
 * Custom exception to be thrown when an elf's mana is too low to cast spells.
 *
 * @author Jacob, Meiko, Samuel, Son
 * @version 1.0
 */
public class LowManaException extends Exception
{
    public LowManaException(String message)
    {
        super(message);
    }
}
