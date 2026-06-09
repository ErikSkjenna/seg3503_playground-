import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class DateTest {

    // Cas de test valides fournis dans le laboratoire

    @Test
    void testNextDate_TC1() {
        assertEquals(new Date(1700, 6, 21), new Date(1700, 6, 20).nextDate());
    }

    @Test
    void testNextDate_TC2() {
        assertEquals(new Date(2005, 4, 16), new Date(2005, 4, 15).nextDate());
    }

    @Test
    void testNextDate_TC3() {
        assertEquals(new Date(1901, 7, 21), new Date(1901, 7, 20).nextDate());
    }

    @Test
    void testNextDate_TC4() {
        assertEquals(new Date(3456, 3, 28), new Date(3456, 3, 27).nextDate());
    }

    @Test
    void testNextDate_TC5() {
        assertEquals(new Date(1500, 2, 18), new Date(1500, 2, 17).nextDate());
    }

    @Test
    void testNextDate_TC6() {
        assertEquals(new Date(1700, 6, 30), new Date(1700, 6, 29).nextDate());
    }

    @Test
    void testNextDate_TC7() {
        assertEquals(new Date(1800, 11, 30), new Date(1800, 11, 29).nextDate());
    }

    @Test
    void testNextDate_TC8() {
        assertEquals(new Date(3453, 1, 30), new Date(3453, 1, 29).nextDate());
    }

    @Test
    void testNextDate_TC9() {
        assertEquals(new Date(444, 3, 1), new Date(444, 2, 29).nextDate());
    }

    @Test
    void testNextDate_TC10() {
        assertEquals(new Date(2005, 5, 1), new Date(2005, 4, 30).nextDate());
    }

    @Test
    void testNextDate_TC11() {
        assertEquals(new Date(3453, 1, 31), new Date(3453, 1, 30).nextDate());
    }

    @Test
    void testNextDate_TC12() {
        assertEquals(new Date(3456, 3, 31), new Date(3456, 3, 30).nextDate());
    }

    @Test
    void testNextDate_TC13() {
        assertEquals(new Date(1901, 8, 1), new Date(1901, 7, 31).nextDate());
    }

    @Test
    void testNextDate_TC14() {
        assertEquals(new Date(3453, 2, 1), new Date(3453, 1, 31).nextDate());
    }

    @Test
    void testNextDate_TC15() {
        assertEquals(new Date(3457, 1, 1), new Date(3456, 12, 31).nextDate());
    }

    // Cas de test invalides fournis dans le laboratoire

    @Test
    void testNextDate_TC16_exception() {
        assertThrows(IllegalArgumentException.class, () -> new Date(1500, 2, 31));
    }

    @Test
    void testNextDate_TC17_exception() {
        assertThrows(IllegalArgumentException.class, () -> new Date(1500, 2, 29));
    }

    @Test
    void testNextDate_TC18_exception() {
        assertThrows(IllegalArgumentException.class, () -> new Date(-1, 10, 20));
    }

    @Test
    void testNextDate_TC19_exception() {
        assertThrows(IllegalArgumentException.class, () -> new Date(1458, 15, 12));
    }

    @Test
    void testNextDate_TC20_exception() {
        assertThrows(IllegalArgumentException.class, () -> new Date(1975, 6, -50));
    }

    // Tests additionnels pour les dates valides

    @Test
    void testNextDate_anneeZeroValide() {
        assertEquals(new Date(0, 1, 2), new Date(0, 1, 1).nextDate());
    }

    @Test
    void testNextDate_28FevrierAnneeNonBissextile() {
        assertEquals(new Date(2021, 3, 1), new Date(2021, 2, 28).nextDate());
    }

    @Test
    void testNextDate_28FevrierAnneeBissextile() {
        assertEquals(new Date(2020, 2, 29), new Date(2020, 2, 28).nextDate());
    }

    @Test
    void testNextDate_29FevrierAnneeBissextile() {
        assertEquals(new Date(2020, 3, 1), new Date(2020, 2, 29).nextDate());
    }

    @Test
    void testNextDate_anneeSiecleBissextile2000() {
        assertEquals(new Date(2000, 2, 29), new Date(2000, 2, 28).nextDate());
    }

    @Test
    void testNextDate_anneeSiecleNonBissextile1900() {
        assertEquals(new Date(1900, 3, 1), new Date(1900, 2, 28).nextDate());
    }

    @Test
    void testNextDate_finSeptembre() {
        assertEquals(new Date(2024, 10, 1), new Date(2024, 9, 30).nextDate());
    }

    @Test
    void testNextDate_finNovembre() {
        assertEquals(new Date(2024, 12, 1), new Date(2024, 11, 30).nextDate());
    }

    @Test
    void testNextDate_finJanvier() {
        assertEquals(new Date(2024, 2, 1), new Date(2024, 1, 31).nextDate());
    }

    @Test
    void testNextDate_finAout() {
        assertEquals(new Date(2024, 9, 1), new Date(2024, 8, 31).nextDate());
    }

    // Tests additionnels pour les dates invalides

    @Test
    void testDate_moisZeroInvalide() {
        assertThrows(IllegalArgumentException.class, () -> new Date(2024, 0, 10));
    }

    @Test
    void testDate_moisTreizeInvalide() {
        assertThrows(IllegalArgumentException.class, () -> new Date(2024, 13, 10));
    }

    @Test
    void testDate_jourZeroInvalide() {
        assertThrows(IllegalArgumentException.class, () -> new Date(2024, 5, 0));
    }

    @Test
    void testDate_jourTrenteDeuxInvalide() {
        assertThrows(IllegalArgumentException.class, () -> new Date(2024, 5, 32));
    }

    @Test
    void testDate_avrilTrenteEtUnInvalide() {
        assertThrows(IllegalArgumentException.class, () -> new Date(2024, 4, 31));
    }

    @Test
    void testDate_juinTrenteEtUnInvalide() {
        assertThrows(IllegalArgumentException.class, () -> new Date(2024, 6, 31));
    }

    @Test
    void testDate_septembreTrenteEtUnInvalide() {
        assertThrows(IllegalArgumentException.class, () -> new Date(2024, 9, 31));
    }

    @Test
    void testDate_novembreTrenteEtUnInvalide() {
        assertThrows(IllegalArgumentException.class, () -> new Date(2024, 11, 31));
    }

    @Test
    void testDate_fevrierTrenteAnneeBissextileInvalide() {
        assertThrows(IllegalArgumentException.class, () -> new Date(2020, 2, 30));
    }

    @Test
    void testDate_fevrierVingtNeufAnneeSiecleNonBissextileInvalide() {
        assertThrows(IllegalArgumentException.class, () -> new Date(1900, 2, 29));
    }

    // Tests additionnels pour les autres méthodes de la classe Date

    @Test
    void testIsLeapYear_vraiPour2020() {
        assertTrue(new Date(2020, 1, 1).isLeapYear());
    }

    @Test
    void testIsLeapYear_fauxPour2021() {
        assertFalse(new Date(2021, 1, 1).isLeapYear());
    }

    @Test
    void testIsLeapYear_vraiPour2000() {
        assertTrue(new Date(2000, 1, 1).isLeapYear());
    }

    @Test
    void testIsLeapYear_fauxPour1900() {
        assertFalse(new Date(1900, 1, 1).isLeapYear());
    }

    @Test
    void testEquals_memeDate() {
        assertEquals(new Date(2024, 5, 10), new Date(2024, 5, 10));
    }

    @Test
    void testEquals_dateDifferente() {
        assertNotEquals(new Date(2024, 5, 10), new Date(2024, 5, 11));
    }

    @Test
    void testToString() {
        assertEquals("2024/May/10", new Date(2024, 5, 10).toString());
    }
}
