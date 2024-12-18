package info.mastera.practice;

import java.util.ArrayList;
import java.util.List;

/**
 * Write a function findCurrentQueueTop that processes an array of strings representing a series of queue operations and returns the number at the front of the queue after all operations have been performed.
 * Function signature:
 * • def findCurrentQueueTop(n,operations)
 * Parameters:
 * • n: number of operations
 * • operations: a list of strings, each representing a queue operation.
 * Notes:
 * • You must simulate the queue using an array or list data structure.
 * • "ENQUEUE x" adds element x to the back of the queue.
 * • "DEQUEUE" removes the element from the front of the queue.
 * • It is guaranteed that the queue will not be empty after performing all the given operations.
 * <p>
 * Example 1
 * Input:
 * • n = 2
 * • operations =
 * ENQUEUE 1
 * ENQUEUE 2
 * Output:
 * • 1
 * Explanation:
 * 1. Initially, the stack is empty: []
 * 2. Perform "ENQUEUE 1": queue = [1]
 * 3. Perform "ENQUEUE 2": queue = [2, 1]
 */
public class GorillaClass {

    public static int findCurrentQueueTop(List<String> operations) {
        List<Integer> list = new ArrayList<>(operations.size());

        for (String operation : operations) {
            var decoded = operation.split(" ");
            switch (decoded[0]) {
                case "ENQUEUE":
                    list.add(Integer.parseInt(decoded[1]));
                    break;
                case "DEQUEUE":
                    list.remove(0);
                    break;
            }
        }

        return list.get(0);
    }
}
