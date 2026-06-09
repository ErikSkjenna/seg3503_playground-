import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class DateNextDateExceptionTest {

    private int year;
    private int month;
    private int day;

    // Constructeur utilisé par le runner paramétré de JUnit 4
    public DateNextDateExceptionTest(int year, int month, int day) {
        this.year = year;
        this.month = month;
        this.day = day;
    }

    // Données utilisées pour les cas de test invalides
    @Parameterized.Parameters(name = "TC{index}: date invalide {0}/{1}/{2}")
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {
            // Cas de test invalides fournis dans le laboratoire
            {1500, 2, 31},
            {1500, 2, 29},
            {-1, 10, 20},
            {1458, 15, 12},
            {1975, 6, -50},

            // Cas additionnels pour les années invalides
            {-100, 1, 1},

            // Cas additionnels pour les mois invalides
            {2024, 0, 10},
            {2024, 13, 10},
            {2024, -1, 10},
            {2024, 99, 10},

            // Cas additionnels pour les jours invalides
            {2024, 1, 0},
            {2024, 1, -1},
            {2024, 1, 32},
            {2024, 12, 32},

            // Cas invalides pour le 31e jour dans les mois de 30 jours
            {2024, 4, 31},
            {2024, 6, 31},
            {2024, 9, 31},
            {2024, 11, 31},

            // Cas invalides pour février
            {2021, 2, 29},
            {2021, 2, 30},
            {2020, 2, 30},
            {2020, 2, 31},
            {1900, 2, 29},
            {1900, 2, 30}
        });
    }

    @Test(expected = IllegalArgumentException.class)
    public void dateInvalide_lanceIllegalArgumentException() {
        new Date(year, month, day);
    }
}
