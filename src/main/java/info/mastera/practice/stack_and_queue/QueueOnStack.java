package info.mastera.practice.stack_and_queue;

import java.util.Stack;

public class QueueOnStack<E> {

    private final Stack<E> stackMain;
    private final Stack<E> stackInverse;

    public QueueOnStack() {
        stackMain = new Stack<>();
        stackInverse = new Stack<>();
    }

    public E add(E element) {
        return stackMain.push(element);
    }

    public E poll() {
        if (stackInverse.isEmpty()) {
            while (!stackMain.isEmpty()) {
                stackInverse.push(stackMain.pop());
            }
        }
        return stackInverse.isEmpty() ? null : stackInverse.pop();
    }

    public E peek() {
        if (stackInverse.isEmpty()) {
            while (!stackMain.isEmpty()) {
                stackInverse.push(stackMain.pop());
            }
        }
        return stackInverse.isEmpty() ? null : stackInverse.peek();
    }

    public boolean isEmpty() {
        return stackMain.isEmpty() && stackInverse.isEmpty();
    }

    public int size() {
        return stackMain.size() + stackInverse.size();
    }
}
