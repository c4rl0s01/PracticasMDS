package org.example.unittests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.logging.Logger;

import static org.mockito.Mockito.*;

/**
 * Los nuevos alumnos andan aprendiendo a programar en Introduccion a la programacion y han creado
 * una calculadora que dicen que no tiene fallos.
 * Debemos comprobar el correcto funcionamiento de la "calculadora segura" que nos han proporcionado.
 * En caso de detectar comportamiento erroneo mediante algun test, arreglalo y comprueba que el test funciona correctamente.
 * En concreto, es necesario verificar la siguiente funcionalidad:
 * - En caso de intento de división entre 0, debe tirar ArithmeticException.
 * - Debe protegerse contra Overflows de forma correcta: por ejemplo la multiplicacion de dos numeros positivos
 * nunca puede dar un numero negativo. En caso de que sea posible overflow, tirar ArithmeticException.
 * - Debe generar numeros aleatorios de forma correcta, respetando el limite pedido
 * - Debe detectar correctamente cuando un numero es par y cuando un numero es impar
 * - Debe emitir mensajes de log si ha sido configurada para ello. (Opcional para nota)
 */
public class SecureCalculatorTests {

    /**
     * Verify calculator is successfully created
     */
    @Test
    public void smokeTest(){
        SecureCalculator calculator = new SecureCalculator();
        Assertions.assertNotNull(calculator);
    }

    @Test
    public void zero_division_test(){
        SecureCalculator calculator = new SecureCalculator();
        Assertions.assertThrows(ArithmeticException.class,
                () -> calculator.divide(1, 0));
    }

    @Test
    public void overflow_test(){
        SecureCalculator calculator = new SecureCalculator();
        Assertions.assertDoesNotThrow(() -> {calculator.multiply(Integer.MAX_VALUE-1, Integer.MAX_VALUE);});
    }

    @Test
    public void random_test(){
        SecureCalculator calculator = new SecureCalculator();
        int bound = 9876;
        int result = calculator.getRandomNumber(bound);
        int result2 = calculator.getRandomNumber(bound);
        Assertions.assertTrue(0 <= result && result < bound);
        Assertions.assertTrue(0 <= result2 && result2 < bound);
        Assertions.assertTrue(result != result2);

    }

    @Test
    public void mod_test(){
        SecureCalculator calculator = new SecureCalculator();
        int a = 3;
        int b = 2;
        int result1 = calculator.mod(a, b);
        Assertions.assertTrue(0 <= result1 && result1 <= b);
        int result2 = calculator.mod(-a, b);
        Assertions.assertTrue(0 <= result2 && result2 <= b);
        int result3 = calculator.mod(a, -b);
        Assertions.assertTrue(0 >= result3 && result3 >= -b);
        int result4 = calculator.mod(-a, -b);
        Assertions.assertTrue(0 >= result4 && result4 >= -b);
    }

    @Test
    public void odd_test(){
        SecureCalculator calculator = new SecureCalculator();
        Assertions.assertTrue(calculator.isOdd(3301));
        Assertions.assertFalse(calculator.isOdd(2456));
    }

    @Test
    public void even_test(){
        SecureCalculator calculator = new SecureCalculator();
        Assertions.assertTrue(calculator.isEven(2456));
        Assertions.assertFalse(calculator.isEven(3301));
    }

    @Test
    public void random_s_test(){
        SecureCalculator calculator = new SecureCalculator();
        int result = calculator.getRandomNumber();
    }

    @Test
    void check_logger(){
        var mockLog = Mockito.mock(Logger.class);
        var calculadora = new SecureCalculator(mockLog);
        calculadora.divide(4, 2);
        calculadora.multiply(4, 8);
        calculadora.mod(8,2);
        calculadora.getRandomNumber(1000);
        verify(mockLog, times(4)).info(anyString());
    }
}
