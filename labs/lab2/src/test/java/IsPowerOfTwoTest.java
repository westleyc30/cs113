import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class IsPowerOfTwoTest {

    IsPowerOfTwo ipot = new IsPowerOfTwo();
    @Test
    void oddNumberTest() {
        assertFalse(ipot.isPowerOfTwo(3));
        assertFalse(ipot.isPowerOfTwo(11));
        assertFalse(ipot.isPowerOfTwo(1));
        assertFalse(ipot.isPowerOfTwo(-1));
        assertFalse(ipot.isPowerOfTwo(9001));
    }
    @Test
    void evenNumberFalseTest() {
        assertFalse(ipot.isPowerOfTwo(10));
        assertFalse(ipot.isPowerOfTwo(2000));
        assertFalse(ipot.isPowerOfTwo(6));
    }
    @Test
    void evenNumbersTrueTest() {
        assertTrue(ipot.isPowerOfTwo(2));
        assertTrue(ipot.isPowerOfTwo(256));
    }
}