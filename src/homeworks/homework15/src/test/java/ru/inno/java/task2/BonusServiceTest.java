package ru.inno.java.task2;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BonusServiceTest {

    private final BonusService service = new BonusService();

    @Test
    void shouldCalculateForRegisteredUser() {
        long result = service.calculate(1000, true);
        assertEquals(30, result);
    }

    @Test
    void shouldCalculateForUnregisteredUser() {
        long result = service.calculate(1000, false);
        assertEquals(10, result);
    }

    @Test
    void shouldApplyLimit() {
        long result = service.calculate(100_000, true);
        assertEquals(500, result);
    }

    @Test
    void shouldReturnZero() {
        long result = service.calculate(0, true);
        assertEquals(0, result);
    }
}