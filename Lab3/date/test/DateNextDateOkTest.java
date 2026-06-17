import java.util.LinkedList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class DateNextDateOkTest {

  private int year;
  private int month;
  private int day;

  private int expectedYear;
  private int expectedMonth;
  private int expectedDay;

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

  @Parameters
  public static List<Integer[]> data() {
    List<Integer[]> params = new LinkedList<Integer[]>();

    // Cas normal : seulement le jour augmente
    params.add(new Integer[] { 2020, 5, 3, 2020, 5, 4 });

    // Mois de 31 jours
    params.add(new Integer[] { 2020, 1, 30, 2020, 1, 31 });
    params.add(new Integer[] { 2020, 1, 31, 2020, 2, 1 });

    params.add(new Integer[] { 2020, 3, 30, 2020, 3, 31 });
    params.add(new Integer[] { 2020, 3, 31, 2020, 4, 1 });

    params.add(new Integer[] { 2020, 5, 30, 2020, 5, 31 });
    params.add(new Integer[] { 2020, 5, 31, 2020, 6, 1 });

    params.add(new Integer[] { 2020, 7, 30, 2020, 7, 31 });
    params.add(new Integer[] { 2020, 7, 31, 2020, 8, 1 });

    params.add(new Integer[] { 2020, 8, 30, 2020, 8, 31 });
    params.add(new Integer[] { 2020, 8, 31, 2020, 9, 1 });

    params.add(new Integer[] { 2020, 10, 30, 2020, 10, 31 });
    params.add(new Integer[] { 2020, 10, 31, 2020, 11, 1 });

    // Mois de 30 jours
    params.add(new Integer[] { 2020, 4, 29, 2020, 4, 30 });
    params.add(new Integer[] { 2020, 4, 30, 2020, 5, 1 });

    params.add(new Integer[] { 2020, 6, 29, 2020, 6, 30 });
    params.add(new Integer[] { 2020, 6, 30, 2020, 7, 1 });

    params.add(new Integer[] { 2020, 9, 29, 2020, 9, 30 });
    params.add(new Integer[] { 2020, 9, 30, 2020, 10, 1 });

    params.add(new Integer[] { 2020, 11, 29, 2020, 11, 30 });
    params.add(new Integer[] { 2020, 11, 30, 2020, 12, 1 });

    // Février dans une année non bissextile
    params.add(new Integer[] { 2021, 2, 27, 2021, 2, 28 });
    params.add(new Integer[] { 2021, 2, 28, 2021, 3, 1 });

    // Février dans une année bissextile normale
    params.add(new Integer[] { 2020, 2, 27, 2020, 2, 28 });
    params.add(new Integer[] { 2020, 2, 28, 2020, 2, 29 });
    params.add(new Integer[] { 2020, 2, 29, 2020, 3, 1 });

    // Année divisible par 400 : bissextile
    params.add(new Integer[] { 2000, 2, 28, 2000, 2, 29 });
    params.add(new Integer[] { 2000, 2, 29, 2000, 3, 1 });

    // Année divisible par 100, mais pas par 400 : pas bissextile
    params.add(new Integer[] { 1900, 2, 28, 1900, 3, 1 });

    // Fin d'année
    params.add(new Integer[] { 2020, 12, 30, 2020, 12, 31 });
    params.add(new Integer[] { 2020, 12, 31, 2021, 1, 1 });

    // Février dans une année non bissextile
    params.add(new Integer[] { 2021, 2, 27, 2021, 2, 28 });
    params.add(new Integer[] { 2021, 2, 28, 2021, 3, 1 });

    // Février dans une année bissextile
    params.add(new Integer[] { 2020, 2, 27, 2020, 2, 28 });
    params.add(new Integer[] { 2020, 2, 28, 2020, 2, 29 });
    params.add(new Integer[] { 2020, 2, 29, 2020, 3, 1 });

    return params;
  }

  @Test
  public void testNextDateOk() {
    Date date = new Date(year, month, day);
    Date expectedDate = new Date(expectedYear, expectedMonth, expectedDay);

    Assert.assertEquals(expectedDate, date.nextDate());
  }
}