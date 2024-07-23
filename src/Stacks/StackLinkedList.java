package Stacks;

class Node {
    int data;
    Node next;

    public Node(int data) {
        this.data = data;
        this.next = null;
    }
}
public class StackLinkedList {
    private Node top;

    public StackLinkedList() {
        this.top = null;
        System.out.println("The stack is created");
    }

    // Check if the stack is empty
    public boolean isEmpty() {
        if (top == null) {
            System.out.println("Stack is empty");
            return true;
        } else {
            System.out.println("Stack is not empty");
            return false;
        }
    }

    // Implement push method
    public void push(int value) {
        Node newNode = new Node(value);
        newNode.next = top;
        top = newNode;
        System.out.println("The value " + value + " is successfully inserted");
    }

    // Implement pop method
    public void pop() {
        if (isEmpty()) {
            System.out.println("The stack is empty");
            return; // indicating stack is empty
        }
        System.out.println("The value of " + top.data + " was removed");
        top = top.next;
    }

    // Implement peek method
    public void peek() {
        if (isEmpty()) {
            System.out.println("The stack is empty");
            return; // indicating stack is empty
        }
        System.out.println("The value of " + top.data + " is at the top of the stack");
    }

    // Implement clearStack method
    public void clearStack() {
        top = null;
        System.out.println("The stack has been cleared");
    }

    // Use the stack data structure to check whether a word is a palindrome or not
    public static boolean isPalindrome(String word) {
        StackLinkedList stack = new StackLinkedList();
        for (char c : word.toCharArray()) {
            stack.push(c);
        }
        StringBuilder reverseWord = new StringBuilder();
        Node current = stack.top;
        while (current != null) {
            reverseWord.append((char) current.data);
            current = current.next;
        }
        return word.contentEquals(reverseWord);
    }

    public static void main(String[] args) {
        StackLinkedList stackLinkedList = new StackLinkedList();
        stackLinkedList.push(1);
        stackLinkedList.peek();
        stackLinkedList.push(2);
        stackLinkedList.push(3);
        stackLinkedList.pop();
        stackLinkedList.peek();
        stackLinkedList.isEmpty();
        stackLinkedList.clearStack();
        stackLinkedList.isEmpty();

        // Test palindrome
        System.out.println("racecar is a palindrome: " + isPalindrome("racecar")); // Expected: true
        System.out.println("too is a palindrome: " + isPalindrome("too")); // Expected: false
    }
}


