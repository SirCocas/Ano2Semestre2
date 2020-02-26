package Aula1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Ex7 {
    public static expression_tree tree = new expression_tree();

    public static void main(String[] args) throws FileNotFoundException {
        createPrefix(new Scanner(new File("math.txt")));
        print(tree);
        System.out.println(tree.eval());
    }

    private static void createPrefix(Scanner in) {
        while (in.hasNext()) {
            if (in.hasNextDouble()) {
                tree.putNumber(in.nextDouble());
            } else {
                tree.putSignal(in.next());
            }
        }
        in.close();
    }

    private static void print(expression_tree tree) {
        System.out.println(tree.print());
    }
}
