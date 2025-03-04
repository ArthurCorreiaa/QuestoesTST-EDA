import java.util.Scanner;

public class TrimLinkedList {
    public static void main(String[] args) {
        LinkedList ll = new LinkedList();

        Scanner sc = new Scanner(System.in);
        String[] nums = sc.nextLine().split(" ");
        String qnt = sc.nextLine();

        for (int i = 0; i < nums.length; i++)
            ll.addLast(Integer.parseInt(nums[i]));
        
        ll.trimLL(Integer.parseInt(qnt));
        System.out.println(ll.toString());
    }

    public static class LinkedList {
        private Node head;
        private Node tail;
        private int size;

        public LinkedList() {
            this.head = null;
            this.tail = null;
            this.size = 0;
        }

        public boolean isEmpty() {
            return size == 0;
        }

        public void addLast(int value) {
            Node newNode = new Node(value);

            if (isEmpty()) {
                this.head = newNode;
                this.tail = newNode;
            } else {
                newNode.prev = this.tail;
                this.tail.next = newNode;
                this.tail = newNode;
            }
            size++;
        }

        public void removeFirst() {
            if (size == 1) {
                this.head = null;
                this.tail = null;
            } else {
                this.head = this.head.next;
                this.head.prev = null;
            }
            size--;
        }

        public void removeLast() {
            if (size == 1) {
                this.head = null;
                this.tail = null;
            } else { 
                this.tail = this.tail.prev;
                this.tail.next = null;
            }
            size--;
        }

        public void trimLL(int qnt) {
            int iTrim = 0;
            while (iTrim != qnt) {
                removeFirst();
                removeLast();
                iTrim++;
            }
        }

        public String toString() {
            if (isEmpty()) return "vazia";

            String llString = "";

            Node currNode = this.head;
            for (int i = 0; i < size; i++) {
                llString += currNode.value + " ";
                currNode = currNode.next;
            }
            return llString.substring(0, llString.length()-1);
        }
    }

    public static class Node {
        int value;
        Node next;
        Node prev;

        public Node(int value) {
            this.value = value;
            this.next = null;
            this.prev = null;
        }
    }
}
