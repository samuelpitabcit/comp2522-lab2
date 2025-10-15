package ca.bcit.comp2522.lab2;

/**
 * Test driver class for the Creature hierarchy.
 *
 * @author Jacob, Meiko, Samuel, Son
 * @version 1.1
 */
public final class CreatureTest
{

    // Creature constants for Smaug the Dragon
    private static final int SMAUG_BIRTH_YEAR = 1850;
    private static final int SMAUG_BIRTH_MONTH = 5;
    private static final int SMAUG_BIRTH_DAY = 12;
    private static final int SMAUG_HEALTH_POINTS = 100;
    private static final int SMAUG_FIRE_POWER_UNITS = 95;

    // Creature constants for Legolas the Elf
    private static final int LEGOLAS_BIRTH_YEAR = 2005;
    private static final int LEGOLAS_BIRTH_MONTH = 8;
    private static final int LEGOLAS_BIRTH_DAY = 22;
    private static final int LEGOLAS_HEALTH_POINTS = 80;
    private static final int LEGOLAS_MANA_UNITS = 48;

    // Creature constants for Grishnákh the Orc
    private static final int GRISHNAKH_BIRTH_YEAR = 2010;
    private static final int GRISHNAKH_BIRTH_MONTH = 2;
    private static final int GRISHNAKH_BIRTH_DAY = 3;
    private static final int GRISHNAKH_HEALTH_POINTS = 90;
    private static final int GRISHNAKH_RAGE_UNITS = 25;

    // Battle constants
    private static final int EXHAUST_FIRE_POWER_ATTEMPTS = 9;


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
        final Dragon smaug;
        final Elf legolas;
        final Orc grishnakh;
        final Date smaugBirthDate;
        final Date legolasBirthDate;
        final Date grishnakhBirthDate;

        // Initialize variables.
        smaugBirthDate = new Date(SMAUG_BIRTH_YEAR,
                                  SMAUG_BIRTH_MONTH,
                                  SMAUG_BIRTH_DAY);
        smaug          = new Dragon("Smaug",
                                    smaugBirthDate,
                                    SMAUG_HEALTH_POINTS,
                                    SMAUG_FIRE_POWER_UNITS);

        legolasBirthDate = new Date(LEGOLAS_BIRTH_YEAR,
                                    LEGOLAS_BIRTH_MONTH,
                                    LEGOLAS_BIRTH_DAY);
        legolas          = new Elf("Legolas",
                                   legolasBirthDate,
                                   LEGOLAS_HEALTH_POINTS,
                                   LEGOLAS_MANA_UNITS);

        grishnakhBirthDate = new Date(GRISHNAKH_BIRTH_YEAR,
                                      GRISHNAKH_BIRTH_MONTH,
                                      GRISHNAKH_BIRTH_DAY);
        grishnakh          = new Orc("Grishnákh",
                                     grishnakhBirthDate,
                                     GRISHNAKH_HEALTH_POINTS,
                                     GRISHNAKH_RAGE_UNITS);

        // Get details.
        smaug.getDetails();
        System.out.print(System.lineSeparator());

        legolas.getDetails();
        System.out.print(System.lineSeparator());

        grishnakh.getDetails();
        System.out.print(System.lineSeparator());

        // Simulate a fight and handle exceptions.
        try
        {
            // Smaug attacks Legolas
            smaug.breatheFire(legolas);

            // Legolas retaliates against Smaug
            legolas.castSpell(smaug);

            // Grishnakh goes berserk on Legolas
            grishnakh.berserk(legolas);

            // Demonstrate exception for low firepower by exhausting it
            for (int i = 0; i < EXHAUST_FIRE_POWER_ATTEMPTS; i++)
            {
                // This will eventually throw LowFirePowerException
                smaug.breatheFire(grishnakh);
            }
        }
        catch (final LowFirePowerException | LowManaException | LowRageException e)
        {
            System.out.println(e.getMessage());
        }
    }
}
