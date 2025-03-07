import java.util.Arrays;
import java.util.Scanner;

public class RemoveIndexLinkedList {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] valores = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int indice = sc.nextInt();
        sc.close();

        LinkedList ll = new LinkedList();
        for (int valor : valores) 
            ll.addLast(valor);
        
        ll.remove(indice);
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
                this.tail.next = newNode;
                newNode.prev = this.tail;
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

        public void remove(int index) {
            Node currNode = this.head;
            for (int i = 0; i < index; i++)
                currNode = currNode.next;
    
            if (currNode == this.head) 
                removeFirst();
            else if (currNode == this.tail)
                removeLast();
            else {
                Node preNode = currNode.prev;
                Node aftNode = currNode.next;
                
                preNode.next = aftNode;
                aftNode.prev = preNode;
                size--;
            }
        }

        public String toString() {
            String llString = "";
            Node currNode = this.head;
            while (currNode != null) {
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
