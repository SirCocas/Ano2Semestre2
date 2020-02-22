package Aula1;

import java.util.Scanner;

public class Ex1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();
        while (line.isEmpty())
            line += sc.nextLine();

        String[] values = line.split(" ");
        while (values.length < 3) {
            line += " " + sc.nextLine();
            values = line.split(" ");
        }
        double firstNum = Double.parseDouble(values[0]);
        double secondNum = Double.parseDouble(values[2]);
        double res = 0;
        switch (values[1].toCharArray()[0]) {
            case '+': {
                res = firstNum + secondNum;
                break;
            }
            case '*': {
                res = firstNum * secondNum;
                break;
            }
            case '-': {
                res = firstNum - secondNum;
                break;
            }
            case '/': {
                res = firstNum / secondNum;
                break;
            }
            default: {
                System.out.println("Wrong kind of operation!");
                System.exit(-1);
                break;
            }
        }
        System.out.println(line + " = " + res);
    }
}
