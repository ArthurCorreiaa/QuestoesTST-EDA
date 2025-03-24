import java.util.Arrays;
import java.util.Scanner;

public class SomaFolhasBST {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] valores = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        sc.close();

        BST bst = new BST();
        for (int valor : valores) 
            bst.add(valor);
        
        System.out.println(bst.somaFolhas());
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
    
        public int somaFolhas() {
            if (isEmpty()) return 0;
            return somaFolhas(root);
        }
    
        private int somaFolhas(Node node) {
            if (node == null) return 0;
            if (isLeaf(node)) return node.value;
            return somaFolhas(node.left) + somaFolhas(node.right);
        }
    
        private boolean isLeaf(Node node) {
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
        }
    }
}

