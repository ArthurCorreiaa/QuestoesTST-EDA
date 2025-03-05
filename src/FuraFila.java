import java.util.Arrays;
import java.util.Scanner;

public class FuraFila {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] valores = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int posicao = sc.nextInt();
        sc.close();

        Fila fila = new Fila(valores.length);
        for (int valor : valores) 
            fila.addLast(valor);
        
        fila.furaFila(posicao);
    }


    public static class Fila {
        private int head;
        private int tail;
        private int[] fila;
        private int size;

        public Fila(int tamanho) {
            head = -1;
            tail = -1;
            fila = new int[tamanho];
            size = 0;
        }

        public boolean isEmpty() {
            return head == -1;
        }

        public boolean isFull() {
            return size == fila.length;
        }

        public void addLast(int value) {
            if (isFull()) throw new IndexOutOfBoundsException();

            if (isEmpty())
                this.head++;
            
            this.tail = (this.tail + 1) % this.fila.length;
            this.fila[this.tail] = value;
            this.size++;
        }

        public void removeFirst() {
            if (size == 1) {
                this.head = -1;
                this.tail = -1;
            } else 
                this.head++;
            
            size--;
        }

        public void furaFila(int index) {
            for (int i = index; i < this.size; i++) {
                for (int j = i; j > i-index; j--) {
                    int aux = fila[j];
                    fila[j] = fila[j-1];
                    fila[j-1] = aux;
                }
                System.out.println(Arrays.toString(fila));
            }
        }
    }
}
