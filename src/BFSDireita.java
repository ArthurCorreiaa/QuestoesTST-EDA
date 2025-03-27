import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Queue;
import java.util.Scanner;

public class BFSDireita {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] valores = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        sc.close();

        BST bst = new BST();
        for (int valor: valores) 
            bst.add(valor);

        ArrayList<Integer> caminho = bst.bfsDireita();
        String out = "";
        for (int v : caminho) 
            out += v + " ";

        System.out.println(out.substring(0, out.length()-1));
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

        public ArrayList<Integer> bfsDireita() {
            ArrayList<Integer> visitados = new ArrayList<>();
            Queue<Node> queue = new ArrayDeque<>();

            queue.add(root);
            while (!queue.isEmpty()) {
                Node aux = queue.poll();
                visitados.add(aux.value);

                ArrayList<Node> next = getFilhos(aux);
                for (Node node : next) {
                    queue.add(node);
                }
            }

            return visitados;
        }

        private ArrayList<Node> getFilhos(Node node) {
            ArrayList<Node> filhos = new ArrayList<>(2);
            if (node.right != null) filhos.add(node.right);
            if (node.left != null) filhos.add(node.left);
            return filhos;
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
