import java.util.Arrays;
import java.util.Scanner;

public class ContaNosInternosBST {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] valores = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        sc.close();
    
        BST bst = new BST();
        for (int valor : valores) 
            bst.add(valor);
        
        
        System.out.println(bst.contaNosInternos());
    }
    public static class BST {
        private Node root;
        // private int size;
    
        public BST() {
            root = null;
            // size = 0;
        }
    
        public boolean isEmpty() {
            return root == null;
        }
    
        public void add(int value) {
            if (isEmpty()) root = new Node(value);
            else {
                Node currNode = root;
                while (currNode != null) {
                    if (value < currNode.value) {
                        if (currNode.left == null) {
                            Node node = new Node(value);
                            currNode.left = node;
                            node.parent = currNode;
                            return;
                        }
                        currNode = currNode.left; 
                    } else {
                        if (currNode.right == null) {
                            Node node = new Node(value);
                            currNode.right = node;
                            node.parent = currNode;
                            return;
                        }
                        currNode = currNode.right;
                    }
                }
            }
            // size++;
        }
    
        public int contaNosInternos() {
            Node node = root;
            return contaNosInternos(node);
        }
    
        private int contaNosInternos(Node node) {
            if (node == null || isFolha(node)) return 0;
     
            return 1 + contaNosInternos(node.left) + contaNosInternos(node.right);
        }
    
        private boolean isFolha(Node node) {
            return node.left == null && node.right == null;
        } 
    
    }
    
    public static class Node {
        int value;
        Node left;
        Node right;
        Node parent;
    
        public Node(int value) {
            this.value = value;
            left = null;
            right = null;
            parent = null;
        }
        
    }
}

