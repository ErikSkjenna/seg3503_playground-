import java.util.LinkedList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

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

  @Parameters
  public static List<Integer[]> data() {
    List<Integer[]> params = new LinkedList<Integer[]>();

    // Année invalide
    params.add(new Integer[] { -1, 10, 20 });

    // Mois invalides
    params.add(new Integer[] { 2020, 0, 10 });
    params.add(new Integer[] { 2020, 13, 10 });
    params.add(new Integer[] { 1458, 15, 12 });

    // Jours invalides généraux
    params.add(new Integer[] { 2020, 5, 0 });
    params.add(new Integer[] { 2020, 5, -1 });
    params.add(new Integer[] { 1975, 6, -50 });
    params.add(new Integer[] { 2020, 5, 32 });

    // Mois de 30 jours : le 31 est impossible
    params.add(new Integer[] { 2020, 4, 31 });
    params.add(new Integer[] { 2020, 6, 31 });
    params.add(new Integer[] { 2020, 9, 31 });
    params.add(new Integer[] { 2020, 11, 31 });

    // Février invalide
    params.add(new Integer[] { 1500, 2, 31 });
    params.add(new Integer[] { 2020, 2, 30 });

    // 29 février invalide dans une année non bissextile
    params.add(new Integer[] { 1500, 2, 29 });
    params.add(new Integer[] { 2021, 2, 29 });

    // 1900 est divisible par 100, mais pas par 400, donc pas bissextile
    params.add(new Integer[] { 1900, 2, 29 });

    return params;
  }

  @Test(expected = IllegalArgumentException.class)
  public void testNextDateException() {
    new Date(year, month, day);
  }
}