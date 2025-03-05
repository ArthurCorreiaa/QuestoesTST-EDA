import java.util.Arrays;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class MaxPilha {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] valores = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        
        Pilha pilha = new Pilha(valores.length);
        for (int valor : valores) 
            pilha.push(valor);
        
        System.out.println(pilha.maxPilha());
    }

    public static class Pilha {
        private int topo;
        private int[] pilha;

        public Pilha(int tamanho) {
            this.topo = -1;
            this.pilha = new int[tamanho];
        }

        public boolean isEmpty() {
            return topo == -1;
        }

        public boolean isFull() {
            return topo == pilha.length-1;
        }

        public void push(int value) {
            if (isFull()) throw new IndexOutOfBoundsException();
            pilha[++topo] = value;
        }

        public int pop() {
            if (isEmpty()) throw new NoSuchElementException();
            return pilha[topo--];
        }

        public int peek() {
            return pilha[topo];
        }

        public int maxPilha() {
            Pilha auxPilha = new Pilha(topo+1);
            int maior = peek();
            while (!isEmpty()) {
                int currElement = pop();
                if (maior < currElement)
                    maior = currElement;
                
                auxPilha.push(currElement);
            }

            while (!auxPilha.isEmpty()) 
              push(auxPilha.pop());  
            
            return maior;
        }
        
    }

}
