import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class PredecessorBst {
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        int[] valores = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int num = sc.nextInt();
        sc.close();
        
        BST bst = new BST();
        for (int valor : valores)
            bst.add(valor);
        
        System.out.println(bst.predecessor(num));
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
            if (isEmpty()) this.root = new Node(value);
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
    
        public ArrayList<Integer> predecessor(int value) {
            ArrayList<Integer> caminho = new ArrayList<>();
    
            Node currNode = encontraNode(value);
            caminho.add(currNode.value);
            if (currNode.left == null) {
                while (currNode.parent != null) {
                    caminho.add(currNode.parent.value);
                    if (currNode.value > currNode.parent.value) break;
    
                    currNode = currNode.parent;
                }
            } else {
                currNode = currNode.left;
                while (currNode != null) {
                    caminho.add(currNode.value);
                    currNode = currNode.right;
                }
            }
            return caminho;
        }
    
        private Node encontraNode(int value) {
            Node currNode = root;
            while (currNode != null) {
                if (currNode.value == value) break;
    
                if (value < currNode.value)
                    currNode = currNode.left;
                else currNode = currNode.right;
            }
            return currNode;
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
