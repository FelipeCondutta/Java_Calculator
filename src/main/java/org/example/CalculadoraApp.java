import java.util.Locale;
import java.util.Scanner;

public class CalculadoraApp
{
    public static void main( String[] args )
    {
        Scanner scanner = new Scanner(System.in);

        double valorUm;
        double valorDois;
        String operacao;
        boolean continuar;

        do {
            System.out.println("Digite o primeiro valor: ");
            valorUm = scanner.nextDouble();

            System.out.println("Digite a operação: (+, -, /, *)");
            operacao = scanner.next();

            System.out.println("Digite o segundo valor: ");
            valorDois = scanner.nextDouble();

            System.out.println("Resultado: " + realizarCalculo(valorUm, valorDois, operacao));

            continuar = verificarNovaOperacao();
        }while (continuar);

    }
    public static boolean verificarNovaOperacao() {
        Scanner sc = new Scanner(System.in);

        System.out.println("Deseja realizar outra operação? (S/N)");
        return !sc.nextLine().toUpperCase(Locale.ROOT).equals("N");
    }

    public static Double realizarCalculo(double valorUm, double valorDois, String operacao) {
        Double respostaCalculo = 0.0;

        switch (operacao){
            case "+":
                respostaCalculo = valorUm + valorDois;
                break;
            case "-":
                respostaCalculo = valorUm - valorDois;
                break;
            case "*":
                respostaCalculo = valorUm * valorDois;
                break;
            case "/":
                if (valorDois != 0) {
                    respostaCalculo = valorUm / valorDois;
                } else {
                    throw new IllegalArgumentException("Divisão por zero não é permitida.");
                }
                break;
            default:
                throw new IllegalArgumentException("Operação inválida. Use +, -, *, ou /.");
        };
        return respostaCalculo;
    }
}
