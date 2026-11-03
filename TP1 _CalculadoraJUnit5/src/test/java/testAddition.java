import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class ScientificCalculatorTest {

    private ScientificCalculator calculadora;

    @BeforeEach
    void prepararCalculadora() {
        // Setup: cria uma calculadora antes de cada teste.
        calculadora = new ScientificCalculator();
    }

    // Operações básicas: soma e subtração

    @Test
    void testAddition() {
        assertEquals(5.0, calculadora.add(2.0, 3.0));
    }

    @Test
    void testSubtraction() {
        // Execution: calcula 8 menos 3.
        double resultado = calculadora.subtract(8.0, 3.0);

        // Assertion: verifica se o resultado é 5.
        assertEquals(5.0, resultado);

        // Teardown: não é necessário, pois não há recursos para fechar.
    }

    // Funções matemáticas com entradas válidas: raiz e logaritmo

    @Test
    void testSquareRootPositive() {
        double resultado = calculadora.squareRoot(25.0);
        assertEquals(5.0, resultado);
    }

    @Test
    void testLogPositive() {
        assertEquals(0.0, calculadora.log(1.0), 0.000001);
        assertEquals(0.693147, calculadora.log(2.0), 0.000001);
        assertEquals(2.302585, calculadora.log(10.0), 0.000001);
    }

    // Funções trigonométricas

    @Test
    void calculaSenoEmGraus() {
        assertEquals(0.5, calculadora.sin(30.0), 0.000001);
        assertEquals(0.866025, calculadora.sin(60.0), 0.000001);
        assertEquals(1.0, calculadora.sin(90.0), 0.000001);
    }

    // Entradas inválidas que devem gerar exceção

    @Test
    void testSquareRootNegative() {
        assertThrows(IllegalArgumentException.class,
                () -> calculadora.squareRoot(-9.0));
    }

    @Test
    void divisaoPorZeroLancaExcecao() {
        assertThrows(IllegalArgumentException.class,
                () -> calculadora.divide(10.0, 0.0));
    }
}