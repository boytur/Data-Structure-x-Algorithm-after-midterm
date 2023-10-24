package Sec1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {

    @Test
    void add() {
        Calculator Myoop = new Calculator();
       assertEquals(10,Myoop.add(5, 5));
       assertEquals(15,Myoop.add(12, 3));
        assertEquals(15,Myoop.add(14, 1));
        assertEquals(15,Myoop.add(15, 0));
        assertEquals(15,Myoop.add(0, 15));
    }

    @Test
    void multiply() {
        assertEquals(10,Calculator.multiply(5,2));
        assertEquals(20,Calculator.multiply(10,2));
        assertEquals(30,Calculator.multiply(10,3));
        assertEquals(20,Calculator.multiply(2,10));
        assertEquals(100,Calculator.multiply(10,10));
    }
    @Test
    void minus() {
        assertEquals(50,Calculator.minus(100,50));
        assertEquals(20,Calculator.minus(50,30));
        assertEquals(1000,Calculator.minus(1500,500));
        assertEquals(100,Calculator.minus(150,50));
    }

    @Test
    void divide() {
        assertAll(
                () ->assertEquals(15,Calculator.divide(30,2)),
                () ->assertEquals(5,Calculator.divide(10,2)),
                () ->assertEquals(90,Calculator.divide(180,2))

        );
    }
}