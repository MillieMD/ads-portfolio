package Practical_13;

import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class InterpreterTest {

    public void interpreterTest(double a, double b){

        Interpreter i = new Interpreter();

        // Test addition
        Double testAdd = i.evaluate(a + " " + b + " +");
        assertEquals(testAdd, a + b, "Result of 'a b +' not equal to a + b");

        // Test subtraction
        Double testSub = i.evaluate(a + " " + b + " -");
        assertEquals(testSub, a - b, "Result of 'a b -' not equal to a - b");

        // Test multiplication
        Double testMult = i.evaluate(a + " " + b + " *");
        assertEquals(testMult, a * b, "Result of 'a b *' not equal to a * b");

        // Test division
        Double testDiv = i.evaluate(a + " " + b + " /");
        assertEquals(testDiv, a / b, "Result of 'a b /' not equal to a / b");
    }

    @Test
    public void singledigitsdecimal(){
        double a = Math.random() * 10; // Random 1 digit decimal number
        double b = Math.random() * 10;

        interpreterTest(a, b);
    }

    @Test
    public void singledigitsdecimalnegative(){
        double a = Math.random() * -10; // Random 1 digit decimal number
        double b = Math.random() * -10;

        interpreterTest(a, b);
    }

    @Test
    public void singledigitswhole(){
        double a = new Random().nextInt(0,10); // Random 1 digit whole number
        double b = new Random().nextInt(0,10);

        interpreterTest(a, b);
    }

    @Test
    public void singledigitswholenegative(){
        double a = new Random().nextInt(-10,0); // Random 1 digit whole number
        double b = new Random().nextInt(-10,0);

        interpreterTest(a, b);
    }

    @Test
    public void doubledigitsdecimal(){
        double a = Math.random() * 100; // Random 12 digit decimal number
        double b = Math.random() * 100;

        interpreterTest(a, b);
    }

    @Test
    public void doubledigitsdecimalnegative(){
        double a = Math.random() * -100; // Random 12 digit decimal number
        double b = Math.random() * -100;

        interpreterTest(a, b);
    }

    @Test
    public void doubledigitswhole(){
        double a = new Random().nextInt(0,100); // Random 2 digit whole number
        double b = new Random().nextInt(0,100);

        interpreterTest(a, b);
    }

    @Test
    public void doubledigitswholenegative(){
        double a = new Random().nextInt(-100,0); // Random 2 digit whole number
        double b = new Random().nextInt(-100,0);

        interpreterTest(a, b);
    }

    @Test
    public void tripledigitsdecimal(){
        double a = Math.random() * 1000; // Random 12 digit decimal number
        double b = Math.random() * 1000;

        interpreterTest(a, b);
    }

    @Test
    public void tripledigitsdecimalnegative(){
        double a = Math.random() * -1000; // Random 12 digit decimal number
        double b = Math.random() * -1000;

        interpreterTest(a, b);
    }

    @Test
    public void tripledigitswhole(){
        double a = new Random().nextInt(0,1000); // Random 2 digit whole number
        double b = new Random().nextInt(0,1000);

        interpreterTest(a, b);
    }

    @Test
    public void tripledigitswholenegative(){
        double a = new Random().nextInt(-1000,0); // Random 2 digit whole number
        double b = new Random().nextInt(-1000,0);

        interpreterTest(a, b);
    }

}
