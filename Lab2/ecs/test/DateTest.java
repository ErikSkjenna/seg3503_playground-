import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class DateTest {

    @Test
    void testNextDate_TC1() {
        Date d = new Date(1700, 6, 20);
        assertEquals(new Date(1700, 6, 21), d.nextDate());
    }

    @Test
    void testNextDate_TC2() {
        Date d = new Date(2005, 4, 15);
        assertEquals(new Date(2005, 4, 16), d.nextDate());
    }

    @Test
    void testNextDate_TC3() {
        Date d = new Date(1901, 7, 20);
        assertEquals(new Date(1901, 7, 21), d.nextDate());
    }

    @Test
    void testNextDate_TC4() {
        Date d = new Date(3456, 3, 27);
        assertEquals(new Date(3456, 3, 28), d.nextDate());
    }

    @Test
    void testNextDate_TC5() {
        Date d = new Date(1500, 2, 17);
        assertEquals(new Date(1500, 2, 18), d.nextDate());
    }

    @Test
    void testNextDate_TC6() {
        Date d = new Date(1700, 6, 29);
        assertEquals(new Date(1700, 6, 30), d.nextDate());
    }

    @Test
    void testNextDate_TC7() {
        Date d = new Date(1800, 11, 29);
        assertEquals(new Date(1800, 11, 30), d.nextDate());
    }

    @Test
    void testNextDate_TC8() {
        Date d = new Date(3453, 1, 29);
        assertEquals(new Date(3453, 1, 30), d.nextDate());
    }

    @Test
    void testNextDate_TC9() {
        Date d = new Date(444, 2, 29);
        assertEquals(new Date(444, 3, 1), d.nextDate());
    }

    @Test
    void testNextDate_TC10() {
        Date d = new Date(2005, 4, 30);
        assertEquals(new Date(2005, 5, 1), d.nextDate());
    }

    @Test
    void testNextDate_TC11() {
        Date d = new Date(3453, 1, 30);
        assertEquals(new Date(3453, 1, 31), d.nextDate());
    }

    @Test
    void testNextDate_TC12() {
        Date d = new Date(3456, 3, 30);
        assertEquals(new Date(3456, 3, 31), d.nextDate());
    }

    @Test
    void testNextDate_TC13() {
        Date d = new Date(1901, 7, 31);
        assertEquals(new Date(1901, 8, 1), d.nextDate());
    }

    @Test
    void testNextDate_TC14() {
        Date d = new Date(3453, 1, 31);
        assertEquals(new Date(3453, 2, 1), d.nextDate());
    }

    @Test
    void testNextDate_TC15() {
        Date d = new Date(3456, 12, 31);
        assertEquals(new Date(3457, 1, 1), d.nextDate());
    }

    @Test
    void testNextDate_TC16_exception() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Date(1500, 2, 31);
        });
    }

    @Test
    void testNextDate_TC17_exception() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Date(1500, 2, 29);
        });
    }

    @Test
    void testNextDate_TC18_exception() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Date(-1, 10, 20);
        });
    }

    @Test
    void testNextDate_TC19_exception() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Date(1458, 15, 12);
        });
    }

    @Test
    void testNextDate_TC20_exception() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Date(1975, 6, -50);
        });
    }
}