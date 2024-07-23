package Stacks;

import java.util.LinkedList;
import java.util.Queue;

public class StackArrays {
    int[] arr;
    int topOfStack;

    public StackArrays(int size) {
        this.arr = new int[size];
        this.topOfStack = -1;
        System.out.println("The stack is created with a size of: " + size);
    }
    //Check if it is empty

    public boolean isEmpty() {
        if (topOfStack == -1) {
            System.out.println("Stack is empty");
            return true;
        } else {
            System.out.println("Stack is not empty");
            return false;
        }
    }

    //check if stack is Full
    public boolean isFull() {
        if (topOfStack == arr.length - 1) {
            System.out.println("Stack is full");
            return true;
        } else {
            System.out.println("Stack is not full");
            return false;
        }
    }

    //implement a push method
    public void push(int value) {
        if (isFull()) {
            System.out.println("the stack is full");
        } else {
            arr[topOfStack + 1] = value;
            topOfStack++;
            System.out.println("The value is successfully inserted");
        }
    }

    //implement pop method
    public void pop() {
        if (this.isEmpty()) {
            System.out.println("The stack is empty");
            return; // indicating stack is empty
        }
        topOfStack--;
        System.out.println("The value of " + arr[topOfStack + 1] + " was removed");
    }

    //implement peek
    public void peek() {
        if (this.isEmpty()) {
            System.out.println("The stack is empty");
            return; // indicating stack is empty
        }
        System.out.println("The value of " + arr[topOfStack] + " is at the top of the stack");
    }

    //implement delete a stack
    public void clearStack() {
        this.topOfStack = -1;
    }

    public static void main(String[] args) {
        StackArrays stackArrays = new StackArrays(5);
        stackArrays.push(1);
        stackArrays.peek();
        stackArrays.push(2);
        stackArrays.push(3);
        stackArrays.pop();
        stackArrays.peek();
        stackArrays.isEmpty();
        stackArrays.isFull();
        stackArrays.clearStack();
        stackArrays.isEmpty();
    }

    // use the stack datastructure to check whether a word is a palindrome or not eg racecar  == racecar
    public static class PalindromeCheck {
        public static boolean isPalindrome(String word){
            Queue<Character> wordQueue = new LinkedList<>();
            for(char c : word.toCharArray()){
                wordQueue.add(c);
            }
            String reverseWord = new StringBuilder(word).reverse().toString();
            Queue<Character> reverseWordQueue = new LinkedList<>();
            for(char c : reverseWord.toCharArray()){
                reverseWordQueue.add(c);
            }

            while(!wordQueue.isEmpty() && !reverseWordQueue.isEmpty()){
                if(wordQueue.remove() != reverseWordQueue.remove()){
                    return false;
                }
            }

            return wordQueue.isEmpty() && reverseWordQueue.isEmpty();
        }

        public static void main(String[] args) {
            System.out.println(isPalindrome("racecar")); // Expected: true
            System.out.println(isPalindrome("too")); // Expected: false
        }
    }
}