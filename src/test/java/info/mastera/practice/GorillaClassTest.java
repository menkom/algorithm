package info.mastera.practice;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static info.mastera.practice.GorillaClass.findCurrentQueueTop;

class GorillaClassTest {

    @Test
    void test() {
        Assertions.assertEquals(20, findCurrentQueueTop(List.of("ENQUEUE 20")));
        Assertions.assertEquals(1, findCurrentQueueTop(List.of("ENQUEUE 1", "ENQUEUE 2")));
        Assertions.assertEquals(80, findCurrentQueueTop(List.of("ENQUEUE 20", "DEQUEUE", "ENQUEUE 40", "ENQUEUE 80", "DEQUEUE")));
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // input example
        // 5
        // ENQUEUE 20
        // DEQUEUE
        // ENQUEUE 40
        // ENQUEUE 80
        // DEQUEUE

        int n = Integer.parseInt(scanner.nextLine());

        List<String> operations = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            operations.add(scanner.nextLine());
        }

        // Call candidate function
        int result = findCurrentQueueTop(operations);

        // Print result
        System.out.println(result);
    }

}