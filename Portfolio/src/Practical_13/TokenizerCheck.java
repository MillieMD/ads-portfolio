package Practical_13;

public class TokenizerCheck {

    public static void main(String[] args) {

        String equation = "4.3 25 + 1.7 2 * - 3.2 /";

        Tokenizer t = new Tokenizer();
        System.out.println(t.evaluate(equation));

    }

}
