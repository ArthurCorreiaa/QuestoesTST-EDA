import java.util.Scanner;

public class FiltraLinkedList {
    public static void main(String[] args) {
        LinkedList ll = new LinkedList();
        
        Scanner sc = new Scanner(System.in);
        String[] nums = sc.nextLine().split(" ");
        String remover = sc.nextLine();
        sc.close();

        for (int i = 0; i < nums.length; i++) 
            ll.addLast(Integer.parseInt(nums[i]));
        
        ll.removeValue(Integer.parseInt(remover));
        System.out.println(ll.toString());
    }
    

    public static class LinkedList {
        private Node head;
        private Node tail;
        private int size;

        public LinkedList () {
            this.head = null;
            this.tail = null;
            this.size = 0;
        }

        public boolean isEmpty() {
            return this.size == 0;
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
            this.size++;
        }

        public void removeFirst() {
            if (size == 1) {
                this.head = null;
                this.tail = null;
            } else {
                this.head = this.head.next;
                this.head.prev = null;
            }
            this.size--;
        }

        public void removeLast() {
            if (size == 1) {
                this.head = null;
                this.tail = null;
            } else {
                this.tail = this.tail.prev;
                this.tail.next = null;
            }
            this.size--;
        }

        public void remove(int index) {
            if (index == 0) {
                removeFirst();
            } else if (index == size-1) {
                removeLast();
            } else {
                Node prevNode = this.head;
                for (int i = 0; i < index-1; i++) {
                    prevNode = prevNode.next;
                }
                Node aftNode = prevNode.next.next;
                prevNode.next = aftNode;
                aftNode.prev = prevNode;
                size--;
            }
        }


        public void removeValue(int value) {
            Node currNode = this.head;
            int i = 0;
            while (i != size) {
                if (currNode.value == value)
                    remove(i);
                else {
                    i++;
                }
                currNode = currNode.next;
            }
        }

        public String toString() {
            if (isEmpty()) return "vazia";
            
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
