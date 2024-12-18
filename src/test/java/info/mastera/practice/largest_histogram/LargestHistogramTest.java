package info.mastera.practice.largest_histogram;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class LargestHistogramTest {

    @Test
    void largestHistogram() {
        Assertions.assertEquals(10, LargestHistogram.largestRectangleArea(new int[]{2, 1, 5, 6, 2, 3}));
        Assertions.assertEquals(4, LargestHistogram.largestRectangleArea(new int[]{2, 1, 2, 1}));
        Assertions.assertEquals(8, LargestHistogram.largestRectangleArea(new int[]{2, 2, 2, 2}));
        Assertions.assertEquals(8, LargestHistogram.largestRectangleArea(new int[]{2, 1, 1, 8}));
    }
}