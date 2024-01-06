package Practical_13;

public class Interpreter {
    private Double[] stack;
    private int stackPointer;
    private String delim = " "; // Space

    Interpreter(){}

    /**
     * @param delim user specified deliminator for strings e.g. "/"
     */
    Interpreter(String delim){
        this.delim = delim;
    }

    /**
     * Evaluate string, read using postfix notation
     * @param input string equation
     * @return double answer to equation
     */
    public Double evaluate(String input){

        String[] tokens = input.split(delim);

        stack = new Double[tokens.length]; // Can't need more stack space than given tokens?
        stackPointer = 0;

        for (String s : tokens){
            try{
                push(Double.parseDouble(s)); // try to push as an operand

                System.out.println("Rule 2: Operand := Double");
            }
            catch(Exception e){ // Not a double -> operators

                System.out.println("Rule 1: Operator := +, -, *, /");

                switch (s) { // Valid operators: +, -, *, /
                    case ("+"):
                        push(pop() + pop());
                        System.out.println("Rule 3: Operand := Operand Operand Operator");
                        break;

                    case ("-"):
                        Double a = pop();
                        Double b = pop();

                        push(b - a);
                        System.out.println("Rule 3: Operand := Operand Operand Operator");
                        break;

                    case ("*"):
                        push(pop() * pop());
                        System.out.println("Rule 3: Operand := Operand Operand Operator");
                        break;

                    case ("/"):

                        Double c = pop();
                        Double d = pop();

                        push(d/c);
                        System.out.println("Rule 3: Operand := Operand Operand Operator");
                        break;

                    default:
                        throw new RuntimeException("Invalid Operator \n Expected: '+', '-', '*', '/'");
                }
            }
        }

        return stack[0];
    }

    /**
     * Push operand onto top of stack
     * @param d operand to push
     */
    private void push(Double d){
        // Prevent overflow
        if(stackPointer >= stack.length){
            throw new RuntimeException("Too many elements in stack");
        }

        stack[stackPointer] = d;
        stackPointer++;
    }

    /**
     * Pop top value
     * @return double from top of stack
     */
    private Double pop(){
        stackPointer --;
        return stack[stackPointer];
    }

}
