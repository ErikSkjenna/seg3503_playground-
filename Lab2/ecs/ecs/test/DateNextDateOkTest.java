import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class DateNextDateOkTest {

    private int year;
    private int month;
    private int day;

    private int expectedYear;
    private int expectedMonth;
    private int expectedDay;

    // Constructeur utilisé par le runner paramétré de JUnit 4
    public DateNextDateOkTest(
            int year,
            int month,
            int day,
            int expectedYear,
            int expectedMonth,
            int expectedDay) {

        this.year = year;
        this.month = month;
        this.day = day;
        this.expectedYear = expectedYear;
        this.expectedMonth = expectedMonth;
        this.expectedDay = expectedDay;
    }

    // Données utilisées pour les cas de test valides
    @Parameterized.Parameters(name = "TC{index}: {0}/{1}/{2} -> {3}/{4}/{5}")
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {
            // Cas de test valides fournis dans le laboratoire
            {1700, 6, 20, 1700, 6, 21},
            {2005, 4, 15, 2005, 4, 16},
            {1901, 7, 20, 1901, 7, 21},
            {3456, 3, 27, 3456, 3, 28},
            {1500, 2, 17, 1500, 2, 18},
            {1700, 6, 29, 1700, 6, 30},
            {1800, 11, 29, 1800, 11, 30},
            {3453, 1, 29, 3453, 1, 30},
            {444, 2, 29, 444, 3, 1},
            {2005, 4, 30, 2005, 5, 1},
            {3453, 1, 30, 3453, 1, 31},
            {3456, 3, 30, 3456, 3, 31},
            {1901, 7, 31, 1901, 8, 1},
            {3453, 1, 31, 3453, 2, 1},
            {3456, 12, 31, 3457, 1, 1},

            // Cas additionnels pour les dates ordinaires
            {2024, 1, 1, 2024, 1, 2},
            {2024, 5, 10, 2024, 5, 11},
            {0, 1, 1, 0, 1, 2},

            // Cas additionnels pour les fins de mois
            {2024, 1, 31, 2024, 2, 1},
            {2024, 3, 31, 2024, 4, 1},
            {2024, 5, 31, 2024, 6, 1},
            {2024, 8, 31, 2024, 9, 1},
            {2024, 10, 31, 2024, 11, 1},
            {2024, 4, 30, 2024, 5, 1},
            {2024, 6, 30, 2024, 7, 1},
            {2024, 9, 30, 2024, 10, 1},
            {2024, 11, 30, 2024, 12, 1},

            // Cas additionnels pour février et les années bissextiles
            {2021, 2, 28, 2021, 3, 1},
            {2020, 2, 28, 2020, 2, 29},
            {2020, 2, 29, 2020, 3, 1},
            {2000, 2, 28, 2000, 2, 29},
            {2000, 2, 29, 2000, 3, 1},
            {1900, 2, 28, 1900, 3, 1},

            // Cas additionnels pour les fins d'année
            {1999, 12, 31, 2000, 1, 1},
            {2024, 12, 31, 2025, 1, 1}
        });
    }

    @Test
    public void nextDate_dateValide_retourneDateAttendue() {
        Date date = new Date(year, month, day);
        Date expected = new Date(expectedYear, expectedMonth, expectedDay);

        assertEquals(expected, date.nextDate());
    }
}
