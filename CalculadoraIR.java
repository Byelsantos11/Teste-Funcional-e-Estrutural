public class CalculadoraIR {
    public static double calcular(double renda) {
        if (renda < 0) {
            throw new IllegalArgumentException("Renda invalida");
        }
        double desconto;
        if (renda <= 5000.00)      desconto = 1.00;
        else if (renda <= 5500.00) desconto = 0.75;
        else if (renda <= 6000.00) desconto = 0.50;
        else if (renda <= 6500.00) desconto = 0.25;
        else if (renda <= 7350.00) desconto = 0.10;
        else                       desconto = 0.00;
        return renda * 0.275 * (1 - desconto);
    }
}
