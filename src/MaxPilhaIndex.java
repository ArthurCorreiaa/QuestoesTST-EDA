import java.util.NoSuchElementException;
import java.util.Scanner;

public class MaxPilhaIndex {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] valores = sc.nextLine().split(" ");
        String indice = sc.nextLine();
        sc.close();

        Pilha pilha = new Pilha(valores.length);
        for (int i = 0; i < valores.length; i++)
            pilha.push(Integer.parseInt(valores[i]));

        System.out.println(pilha.maxPilhaIndex(Integer.parseInt(indice)));
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

        public void push(int valor) {
            if (this.topo == this.pilha.length-1) throw new IndexOutOfBoundsException();
            this.pilha[++this.topo] = valor;
        }

        public int pop() {
            if (this.topo == -1) throw new NoSuchElementException();
            return this.pilha[this.topo--];
        }

        public int maxPilhaIndex(int index) {
            int maior = 0;

            Pilha auxPilha = new Pilha(index+1);
            for (int i = 0; i <= index; i++) {
                int valor = pop();

                if (i == 0)
                    maior = valor;

                if (maior < valor)
                    maior = valor;
                
                auxPilha.push(valor);
            }

            for (int i = 0; i <= index; i++) 
                push(auxPilha.pop());
            
            return maior;
        }
    }
}
