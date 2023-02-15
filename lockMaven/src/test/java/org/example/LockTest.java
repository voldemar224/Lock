package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LockTest {
    @Test
    void fourEqualDigitsNeedZeroRolls() {
        Lock testLock = new Lock(3,3,3,3);
        assertEquals(0, testLock.findMinRollsToEquality());
    }
    @Test
    void rollOneTime() {
        Lock testLock = new Lock(4,4,5,4);
        assertEquals(1, testLock.findMinRollsToEquality());
    }
    @Test
    void randomCombination() {
        Lock testLock = new Lock(1,9,1,9);
        assertEquals(4, testLock.findMinRollsToEquality());
    }
    @Test
    void negativeNumberShouldReturnIllegalArgumentException() {
        assertThrows(IllegalArgumentException.class,
                () -> {
                    new Lock(1,9,-1,9);;
                });
    }
    @Test
    void twoDigitNumberShouldReturnIllegalArgumentException() {
        assertThrows(IllegalArgumentException.class,
                () -> {
                    new Lock(1,29,1,9);;
                });
    }
}