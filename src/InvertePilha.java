import java.util.Arrays;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class InvertePilha {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tamanho = Integer.parseInt(sc.nextLine());
        int[] valores = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        sc.close();

        Pilha pilha = new Pilha(tamanho);
        for (int valor : valores) 
            pilha.push(valor);
        
        pilha.invertePilha();
        while (!pilha.isEmpty()) 
            System.out.println(pilha.pop());
        
    }
    
    public static class Pilha {
        private int[] pilha;
        private int topo;

        public Pilha(int tamanho) {
            this.pilha = new int[tamanho];
            this.topo = -1;
        }

        public boolean isEmpty() {
            return topo == -1;
        }

        public boolean isFull() {
            return topo == pilha.length-1;
        }

        public void push(int value) {
            if (isFull()) throw new IndexOutOfBoundsException();

            this.pilha[++this.topo] = value;
        }

        public int pop() {
            if (isEmpty()) throw new NoSuchElementException();

            return this.pilha[this.topo--];
        }

        public void invertePilha() {
            Pilha auxPilha = new Pilha(topo+1);
            while (!isEmpty())
                auxPilha.push(pop());
            
            Pilha pilhaInvertida = new Pilha(pilha.length);
            while (!auxPilha.isEmpty())
                pilhaInvertida.push(auxPilha.pop());
            
            while (!pilhaInvertida.isEmpty()) 
                push(pilhaInvertida.pop());
        }
    }
}
