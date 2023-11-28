package Practical_13;

public class InterpreterCheck {

    public static void main(String[] args) {

        String equation = "4.3 25 + 1.7 2 * - 3.2 /";

        Interpreter t = new Interpreter();
        System.out.println(t.evaluate(equation));

    }

}
