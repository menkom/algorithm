package info.mastera.practice;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

class InterviewTest {


    // Дан массив из целых чисел, нужно найти максимальное число в нем,
    // которое обязательно имеет в этом массиве
    //зеркальное отрицательное, равное ему по модулю.
    // Иначе вернуть ноль. Т.е. в массиве [5, -3, 1, 3, -2] правильный
    //ответ будет 3, т.к. "-3" в нем есть, а "-5" нету, потому 5 не подходит.
    // Для массива [1,2,3, -5] функция должна
    //вернуть 0, так как ни для одного положительного числа в нем нет равного ему по модулю отрицательного


    int getMirror(int[] numbers) {
        Set<Integer> previous = new HashSet<>(numbers.length);
        int max = 0;

        for (int i = 0; i < numbers.length - 1; i++) {
            var current = numbers[i];
            if (previous.contains(-current)) {
                max = Math.max(max, current);
            } else {
                previous.add(current);
            }
        }

        return max;
    }

    @Test
    void interviewTest() {
        Assertions.assertEquals(0, getMirror(new int[]{}));
        Assertions.assertEquals(3, getMirror(new int[]{5, -3, 1, 3, -2, -3}));
        Assertions.assertEquals(0, getMirror(new int[]{1, 2, 3, -5}));
    }
}
