package Aula1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;

public class Ex6 {
    static HashMap<String, String> connections = new HashMap<>();

    public static void main(String[] args) {
        readConnections("dic1.txt");
        String text = readText("texto1.txt");
        System.out.println(translateText(text));
    }

    private static String translateText(String text) {
        String[] s = text.split(" ");  //so as to not lose the original text
        Object[] keys = connections.keySet().toArray();
        for (int i = 0; i < keys.length; i++) {
            String gotten = connections.get(keys[i]);
            for (int j = 0; j < s.length; j++) {
                if (s[j].equals(keys[i])) {
                    s[j] = gotten;
                }
            }
        }
        String t = "";
        for (int i = 0; i < s.length; i++) {
            t += s[i] + " ";

        }
        return t;
    }

    private static String readText(String fileName) {
        String s = "";
        File inData = new File(fileName);
        try {
            Scanner reader = new Scanner(inData);
            while (reader.hasNextLine()) {
                s += reader.nextLine() + "\n";
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found!");
        }
        return s;
    }

    private static void readConnections(String fileName) {
        File data = new File(fileName);
        try {
            Scanner reader = new Scanner(data);
            while (reader.hasNextLine()) {
                String[] line = reader.nextLine().split(" ");
                connections.put(line[0], line[1]);
            }
            reader.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found!");
        }
    }
}
