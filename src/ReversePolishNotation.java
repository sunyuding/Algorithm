import java.util.Stack;

//Evaluate Reverse Polish Notation
//        Description
//        Evaluate the value of an arithmetic expression in Reverse Polish Notation.
//
//        Assumption
//
//        Valid operators are +, -, *, /.
//        Each operand may be an integer or another expression.
//        Examples
//
//        ["2", "1", "+", "3", "*"] -> ((2 + 1) * 3) -> 9
//        ["4", "13", "5", "/", "+"] -> (4 + (13 / 5)) -> 6
public class ReversePolishNotation {
    public int evalRPN(String[] tokens) {
        // Write your solution here
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < tokens.length; i++) {
            if (tokens[i] == "+") {
                int b = stack.pop();
                int a = stack.pop();
                stack.push(a + b);
            } else if (tokens[i] == "-") {
                int b = stack.pop();
                int a = stack.pop();
                stack.push(a - b);
            } else if (tokens[i] == "*") {
                int b = stack.pop();
                int a = stack.pop();
                stack.push(a * b);
            } else if (tokens[i] == "/") {
                int b = stack.pop();
                int a = stack.pop();
                stack.push(a / b);
            } else {
                int a = Integer.parseInt(tokens[i]);
                stack.push(a);
            }

        }
        return stack.pop();
    }

    public static void main(String[] args) {
        ReversePolishNotation RPN = new ReversePolishNotation();
        String[] tokens = new String[]{"4", "13", "5", "/", "+"};
        int result = RPN.evalRPN(tokens);
        System.out.println(result);
    }
}
