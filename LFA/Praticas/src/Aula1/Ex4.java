package Aula1;

import java.util.Stack;

public class Ex4 {
    public static void main(String[] args) {
        Object[] values = Ex3.main(null);
        Stack<Integer> numbers = new Stack<>();
        numbers.push((Integer) values[0]);
        for (int i = 1; i < values.length; i++) {
            int popped = numbers.pop();
            if (popped < (Integer) values[i]) {
                int number = popped * (Integer) values[i];
                numbers.push(number);
            } else {
                numbers.push(popped);
                numbers.push((Integer) values[i]);
            }
        }
        int sum = numbers.stream().mapToInt(e -> e).sum();
        System.out.println(sum);
    }
}
