import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PowerOfTwoTest {

    int[] numberArray = {4, 16, 3, 64};
    boolean[] expectedResults = {true, false, false, true};

    @Test
    void testNumbers() {
        assertEquals( expectedResults[0],PowerOfTwo.isPowerOfTwo(numberArray[0]));
        assertEquals( expectedResults[1],PowerOfTwo.isPowerOfTwo(numberArray[1]));
        assertEquals( expectedResults[2],PowerOfTwo.isPowerOfTwo(numberArray[2]));
        assertEquals( expectedResults[3],PowerOfTwo.isPowerOfTwo(numberArray[3]));
    }

    @Test
    void testPowerOfThree() {
        assertEquals(true, PowerOfTwo.isPowerOfThree(27));
    }
}