import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class BFS {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] valores = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        sc.close();

        BST bst = new BST();
        for (int valor: valores) 
            bst.add(valor);

        ArrayList<Integer> caminho = bst.bfs();
        String out = "";
        for (int v : caminho) 
            out += v + " ";

        System.out.println(out.trim());
    }

    public static class BST {
        private Node root;
        private int size;

        public BST() {
            this.root = null;
            this.size = 0;
        }

        public boolean isEmpty() {
            return root == null;
        }

        public void add(int value) {
            size++;
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
        }

        public ArrayList<Integer> bfs() {
            ArrayList<Integer> visitados = new ArrayList<>();
            Fila fila = new Fila(this.size);

            fila.addLast(root);
            while (!fila.isEmpty()) {
                Node aux = fila.removeFirst();
                visitados.add(aux.value);    
            
                Node[] next = getFilhos(aux);
                for (Node node : next)
                    if (node != null)
                        fila.addLast(node);
            }
            return visitados;
        }

        private Node[] getFilhos(Node node) {
            Node[] filhos = new Node[2];
            if (node.left != null) filhos[0] = node.left;
            if (node.right != null) filhos[1] = node.right;
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

    public static class Fila {
        private Node[] fila;
        private int head;
        private int tail;
        private int size;

        public Fila(int capacity) {
            fila = new Node[capacity];
            head = -1;
            tail = -1;
            this.size = 0;
        }

        public boolean isEmpty() {
            return head == -1;
        }

        public boolean isFull() {
            return size == fila.length;
        }

        public void addLast(Node value) {
            if (isFull()) throw new IllegalArgumentException("Fila cheia");
            if (isEmpty()) head++;
            tail = (tail + 1) % fila.length;
            fila[tail] = value;
            size++;
        }

        public Node removeFirst() {
            Node removed = fila[head];
            if (size == 1) {
                head = -1;
                tail = -1;
            } else head = (head + 1) % fila.length;
            size--;
            return removed; 


        }
    }
}
