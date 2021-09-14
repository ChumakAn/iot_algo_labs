package com.example.lab_2_algo;

public class Runner {
    public static void main(String[] args) {
        Stack stack = new Stack();
        stack.push(4);
        stack.push(5);
        stack.push(1);
        stack.push(2);
        stack.pop();
        stack.printStack();
        System.out.println("Stack is empty: " + stack.isEmpty());
        System.out.println(stack.search(5));

    }
}
