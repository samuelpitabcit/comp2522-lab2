package ca.bcit.comp2522.lab2;

/**
 * Test driver class for the Creature hierarchy.
 *
 * @author Jacob, Meiko, Samuel, Son
 * @version 1.1
 */
public final class CreatureTest
{

    // Creature constants for Smaug the Dragon.
    private static final String DRAGON_NAME = "Smaug";
    private static final int DRAGON_BIRTH_YEAR = 1850;
    private static final int DRAGON_BIRTH_MONTH = 5;
    private static final int DRAGON_BIRTH_DAY = 12;
    private static final int DRAGON_HEALTH = 100;
    private static final int DRAGON_FIRE_POWER = 95;

    // Creature constants for Legolas the Elf.
    private static final String ELF_NAME = "Legolas";
    private static final int ELF_BIRTH_YEAR = 2005;
    private static final int ELF_BIRTH_MONTH = 8;
    private static final int ELF_BIRTH_DAY = 22;
    private static final int ELF_HEALTH = 80;
    private static final int ELF_MANA = 48;

    // Creature constants for Grishnákh the Orc.
    private static final String ORC_NAME = "Grishnákh";
    private static final int ORC_BIRTH_YEAR = 2010;
    private static final int ORC_BIRTH_MONTH = 2;
    private static final int ORC_BIRTH_DAY = 3;
    private static final int ORC_HEALTH = 90;
    private static final int ORC_RAGE = 25;

    // Creature constants for the mystery creature.
    private static final String MYSTERY_NAME = "Legolas's Brother";
    private static final int MYSTERY_BIRTH_YEAR = 1899;
    private static final int MYSTERY_BIRTH_MONTH = 10;
    private static final int MYSTERY_BIRTH_DAY = 24;
    private static final int MYSTERY_HEALTH = 100;
    private static final int MYSTERY_MANA = 40;


    /**
     * The main method to run the creature simulation. It creates different types of
     * creatures and simulates a battle between them, handling various exceptions
     * that may occur.
     *
     * @param args Command line arguments (not used).
     */
    public static void main(final String[] args)
    {
        // Declare all local variables.
        final Dragon dragon;
        final Elf elf;
        final Orc orc;
        final Creature mystery;
        final Date dragonBirthDate;
        final Date elfBirthDate;
        final Date orcBirthDate;
        final Date mysteryBirthDate;

        // Initialize the dragon.
        dragonBirthDate = new Date(DRAGON_BIRTH_YEAR,
                                   DRAGON_BIRTH_MONTH,
                                   DRAGON_BIRTH_DAY);
        dragon          = new Dragon(DRAGON_NAME,
                                     dragonBirthDate,
                                     DRAGON_HEALTH,
                                     DRAGON_FIRE_POWER);

        // Initialize the elf.
        elfBirthDate = new Date(ELF_BIRTH_YEAR,
                                ELF_BIRTH_MONTH,
                                ELF_BIRTH_DAY);
        elf          = new Elf(ELF_NAME,
                               elfBirthDate,
                               ELF_HEALTH,
                               ELF_MANA);

        // Initialize the orc.
        orcBirthDate = new Date(ORC_BIRTH_YEAR,
                                ORC_BIRTH_MONTH,
                                ORC_BIRTH_DAY);
        orc          = new Orc(ORC_NAME,
                               orcBirthDate,
                               ORC_HEALTH,
                               ORC_RAGE);

        // Get details.
        dragon.getDetails();
        System.out.print(System.lineSeparator());

        elf.getDetails();
        System.out.print(System.lineSeparator());

        orc.getDetails();
        System.out.print(System.lineSeparator());

        // Simulate a fight and handle exceptions.
        try
        {
            System.out.println(
                "Simulating a fight."
                    + System.lineSeparator());

            dragon.breatheFire(elf);
            elf.castSpell(dragon);
            orc.berserk(elf);

            // Get details.
            dragon.getDetails();
            System.out.print(System.lineSeparator());

            elf.getDetails();
            System.out.print(System.lineSeparator());

            orc.getDetails();
            System.out.print(System.lineSeparator());

            // Demonstrate exception for low firepower by exhausting it
            System.out.println(
                dragon.getName() + " exhausts its firepower against " + orc.getName()
                    + System.lineSeparator());

            dragon.breatheFire(orc);
            dragon.breatheFire(orc);
            dragon.breatheFire(orc);
            dragon.breatheFire(orc);
            dragon.breatheFire(orc);
        }
        catch (final LowFirePowerException | LowManaException e)
        {
            System.out.println(e.getMessage() + System.lineSeparator());
        }

        System.out.println(
            "Results after exception:"
                + System.lineSeparator());

        // Get details.
        dragon.getDetails();
        System.out.print(System.lineSeparator());

        elf.getDetails();
        System.out.print(System.lineSeparator());

        orc.getDetails();
        System.out.print(System.lineSeparator());

        // Initialize the mystery creature as a Dragon.
        mysteryBirthDate = new Date(MYSTERY_BIRTH_YEAR,
                                    MYSTERY_BIRTH_MONTH,
                                    MYSTERY_BIRTH_DAY);
        mystery          = new Elf(MYSTERY_NAME,
                                   mysteryBirthDate,
                                   MYSTERY_HEALTH,
                                   MYSTERY_MANA);

        // Demonstrate the use of .getClass()
        if (dragon.getClass() != mystery.getClass())
        {
            System.out.println(
                dragon.getName() + " and " + mystery.getName() + " are not the same class.");
            System.out.print(System.lineSeparator());
        }

        // Cast the mystery creature, and have it attack the dragon.
        final Elf mysteryElf;
        mysteryElf = (Elf) mystery;

        // Simulate another fight, and get an exception.
        try
        {
            mysteryElf.castSpell(dragon);
            mysteryElf.castSpell(dragon);
            mysteryElf.castSpell(dragon);
            mysteryElf.castSpell(dragon);
            mysteryElf.castSpell(dragon);
            mysteryElf.castSpell(dragon);
            mysteryElf.castSpell(dragon);
            mysteryElf.castSpell(dragon);
            mysteryElf.castSpell(dragon);
            mysteryElf.castSpell(dragon);
            mysteryElf.castSpell(dragon);
        }
        catch (LowManaException e)
        {
            System.out.println(e.getMessage());
        }
    }
}
