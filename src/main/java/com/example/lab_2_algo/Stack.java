package com.example.lab_2_algo;

public class Stack {

   public Node top = null;

   public void push(int item){
       if(top == null){
           top = new Node(item);
       }
       else {
            Node newNode = new Node(item);
            this.top.previous = newNode;
            newNode.next = this.top;
            newNode.previous = null;
            this.top = newNode;
       }
   }
   public int pop(){
       int tempNode = 0;
       if(top == null){
           System.out.println("Stack is empty");
           System.exit(1);
       }
       else if (this.top.next==null){
           tempNode = this.top.data;
           this.top = null;

       }
       else {
           tempNode = this.top.data;
           this.top = this.top.next;
           this.top.previous = null;

       }
       return tempNode;

   }

   public int peek(){
       return this.top.data;
   }

   public int size(){
       Node temp = this.top;
       int counter = 0;
       while (temp!=null){
           counter++;
           temp = temp.next;
       }
       return counter;
   }
   public boolean isEmpty(){
       return this.top == null;
   }
   public void printStack(){
       System.out.println("Stack elements are:");
       Node temp = this.top;
       while (temp!=null){
           System.out.print(temp.data + " ");
           temp = temp.next;
       }
   }
   public int search(int item){
       Node temp = this.top;
       int i = 0;
       int counter = -1;
       while (temp!=null){
           if(temp.data ==item){

               return i;
           }
           i++;
           temp = temp.next;
       }
       return counter;
   }


}
