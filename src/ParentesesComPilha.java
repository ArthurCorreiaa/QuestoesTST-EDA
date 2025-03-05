import java.util.NoSuchElementException;
import java.util.Scanner;

public class ParentesesComPilha {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] parenteses = sc.nextLine().split("");
        sc.close();

        Pilha pilhaParenteses = new Pilha(parenteses.length);
        for (String parentese : parenteses) 
            pilhaParenteses.push(parentese);    
        
        String valido = pilhaParenteses.verificaParenteses() ?  valido = "S": "N";
        System.out.println(valido);
    }  

    public static class Pilha {
        private int topo;
        private String[] pilha;

        public Pilha(int tamanho) {
            topo = -1;
            pilha = new String[tamanho];
        }

        public boolean isEmpty() {
            return topo == -1;
        }

        public boolean isFull() {
            return topo == pilha.length-1;
        }

        public void push(String valor) {
            if (isFull()) throw new IndexOutOfBoundsException();
            pilha[++topo] = valor;
        }

        public String pop() {
            if (isEmpty()) throw new NoSuchElementException();
            return pilha[topo--];
        }

        public String peek() {
            return pilha[topo];
        }

        public boolean verificaParenteses() {
            int contaAberto = 0, contaFechado = 0;
            
            Pilha auxPilha = new Pilha(topo+1);
            while (!isEmpty()) {
                String elemento = pop();
                if (elemento.equals(")"))
                    contaAberto++;
                else {
                    if (contaAberto <= contaFechado)
                       return false;
                    contaFechado++;
                }
                
                auxPilha.push(elemento);
            }
            if (contaAberto != contaFechado)
                return false;

            return true;
        }
    }
}
