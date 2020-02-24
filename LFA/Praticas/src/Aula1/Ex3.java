package Aula1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Ex3 {
    public static Object[] main(String[] args) {
        File inputFile = new File("numbers.txt");
        try {
            Set<Integer> possibleNumbers = new TreeSet<>();
            Scanner fileReader = new Scanner(inputFile);
            HashMap<Integer, String> links = new HashMap<>();
            while (fileReader.hasNextLine()) {
                String line = fileReader.nextLine();
                String[] lineContent = line.split(" - ");
                int number = Integer.parseInt(lineContent[0]);
                if (possibleNumbers.add(number))
                    links.put(number, lineContent[1]);
            }
            String input = readFromTerminal();
            Object[] listOfNumbers = interpret(input, links);
            System.out.println(Arrays.toString(listOfNumbers));
            return listOfNumbers;
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        }
        return null;
    }

    private static Object[] interpret(String input, HashMap<Integer, String> links) {
        LinkedList<Integer> numbers = new LinkedList<>();
        String[] data = input.split(" ");
        for (int i = 0; i < data.length; i++) {
            if (links.containsValue(data[i])) {
                var keys = links.keySet();
                int finalI = i;
                keys.forEach(e -> {
                    if (links.get(e).equals(data[finalI])) {
                        numbers.add(e);
                    }
                });
            }
        }
        return numbers.toArray();
    }


    private static String readFromTerminal() {
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();
        while (line.isEmpty())
            line += sc.nextLine();
        line.replace("-", " ");
        line.replace(" and ", " ");
        return line;
    }
}
