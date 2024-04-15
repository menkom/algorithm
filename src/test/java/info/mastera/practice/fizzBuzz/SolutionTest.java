package info.mastera.practice.fizzBuzz;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    void fizzBuzzTest() {
        Solution solution = new Solution();
        assertEquals("", solution.fizzOrBuzz(1));
        assertEquals("Fizz", solution.fizzOrBuzz(3));
        assertEquals("Buzz", solution.fizzOrBuzz(5));
        assertEquals("FizzBuzz", solution.fizzOrBuzz(15));
    }
}