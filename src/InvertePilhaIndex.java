import java.util.NoSuchElementException;
import java.util.Scanner;

public class InvertePilhaIndex {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String tamanho = sc.nextLine();
        String[] valores = sc.nextLine().split(" ");
        String indiceTroca = sc.nextLine();
        sc.close();

        System.out.println("-");

        Pilha pilha = new Pilha(Integer.parseInt(tamanho));
        for (int i = 0; i < valores.length; i++) 
            pilha.push(Integer.parseInt(valores[i]));
        
        pilha.invertePilha(Integer.parseInt(indiceTroca));

        for (int i = 0; i < Integer.parseInt(tamanho); i++)
            System.out.println(pilha.pop());
    }

    public static class Pilha {
        private int topo;
        private int[] pilha;

        public Pilha() {
            this(5);
        }

        public Pilha(int tamanho) {
            this.topo = -1;
            this.pilha = new int[tamanho];
        }

        public boolean isEmpty() {
            return topo == -1;
        }

        public void push(int valor) {
            if (topo == this.pilha.length-1) throw new IndexOutOfBoundsException();
            this.pilha[++this.topo] = valor;
        }
        
        public int pop() {
            if (isEmpty()) throw new NoSuchElementException();
            return this.pilha[this.topo--];
        }

        public int peek() {
            if (isEmpty()) throw new NoSuchElementException();
            return this.pilha[this.topo];
        }
        
        public void invertePilha(int index) {
            if (isEmpty()) throw new NoSuchElementException();

            Pilha auxPilha = new Pilha(index+1);
            for (int i = 0; i <= index; i++) 
                auxPilha.push(this.pop());
            
            Pilha pilhaInvertida = new Pilha(index+1);
            for (int i = 0; i <= index; i++) 
                pilhaInvertida.push(auxPilha.pop());
            
            int i = 0;
            while (i <= index) {
                this.push(pilhaInvertida.pop());
                i++;
            }
        }
    }
}
