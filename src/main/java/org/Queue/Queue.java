package org.Queue;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Queue {

    private static final Logger log = Logger.getLogger(Queue.class.getName());
    private static final int MAX = 10;
    private final int[] a = new int[MAX];
    private int front;
    private int rear;

    Queue() {
        front = -1;
        rear = -1;
    }

    private boolean isFull() {
        return (rear == MAX - 1);
    }

    private boolean isEmpty() {
        return (front == -1);
    }

    private void enQueue(int data) {
        if (isFull()) {
            log.log(Level.INFO, "The Queue is full.");
        } else {
            if (front == -1) {
                front = 0;
            }
            rear++;
            a[rear] = data;
            log.log(Level.INFO, "The element {0} is inserted in the Queue.", data);
        }
    }

    private int deQueue() {
        int element;
        if (isEmpty()) {
            log.log(Level.INFO, "The Queue is empty.");
            return -1;
        } else {
            element = a[front];
            if (front >= rear) {
                front = -1;
                rear = -1;
            } else {
                front++;
            }
        }
        log.log(Level.INFO, "The removed element from the Queue is: {0}", element);
        return element;
    }

    private void displayQueue() {
        if (isEmpty()) {
            log.log(Level.INFO, "The Queue is empty.");
        } else {
            for (int i = front; i <= rear; i++) {
                log.log(Level.INFO, String.valueOf(a[i]));
            }
        }
    }

    public static void main(String[] args) {
        Queue queue = new Queue();
        queue.enQueue(100);
        queue.enQueue(50);
        queue.displayQueue();
        queue.deQueue();
    }
}
