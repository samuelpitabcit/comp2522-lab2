package ca.bcit.comp2522.lab2;

/**
 * Simple date class with day-month-year parameters.
 *
 * @author Jacob, May, Samuel, Son
 * @version 1.0
 */
public class Date
{
    /*
     * The number of days for each month. February has separate
     * number of days for leap and non-leap years.
     */

    private static final int JANUARY_DAYS = 31;
    private static final int FEBRUARY_DAYS_L = 29;
    private static final int FEBRUARY_DAYS_NL = 28;
    private static final int MARCH_DAYS = 31;
    private static final int APRIL_DAYS = 30;
    private static final int MAY_DAYS = 31;
    private static final int JUNE_DAYS = 30;
    private static final int JULY_DAYS = 31;
    private static final int AUGUST_DAYS = 31;
    private static final int SEPTEMBER_DAYS = 30;
    private static final int OCTOBER_DAYS = 31;
    private static final int NOVEMBER_DAYS = 30;
    private static final int DECEMBER_DAYS = 31;

    /*
     * The numbers for each month that is added to the weekday sum calculation.
     */

    private static final int JANUARY_WC_MONTH_CODE = 1;
    private static final int FEBRUARY_WC_MONTH_CODE = 4;
    private static final int MARCH_WC_MONTH_CODE = 4;
    private static final int MAY_WC_MONTH_CODE = 2;
    private static final int JUNE_WC_MONTH_CODE = 5;
    private static final int AUGUST_WC_MONTH_CODE = 3;
    private static final int SEPTEMBER_WC_MONTH_CODE = 6;
    private static final int OCTOBER_WC_MONTH_CODE = 1;
    private static final int NOVEMBER_WC_MONTH_CODE = 4;
    private static final int DECEMBER_WC_MONTH_CODE = 6;

    /*
     * Constants for calculating the weekdays of a given date.
     */

    private static final int WEEKDAY_CALC_START_NUM_1800 = 2;
    private static final int WEEKDAY_CALC_START_NUM_1900 = 0;
    private static final int WEEKDAY_CALC_START_NUM_2000 = 6;
    private static final int WEEKDAY_CALC_JF_LY_NUM = 6;
    private static final int WEEKDAY_CALC_FIRST_DIV = 12;
    private static final int WEEKDAY_CALC_SECOND_DIV = 4;

    /*
     * Used for comparing against the Date's year, rounded to the nearest
     * century.
     */

    private static final int YEAR_1800 = 1800;
    private static final int YEAR_1900 = 1900;
    private static final int YEAR_2000 = 2000;

    /*
     * Numerical month constants.
     */

    private static final int JANUARY = 1;
    private static final int FEBRUARY = 2;
    private static final int MARCH = 3;
    private static final int APRIL = 4;
    private static final int MAY = 5;
    private static final int JUNE = 6;
    private static final int JULY = 7;
    private static final int AUGUST = 8;
    private static final int SEPTEMBER = 9;
    private static final int OCTOBER = 10;
    private static final int NOVEMBER = 11;
    private static final int DECEMBER = 12;

    /*
     * Numerical weekday constants.
     */

    private static final int SATURDAY = 0;
    private static final int SUNDAY = 1;
    private static final int MONDAY = 2;
    private static final int TUESDAY = 3;
    private static final int WEDNESDAY = 4;
    private static final int THURSDAY = 5;
    private static final int FRIDAY = 6;

    /*
     * Year and day minimums and maximums.
     */

    /**
     * The minimum year allowed for this class.
     */
    public static final int MIN_YEAR = 1800;

    /**
     * The maximum (current) year allowed for this class.
     */
    public static final int CURRENT_YEAR = 2025;
    private static final int MIN_DAY = 1;

    /*
     * Number of units of time for one unit of time.
     */

    private static final int NUM_DAYS_IN_WEEK = 7;
    private static final int NUM_YEARS_IN_CENTURY = 100;

    /*
     * Divisors for determining the leap year.
     */

    private static final int LEAP_YEAR_FIRST_DIV = 4;
    private static final int LEAP_YEAR_SECOND_DIV = 100;
    private static final int LEAP_YEAR_THIRD_DIV = 400;
    private static final int ZERO = 0;

    // Instance variables.
    private final int year;
    private final int month;
    private final int day;

    /**
     * Constructs the date with the given year, month, and day.
     *
     * @param year  Integer from {@value MIN_YEAR} to {@value CURRENT_YEAR}.
     * @param month Integer from {@value JANUARY} to {@value DECEMBER}.
     * @param day   Integer from {@value MIN_DAY} to a month-and-year-specific maximum.
     */
    public Date(final int year,
                final int month,
                final int day)
    {
        validateYear(year);
        validateMonthDay(year, month, day);

        this.year  = year;
        this.month = month;
        this.day   = day;
    }

