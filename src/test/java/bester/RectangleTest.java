package bester;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class RectangleTest {
    @Test
    public void areaShouldBeEqualToLengthyMultipliedByBreadth() throws Exception {
        assertEquals(6.0, new Rectangle(2, 3).area(), 0.0);
        assertEquals(0.0, new Rectangle(0, 1).area(), 0.0);
        assertEquals(3.75, new Rectangle(1.5, 2.5).area(), 0.0);
    }

    @Test
    public void largerRectangleShouldBeBetterThanSmallerOne() throws Exception {
        final Rectangle smallRectangle = new Rectangle(1, 1);
        final Rectangle largeRectangle = new Rectangle(2, 2);

        assertTrue(largeRectangle.isBetterThan(smallRectangle));
    }

    @Test
    public void smallerRectangleShouldNotBeBetterThanLargerOne() throws Exception {
        final Rectangle largeRectangle = new Rectangle(2, 5);
        final Rectangle smallRectangle = new Rectangle(1, 2);

        assertFalse(smallRectangle.isBetterThan(largeRectangle));
    }
}