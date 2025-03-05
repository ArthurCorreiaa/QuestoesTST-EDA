import java.util.Scanner;

public class Parenteses {
    // Primeira opção
    public static void main1(String[] args) {
        Scanner sc = new Scanner(System.in);

        String parenteses = sc.nextLine();
        sc.close();

        String status = "S";
        int aberto = 0, fechado = 0;
        for (int i = 0; i < parenteses.length(); i++) {
            char parentese = parenteses.charAt(i);
            
            if (parentese == '(')
                aberto++;
            else {
                if (aberto <= fechado) {
                    status = "N";
                    break;
                }
                fechado++;
            }
        }
        if (aberto != fechado && status.equals("S"))
            status = "N";
        
        System.out.println(status);
    }

    // Segunda opção
    public static void main2(String[] args) {
        Scanner sc = new Scanner(System.in); 
        String parenteses = sc.nextLine();
        sc.close();
        String[] caracteres = parenteses.split(""); // Feito aqui para não alterar a string original
        
        String status = "S";
        int aberto = 0, fechado = 0;
        for (String parentese : caracteres) {
            if (parentese.equals("("))
                aberto++;
            else {
                if (aberto <= fechado){
                    status = "N";
                    break;
                }
                fechado++;
            }
        }
        if (aberto != fechado && status.equals("S"))
            status = "N";
        
        System.out.println(status);
    }

}