    private static void validateYear(final int year)
    {
        if (year < MIN_YEAR)
        {
            throw new IllegalArgumentException("Year must be at, or after " + MIN_YEAR);
        }
        else if (year > CURRENT_YEAR)
        {
            throw new IllegalArgumentException("Year must be at, or before " + CURRENT_YEAR);
        }
    }

    private static void validateMonthDay(final int year,
                                         final int month,
                                         final int day)
    {
        final int maxDayOfMonth;

        // Set the maximum number of days allowed, depending on the month.
        if (month == JANUARY)
        {
            maxDayOfMonth = JANUARY_DAYS;
        }
        else if (month == FEBRUARY)
        {
            if (isLeapYear(year))
            {
                maxDayOfMonth = FEBRUARY_DAYS_L;
            }
            else
            {
                maxDayOfMonth = FEBRUARY_DAYS_NL;
            }
        }
        else if (month == MARCH)
        {
            maxDayOfMonth = MARCH_DAYS;
        }
        else if (month == APRIL)
        {
            maxDayOfMonth = APRIL_DAYS;
        }
        else if (month == MAY)
        {
            maxDayOfMonth = MAY_DAYS;
        }
        else if (month == JUNE)
        {
            maxDayOfMonth = JUNE_DAYS;
        }
        else if (month == JULY)
        {
            maxDayOfMonth = JULY_DAYS;
        }
        else if (month == AUGUST)
        {
            maxDayOfMonth = AUGUST_DAYS;
        }
        else if (month == SEPTEMBER)
        {
            maxDayOfMonth = SEPTEMBER_DAYS;
        }
        else if (month == OCTOBER)
        {
            maxDayOfMonth = OCTOBER_DAYS;
        }
        else if (month == NOVEMBER)
        {
            maxDayOfMonth = NOVEMBER_DAYS;
        }
        else if (month == DECEMBER)
        {
            maxDayOfMonth = DECEMBER_DAYS;
        }
        else
        {
            throw new IllegalArgumentException(
                "Month must be between " + JANUARY + " and " + DECEMBER);
        }

        if (day > maxDayOfMonth)
        {
            throw new IllegalArgumentException(
                "Day must be between " + MIN_DAY + " and " + maxDayOfMonth);
        }
    }

    /**
     * Determines if the year is a leap year.
     *
     * @return {@code true} if the year is a leap year; {@code false} otherwise.
     */
    public static boolean isLeapYear(final int year)
    {
        /*
         * The given year is a leap year if it's divisible by 4.
         * It's not divisible if the year is divisible by 100, unless
         * it's divisible by 400, then it's a leap year.
         */
        return ((year % LEAP_YEAR_FIRST_DIV == ZERO)
            && (year % LEAP_YEAR_SECOND_DIV != ZERO))
            || (year % LEAP_YEAR_THIRD_DIV == ZERO);
    }

    /**
     * Returns the Date's set year.
     *
     * @return Integer from {@value MIN_YEAR} to {@value CURRENT_YEAR}.
     */
    public int getYear()
    {
        return year;
    }

    /**
     * Returns the Date's set month
     *
     * @return Integer from {@value JANUARY} to {@value DECEMBER}
     */
    public int getMonth()
    {
        return month;
    }

    /**
     * Returns the Date's set day
     *
     * @return Integer from {@value MIN_DAY} to a month-and-year-specific maximum.
     */
    public int getDay()
    {
        return day;
    }

