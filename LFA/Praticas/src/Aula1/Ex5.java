package Aula1;

import java.util.HashMap;
import java.util.Scanner;

public class Ex5 {
    static HashMap<Character, Double> variables = new HashMap<>();

    public static void main(String[] args) {
        String operations[] = readData();
        double result = 0;
        for (int i = 0; i < operations.length; i++) {
            if (operations[i].contains("=")) {
                assignValue(variables, operations[i]);
            } else {
                //assuming lines like n + n don't change the variable n
                result = calculate(operations[i]);
            }
        }
        System.out.println(result);
    }

    private static void assignValue(HashMap<Character, Double> variables, String operation) {
        String[] data = operation.split(" = ");
        char variableItself = data[0].toCharArray()[0];
        String assignment = data[1];
        double result;
        if (assignment.contains("+") || assignment.contains("-") || assignment.contains("*") || assignment.contains("/"))
            result = calculate(assignment);
        else
            result = Double.parseDouble(data[1]);
        variables.put(variableItself, result);
    }

    private static double calculate(double firstNum, double secondNum, String operand) {
        switch (operand.toCharArray()[0]) {
            case '+':
                return firstNum + secondNum;
            case '*':
                return firstNum * secondNum;
            case '-':
                return firstNum - secondNum;
            case '/':
                return firstNum / secondNum;
        }
        return 0;
    }

    private static double calculate(String line) {
        String[] components = line.split(" ");
        double firstNum;
        double secondNum;
        if (variables.containsKey(components[0].toCharArray()[0])) {
            firstNum = variables.get(components[0].toCharArray()[0]);
        } else
            firstNum = Double.parseDouble(components[0]);
        if (variables.containsKey(components[2].toCharArray()[0]))
            secondNum = variables.get(components[2].toCharArray()[0]);
        else
            secondNum = Double.parseDouble(components[2]);
        return calculate(firstNum, secondNum, components[1]);
    }

    private static String[] readData() {
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();
        while (line.isEmpty())
            line += sc.nextLine() + "//";
        line += "//";
        while (!line.contains(";")) {
            line += sc.nextLine() + "//";
        }
        return line.replace(";", "").split("//");
    }
}
