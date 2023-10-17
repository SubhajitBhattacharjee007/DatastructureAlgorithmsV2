package org.stack;

import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Stack {

    private static final String STACK_UNDERFLOW_MSG = "Stack Underflow!";
    private static final Logger logger = Logger.getLogger(Stack.class.getName());
    static final int MAX = 100;
    int top;
    int[] a = new int[MAX];

    Stack() {
        top = -1;
    }

    public void push(int data) {
        if (top >= MAX - 1) {
            logger.log(Level.INFO, "Stack Overflow!");
        } else {
            a[++top] = data;
            logger.log(Level.INFO, "{0} Pushed into the stack.", data);
        }
    }

    public void pop() {
        if (top < 0) {
            logger.log(Level.INFO, STACK_UNDERFLOW_MSG);
        } else {
            logger.log(Level.INFO, "{0} Pop out from the stack.", a[top]);
            top--;
        }
    }

    public void peek() {
        if (top < 0) {
            logger.log(Level.INFO, STACK_UNDERFLOW_MSG);
        } else {
            logger.log(Level.INFO, "The peek value of the stack is {0}", a[top]);
        }
    }

    public void printStackValues() {
        if (top < 0) {
            logger.log(Level.INFO, STACK_UNDERFLOW_MSG);
        } else
            Arrays.stream(a).limit(top + 1L).forEach(s -> logger.log(Level.INFO, " Stack Values [{0}] ", s));
    }

    public static void main(String[] args) {
        Stack stack = new Stack();
        stack.push(100);
        stack.push(200);
        stack.push(300);
        stack.push(400);
        logger.log(Level.INFO, "Top of stack {0} ", stack.top);
        stack.printStackValues();
        stack.peek();
        stack.pop();
        stack.pop();
        stack.pop();
        logger.log(Level.INFO, "Top of stack {0} ", stack.top);
    }
}
