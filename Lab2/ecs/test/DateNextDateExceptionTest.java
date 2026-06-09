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

    public DateNextDateExceptionTest(int year, int month, int day) {
        this.year = year;
        this.month = month;
        this.day = day;
    }

    @Parameterized.Parameters(name = "TC{index}: invalid date {0}/{1}/{2}")
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {
            {1500, 2, 31},
            {1500, 2, 29},
            {-1, 10, 20},
            {1458, 15, 12},
            {1975, 6, -50}
        });
    }

    @Test(expected = IllegalArgumentException.class)
    public void invalidDate_shouldThrowIllegalArgumentException() {
        new Date(year, month, day);
    }
}