import java.util.Scanner;

public class TrocaVizinhosLinkedList {
    public static void main(String[] args) {
        LinkedList ll = new LinkedList();

        Scanner sc = new Scanner(System.in);
        String[] nums = sc.nextLine().split(" ");
        String indice = sc.nextLine();
        sc.close();
        
        for (int i = 0; i < nums.length; i++) 
            ll.addLast(Integer.parseInt(nums[i]));
        
        ll.swap(Integer.parseInt(indice));
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

        public void swap(int index) {
            Node node1 = getNode(index);
            Node pre1 = node1.prev;
            
            Node node2 = getNode(index+1);
            Node aft2 = node2.next;

            node2.next = node1;
            node1.prev = node2;

            node1.next = aft2;
            node2.prev = pre1;
            if (index != 0)
                pre1.next = node2;
            else 
                this.head = node2;
            
            if (index != size-2)
                aft2.prev = node1;
            else
                this.tail = node1;

        }

        private Node getNode(int index) {
            Node node = this.head;
            for (int i = 0; i < index; i++) 
                node = node.next;
            
            return node;
        }

        public String toString() {
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
