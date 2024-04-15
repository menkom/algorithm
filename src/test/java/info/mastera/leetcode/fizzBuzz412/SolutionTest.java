package info.mastera.leetcode.fizzBuzz412;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    @Test
    void fizzBuzzTest() {
        Solution solution = new Solution();
        assertEquals(List.of("1", "2", "Fizz"), solution.fizzBuzz(3));
        assertEquals(List.of("1", "2", "Fizz", "4", "Buzz"), solution.fizzBuzz(5));
        assertEquals(List.of("1", "2", "Fizz", "4", "Buzz", "Fizz", "7", "8", "Fizz", "Buzz", "11", "Fizz", "13", "14", "FizzBuzz"), solution.fizzBuzz(15));
    }
}