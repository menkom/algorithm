package info.mastera.leetcode.fizzBuzz412;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.stream.IntStream;

/**
 * 412. Fizz Buzz
 * Easy
 * Topics
 * Companies
 * Given an integer n, return a string array answer (1-indexed) where:
 * <p>
 * answer[i] == "FizzBuzz" if i is divisible by 3 and 5.
 * answer[i] == "Fizz" if i is divisible by 3.
 * answer[i] == "Buzz" if i is divisible by 5.
 * answer[i] == i (as a string) if none of the above conditions are true.
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: n = 3
 * Output: ["1","2","Fizz"]
 * Example 2:
 * <p>
 * Input: n = 5
 * Output: ["1","2","Fizz","4","Buzz"]
 * Example 3:
 * <p>
 * Input: n = 15
 * Output: ["1","2","Fizz","4","Buzz","Fizz","7","8","Fizz","Buzz","11","Fizz","13","14","FizzBuzz"]
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= n <= 104
 */
public class Solution {

    private final Function<Integer, String> fizz = i -> i % 3 == 0 ? "Fizz" : "";
    private final Function<Integer, String> buzz = i -> i % 5 == 0 ? "Buzz" : "";
    private final BiFunction<Integer, String, String> result = (i, preResult) -> "".equals(preResult) ? i.toString() : preResult;

    public List<String> fizzBuzz1(int n) {
        return IntStream.rangeClosed(1, n)
                .mapToObj(i -> result.apply(i, fizz.apply(i) + buzz.apply(i)))
                .toList();
    }

    public List<String> fizzBuzz(int n) {
        List<String> result = new ArrayList<>(n);
        for (int i = 1; i <= n; i++) {
            boolean fizz = i % 3 == 0;
            boolean buzz = i % 5 == 0;
            if (fizz && buzz) {
                result.add("FizzBuzz");
            } else if (fizz) {
                result.add("Fizz");
            } else if (buzz) {
                result.add("Buzz");
            } else {
                result.add(String.valueOf(i));
            }
        }
        return result;
    }
}
