import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CupTest {

    @Test
    void getLiquidType() {
        Cup c = new Cup("Water", 0.5);

        assertEquals("Water", c.getLiquidType());
    }
    @Test
    void getPercentageFull() {
        Cup c = new Cup("Water", 0.5);

        assertEquals(.5, c.getPercentFull());
    }
}