    /**
     * Returns a number specifying the Date's weekday.
     *
     * @return A number from 0 to 6.
     */
    public int getWeekday()
    {
        int sum;
        final int floorYear;
        final int lastTwoDigitsOfYear;
        final int divFirstDivisor;
        final int modFirstDivisor;
        final int divSecondDivisor;

        // Floor the year by a century.
        floorYear = this.year - (this.year % NUM_YEARS_IN_CENTURY);

        // Set the starting sum according to the century the year belongs to.
        if (floorYear == YEAR_1800)
        {
            sum = WEEKDAY_CALC_START_NUM_1800;
        }
        else if (floorYear == YEAR_1900)
        {
            sum = WEEKDAY_CALC_START_NUM_1900;
        }
        else if (floorYear == YEAR_2000)
        {
            sum = WEEKDAY_CALC_START_NUM_2000;
        }
        else
        {
            throw new IllegalArgumentException(
                "Year must be between " + MIN_YEAR + " and " + CURRENT_YEAR);
        }

        /*
         * Add the extra value if the month falls in the first 2 months,
         * and the year is a leap year.
         */
        if (isLeapYear(this.year))
        {
            if (this.month == JANUARY || this.month == FEBRUARY)
            {
                sum += WEEKDAY_CALC_JF_LY_NUM;
            }
        }

        lastTwoDigitsOfYear = this.year % NUM_YEARS_IN_CENTURY;

        // (Step 1) Divide last two digits of year by 12.
        divFirstDivisor = lastTwoDigitsOfYear / WEEKDAY_CALC_FIRST_DIV;
        // (Step 2) Remainder of dividing last two digits of year by 12.
        modFirstDivisor = lastTwoDigitsOfYear % WEEKDAY_CALC_FIRST_DIV;

        // (Step 3) Divide the remainder by 4.
        divSecondDivisor = modFirstDivisor / WEEKDAY_CALC_SECOND_DIV;

        // (Step 4) Sum up all previous calculations.
        sum += this.day;
        sum += divFirstDivisor;
        sum += modFirstDivisor;
        sum += divSecondDivisor;

        // (Step 5) Add the month code to the sum.
        if (this.month == JANUARY)
        {
            sum += JANUARY_WC_MONTH_CODE;
        }
        else if (this.month == FEBRUARY)
        {
            sum += FEBRUARY_WC_MONTH_CODE;
        }
        else if (this.month == MARCH)
        {
            sum += MARCH_WC_MONTH_CODE;
        }
        else if (this.month == MAY)
        {
            sum += MAY_WC_MONTH_CODE;
        }
        else if (this.month == JUNE)
        {
            sum += JUNE_WC_MONTH_CODE;
        }
        else if (this.month == AUGUST)
        {
            sum += AUGUST_WC_MONTH_CODE;
        }
        else if (this.month == SEPTEMBER)
        {
            sum += SEPTEMBER_WC_MONTH_CODE;
        }
        else if (this.month == OCTOBER)
        {
            sum += OCTOBER_WC_MONTH_CODE;
        }
        else if (this.month == NOVEMBER)
        {
            sum += NOVEMBER_WC_MONTH_CODE;
        }
        else if (this.month == DECEMBER)
        {
            sum += DECEMBER_WC_MONTH_CODE;
        }
        else
        {
            throw new IllegalArgumentException(
                "Month must be between " + JANUARY + " and " + DECEMBER);
        }

        // (Step 6 + 7) Return the remainder result of dividing the sum by the number of weeks.
        return sum % NUM_DAYS_IN_WEEK;
    }

    /**
     * Returns a String specifying the Date's weekday.
     *
     * @return Saturday, Sunday, Monday, Tuesday, Wednesday, Thursday, or Friday.
     */
    public String getWeekdayAsString()
    {
        final int weekday;

        weekday = getWeekday();

        if (weekday == SATURDAY)
        {
            return "Saturday";
        }
        else if (weekday == SUNDAY)
        {
            return "Sunday";
        }
        else if (weekday == MONDAY)
        {
            return "Monday";
        }
        else if (weekday == TUESDAY)
        {
            return "Tuesday";
        }
        else if (weekday == WEDNESDAY)
        {
            return "Wednesday";
        }
        else if (weekday == THURSDAY)
        {
            return "Thursday";
        }
        else if (weekday == FRIDAY)
        {
            return "Friday";
        }

        throw new IllegalArgumentException("Weekday number is not between 0 to 6");
    }

    /**
     * Returns a String of the Date's month.
     *
     * @return January, February, March, April, May, June, July, August, September
     */
    public String getMonthAsString()
    {
        if (this.month == JANUARY)
        {
            return "January";
        }
        else if (this.month == FEBRUARY)
        {
            return "February";
        }
        else if (this.month == MARCH)
        {
            return "March";
        }
        else if (this.month == APRIL)
        {
            return "April";
        }
        else if (this.month == MAY)
        {
            return "May";
        }
        else if (this.month == JUNE)
        {
            return "June";
        }
        else if (this.month == JULY)
        {
            return "July";
        }
        else if (this.month == AUGUST)
        {
            return "August";
        }
        else if (this.month == SEPTEMBER)
        {
            return "September";
        }
        else if (this.month == OCTOBER)
        {
            return "October";
        }
        else if (this.month == NOVEMBER)
        {
            return "November";
        }
        else if (this.month == DECEMBER)
        {
            return "December";
        }

        return null;
    }

    /**
     * Returns the date as a {@code String} in YYYY-MM-DD format.
     *
     * @return {@code String} date in YYYY-MM-DD format.
     */
    public String getYyyyMmDd()
    {
        final StringBuilder yyyyMmDd;

        yyyyMmDd = new StringBuilder();

        yyyyMmDd.append(String.format("%04d", this.year));
        yyyyMmDd.append("-");
        yyyyMmDd.append(String.format("%02d", this.month));
        yyyyMmDd.append("-");
        yyyyMmDd.append(String.format("%02d", this.day));

        return yyyyMmDd.toString();
    }
}
