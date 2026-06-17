import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class DateTest {

  // Petite méthode d'aide pour éviter de répéter les mêmes assertions
  private void assertDate(Date date, int expectedYear, int expectedMonth, int expectedDay) {
    assertEquals(expectedYear, date.getYear());
    assertEquals(expectedMonth, date.getMonth());
    assertEquals(expectedDay, date.getDay());
  }

  // ------------------------------------------------------------
  // Tests pour nextDate()
  // ------------------------------------------------------------

  @Test
  void nextDate_dateNormale_augmenteSeulementLeJour() {
    Date d = new Date(2020, 5, 3);
    Date result = d.nextDate();

    assertDate(result, 2020, 5, 4);
  }

  @Test
  void nextDate_jour30DansMois31Jours_neChangePasDeMois() {
    Date d = new Date(2020, 1, 30);
    Date result = d.nextDate();

    assertDate(result, 2020, 1, 31);
  }

  @Test
  void nextDate_finMois31Jours_passeAuMoisSuivant() {
    Date d = new Date(2020, 1, 31);
    Date result = d.nextDate();

    assertDate(result, 2020, 2, 1);
  }

  @Test
  void nextDate_finAvril_passeAuMoisSuivant() {
    Date d = new Date(2020, 4, 30);
    Date result = d.nextDate();

    assertDate(result, 2020, 5, 1);
  }

  @Test
  void nextDate_finJuin_passeAuMoisSuivant() {
    Date d = new Date(2020, 6, 30);
    Date result = d.nextDate();

    assertDate(result, 2020, 7, 1);
  }

  @Test
  void nextDate_finSeptembre_passeAuMoisSuivant() {
    Date d = new Date(2020, 9, 30);
    Date result = d.nextDate();

    assertDate(result, 2020, 10, 1);
  }

  @Test
  void nextDate_finNovembre_passeAuMoisSuivant() {
    Date d = new Date(2020, 11, 30);
    Date result = d.nextDate();

    assertDate(result, 2020, 12, 1);
  }

  @Test
  void nextDate_finAnnee_passeALAnneeSuivante() {
    Date d = new Date(2020, 12, 31);
    Date result = d.nextDate();

    assertDate(result, 2021, 1, 1);
  }

  @Test
  void nextDate_28FevrierAnneeNonBissextile_passeAuPremierMars() {
    Date d = new Date(2021, 2, 28);
    Date result = d.nextDate();

    assertDate(result, 2021, 3, 1);
  }

  @Test
  void nextDate_28FevrierAnneeBissextile_passeAu29Fevrier() {
    Date d = new Date(2020, 2, 28);
    Date result = d.nextDate();

    assertDate(result, 2020, 2, 29);
  }

  @Test
  void nextDate_29FevrierAnneeBissextile_passeAuPremierMars() {
    Date d = new Date(2020, 2, 29);
    Date result = d.nextDate();

    assertDate(result, 2020, 3, 1);
  }

  // ------------------------------------------------------------
  // Tests pour les années bissextiles
  // ------------------------------------------------------------

  @Test
  void isLeapYear_anneeDivisiblePar4_estBissextile() {
    Date d = new Date(2024, 1, 1);

    assertTrue(d.isLeapYear());
  }

  @Test
  void isLeapYear_anneeNonDivisiblePar4_nEstPasBissextile() {
    Date d = new Date(2023, 1, 1);

    assertFalse(d.isLeapYear());
  }

  @Test
  void isLeapYear_anneeSiecleDivisiblePar400_estBissextile() {
    Date d = new Date(2000, 1, 1);

    assertTrue(d.isLeapYear());
  }

  @Test
  void isLeapYear_anneeSiecleNonDivisiblePar400_nEstPasBissextile() {
    Date d = new Date(1900, 1, 1);

    assertFalse(d.isLeapYear());
  }

  // ------------------------------------------------------------
  // Tests pour les dates invalides
  // ------------------------------------------------------------

  @Test
  void constructeur_jourZero_lanceException() {
    assertThrows(IllegalArgumentException.class, () -> {
      new Date(2020, 5, 0);
    });
  }

  @Test
  void constructeur_jourNegatif_lanceException() {
    assertThrows(IllegalArgumentException.class, () -> {
      new Date(2020, 5, -1);
    });
  }

  @Test
  void constructeur_jourPlusGrandQue31_lanceException() {
    assertThrows(IllegalArgumentException.class, () -> {
      new Date(2020, 5, 32);
    });
  }

  @Test
  void constructeur_moisZero_lanceException() {
    assertThrows(IllegalArgumentException.class, () -> {
      new Date(2020, 0, 10);
    });
  }

  @Test
  void constructeur_moisPlusGrandQue12_lanceException() {
    assertThrows(IllegalArgumentException.class, () -> {
      new Date(2020, 13, 10);
    });
  }

  @Test
  void constructeur_anneeNegative_lanceException() {
    assertThrows(IllegalArgumentException.class, () -> {
      new Date(-1, 5, 10);
    });
  }

  @Test
  void constructeur_31Avril_lanceException() {
    assertThrows(IllegalArgumentException.class, () -> {
      new Date(2020, 4, 31);
    });
  }

  @Test
  void constructeur_31Juin_lanceException() {
    assertThrows(IllegalArgumentException.class, () -> {
      new Date(2020, 6, 31);
    });
  }

  @Test
  void constructeur_31Septembre_lanceException() {
    assertThrows(IllegalArgumentException.class, () -> {
      new Date(2020, 9, 31);
    });
  }

  @Test
  void constructeur_31Novembre_lanceException() {
    assertThrows(IllegalArgumentException.class, () -> {
      new Date(2020, 11, 31);
    });
  }

  @Test
  void constructeur_30FevrierAnneeBissextile_lanceException() {
    assertThrows(IllegalArgumentException.class, () -> {
      new Date(2020, 2, 30);
    });
  }

  @Test
  void constructeur_29FevrierAnneeNonBissextile_lanceException() {
    assertThrows(IllegalArgumentException.class, () -> {
      new Date(2021, 2, 29);
    });
  }

  @Test
  void constructeur_29FevrierAnneeSiecleNonBissextile_lanceException() {
    assertThrows(IllegalArgumentException.class, () -> {
      new Date(1900, 2, 29);
    });
  }

  // ------------------------------------------------------------
  // Tests pour equals() et toString()
  // ------------------------------------------------------------

  @Test
  void equals_memeDate_retourneTrue() {
    Date d1 = new Date(2020, 5, 3);
    Date d2 = new Date(2020, 5, 3);

    assertTrue(d1.equals(d2));
  }

  @Test
  void equals_objetPasUneDate_retourneFalse() {
    Date d = new Date(2020, 5, 3);

    assertFalse(d.equals("pas une date"));
  }

  @Test
  void equals_anneeDifferente_retourneFalse() {
    Date d1 = new Date(2020, 5, 3);
    Date d2 = new Date(2021, 5, 3);

    assertFalse(d1.equals(d2));
  }

  @Test
  void equals_moisDifferent_retourneFalse() {
    Date d1 = new Date(2020, 5, 3);
    Date d2 = new Date(2020, 6, 3);

    assertFalse(d1.equals(d2));
  }

  @Test
  void equals_jourDifferent_retourneFalse() {
    Date d1 = new Date(2020, 5, 3);
    Date d2 = new Date(2020, 5, 4);

    assertFalse(d1.equals(d2));
  }

  @Test
  void toString_retourneDateAvecNomDuMois() {
    Date d = new Date(2020, 5, 3);

    assertEquals("2020/May/3", d.toString());
  }
}