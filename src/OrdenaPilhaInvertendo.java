import java.util.Arrays;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class OrdenaPilhaInvertendo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tamanho = Integer.parseInt(sc.nextLine());
        int[] valores = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        sc.close();

        Pilha pilha = new Pilha(tamanho);
        for (int valor : valores) 
            pilha.push(valor);
        
        pilha.ordenaPilha();
        System.out.println("-");
        while (!pilha.isEmpty()) 
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
            return this.topo == -1;
        }

        public void push(int valor) {
            if (this.topo == this.pilha.length-1) throw new IndexOutOfBoundsException();
            this.pilha[++this.topo] = valor;
        }

        public int pop() {
            if (this.topo == -1) throw new NoSuchElementException();
            return this.pilha[this.topo--];
        }

        public int peek() {
            return this.pilha[this.topo];
        }

        public int getMax(int index) {
            int maior = peek();

            Pilha auxPilha = new Pilha(index+1);
            for (int i = 0; i <= index; i++) {
                int elemento = pop();

                if (maior < elemento)
                    maior = elemento;
                
                auxPilha.push(elemento);
            }
            
            // Restitui a pilha para seu estado original
            for (int i = 0; i <= index; i++) 
                push(auxPilha.pop());

            return maior;
        }

        public void ordenaPilha() {
            Pilha auxPilha = new Pilha(this.topo+1);

            while (!isEmpty()) {
                int elemento = pop();

                if (auxPilha.isEmpty())
                    auxPilha.push(elemento);
                else {
                    while (!auxPilha.isEmpty() && auxPilha.peek() > elemento) 
                        push(auxPilha.pop());
                    
                    auxPilha.push(elemento);
                }
            }
            while (!auxPilha.isEmpty())
                push(auxPilha.pop());
        }
    }
}
