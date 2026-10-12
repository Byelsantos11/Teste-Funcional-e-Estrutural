import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import static org.junit.jupiter.api.Assertions.*;

class CalculadoraIRTest {

    @ParameterizedTest(name = "renda {0} -> IR {1}")
    @CsvSource({
        "0.00,0.00",        "4000.00,0.00",     "5000.00,0.00",     // CE2
        "5000.01,343.75",   "5200.00,357.50",   "5500.00,378.13",   // CE3
        "5500.01,756.25",   "5800.00,797.50",   "6000.00,825.00",   // CE4
        "6000.01,1237.50",  "6200.00,1278.75",  "6500.00,1340.63",  // CE5
        "6500.01,1608.75",  "7000.00,1732.50",  "7350.00,1819.13",  // CE6
        "7350.01,2021.25",  "8000.00,2200.00"                       // CE7
    })
    void deveCalcularIRPorFaixa(double renda, double esperado) {
        assertEquals(esperado, CalculadoraIR.calcular(renda), 0.01);
    }

    @ParameterizedTest(name = "renda invalida {0}")
    @ValueSource(doubles = { -100.00, -0.01 })                      // CE1
    void deveLancarExcecaoParaRendaNegativa(double renda) {
        assertThrows(IllegalArgumentException.class,
                     () -> CalculadoraIR.calcular(renda));
    }
}
