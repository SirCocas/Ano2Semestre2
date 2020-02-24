package Aula1;

import java.io.File;
import java.util.Scanner;
import java.util.Stack;

public class Ex2 {
    public static void main(String[] args) {
        File asd = new File("asd.txt");
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();
        while (line.isEmpty())
            line += sc.nextLine();
        String[] input = line.split(" ");
        Stack data = new Stack<String>();
        boolean isNumber = isNumber(input[0]);
        int i = 0;
        while (i < input.length) {
            while (isNumber(input[i])) {
                data.push(input[i]);
                i++;
            }
            double result = calculate(data.pop().toString(), data.pop().toString(), input[i]);
            data.push(result);
            i++;
        }
        data.forEach(e -> {
            System.out.println(e.toString());
        });
    }

    private static double calculate(String popped, String otherPopped, String operand) {
        double pop1 = Double.parseDouble(popped);
        double pop2 = Double.parseDouble(otherPopped);
        char op = operand.toCharArray()[0];
        switch (op) {
            case '+':
                return pop1 + pop2;
            case '-':
                return pop1 - pop2;
            case '/':
                return pop1 / pop2;
            case '*':
                return pop1 * pop2;
        }
        return 0;
    }

    public static boolean isNumber(String input) {
        char data = input.toCharArray()[0];
        return (!(data == '*' || data == '-' || data == '+' || data == '/'));
    }
}

