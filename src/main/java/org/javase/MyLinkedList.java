package org.javase;

public class MyLinkedList<T> {
    private Node head;
    private int size;

    public Node getHead() {
        return head;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public class Node {
        private final T value;
        private Node next;

        public Node(T value) {
            this.value = value;
            this.next = null;
        }

        public T getValue() {
            return value;
        }

        public Node getNext() {
            return next;
        }
    }

    public void addLast(T value) {
        if (isEmpty()) {
            head = new Node(value);
            return;
        }

        Node temp = head;
        while (temp.getNext() != null) {
            temp = temp.getNext();
        }

        temp.next = new Node(value);
    }

    public T removeLast(){
        if(isEmpty()){
            throw new RuntimeException("List is empty!");
        }

        Node temp = head;
        Node prev = head;
        while(temp.next != null){
            prev = temp;
            temp = temp.getNext();
        }

        prev.next = null;
        return temp.getValue();
    }

    public void print() {
        if (isEmpty()) {
            return;
        }

        Node temp = head;
        while (temp.next != null) {
            System.out.print(temp.getValue() + " ");
            temp = temp.getNext();
        }

        System.out.print(temp.value);
    }
}
