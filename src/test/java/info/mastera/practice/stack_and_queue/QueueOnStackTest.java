package info.mastera.practice.stack_and_queue;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class QueueOnStackTest {

    @Test
    void enqueueTest() {
        QueueOnStack<Integer> queueOnStack = new QueueOnStack<>();

        queueOnStack.add(1);
        queueOnStack.add(2);
        queueOnStack.add(3);

        Assertions.assertEquals(1, queueOnStack.poll()); // Output: 1
        Assertions.assertEquals(2, queueOnStack.peek());    // Output: 2
        Assertions.assertEquals(2, queueOnStack.poll()); // Output: 2
        Assertions.assertFalse(queueOnStack.isEmpty()); // Output: false
    }

    @Test
    void combinationTest() {
        QueueOnStack<Integer> queue = new QueueOnStack<>();

        queue.add(1);
        queue.add(2);
        queue.add(3);

        Assertions.assertEquals(1, queue.poll(), "Test 1 failed: Poll should return 1");
        Assertions.assertEquals(2, queue.poll(), "Test 1 failed: Poll should return 2");

        // Test 2: Poll until empty
        Assertions.assertEquals(3, queue.poll(), "Test 2 failed: Poll should return 3");
        Assertions.assertNull(queue.poll(), "Test 2 failed: Poll should return null when queue is empty");

        // Test 3: Add after polling everything
        queue.add(4);
        queue.add(5);

        Assertions.assertEquals(4, queue.poll(), "Test 3 failed: Poll should return 4");
        Assertions.assertEquals(5, queue.poll(), "Test 3 failed: Poll should return 5");

        // Test 4: Check interleaved add and poll
        queue.add(6);
        Assertions.assertEquals(6, queue.poll(), "Test 4 failed: Poll should return 6");
        queue.add(7);
        queue.add(8);
        Assertions.assertEquals(7, queue.poll(), "Test 4 failed: Poll should return 7");

        // Test 5: Empty queue check
        queue.poll(); // Poll the last element
        Assertions.assertNull(queue.poll(), "Test 5 failed: Poll should return null for an empty queue");

        Assertions.assertNull(queue.peek());
    }
}