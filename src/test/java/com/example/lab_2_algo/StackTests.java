package com.example.lab_2_algo;

import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;

class StackTests {
    @Test
    void testSearchNotExisting() {
        Stack stack = new Stack();
        stack.push(14);
        stack.push(5);
        stack.push(12);
        stack.push(7);
        int actual = stack.search(4);
        assertEquals(-1, actual);
    }
    @Test
    void testSearchExisting(){
        Stack stack = new Stack();
        stack.push(14);
        stack.push(5);
        stack.push(12);
        stack.push(7);
        int actual = stack.search(5);
        assertEquals(2, actual);
    }
    @Test
    void testSearchFirstExisting(){
        Stack stack = new Stack();
        stack.push(14);
        stack.push(5);
        stack.push(12);
        stack.push(7);
        stack.push(12);
        int actual = stack.search(12);
        assertEquals(0, actual);
    }
    @Test
    void testIfEmpty(){
        Stack stack = new Stack();
        boolean actual = stack.isEmpty();
        assertEquals(true, actual);
    }
    @Test
    void testSize(){
        Stack stack = new Stack();
        stack.push(14);
        stack.push(5);
        stack.push(12);
        int actual = stack.size();
        assertEquals(3, actual);
    }
    @Test
    void testPeek(){
        Stack stack = new Stack();
        stack.push(14);
        stack.push(5);
        stack.push(12);
        int actual = stack.peek();
        assertEquals(12, actual);
    }
    @Test
    void testPop(){
        Stack stack = new Stack();
        stack.push(14);
        stack.push(5);
        stack.push(12);
        int actual = stack.pop();
        assertEquals(12, actual);
    }
    @Test
    void testPopEmptyStack(){
        Stack stack = new Stack();
        stack.pop();
        int actual = stack.pop();
        assertEquals(1,actual);
    }

}
