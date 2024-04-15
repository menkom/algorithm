package info.mastera.practice.fizzBuzz;

import java.util.function.Function;

/**
 * version of Fizz and Buzz puzzle
 * i is divisible by 3 => "Fizz"
 * i is divisible by 5 => "Buzz"
 * i is divisible by 3 and 5 => "FizzBuzz"
 */
public class Solution {

    Function<Integer, String> fizz = i -> i % 3 == 0 ? "Fizz" : "";
    Function<Integer, String> buzz = i -> i % 5 == 0 ? "Buzz" : "";

    public String fizzOrBuzz(int value) {
        return fizz.apply(value) + buzz.apply(value);
    }

    public String fizzOrBuzz1(int value) {
        boolean fizz = value % 3 == 0;
        boolean buzz = value % 5 == 0;
        if (fizz && buzz) {
            return "FizzBuzz";
        } else {
            if (fizz) {
                return "Fizz";
            } else if (buzz) {
                return "Buzz";
            } else {
                return "";
            }
        }
    }
}
