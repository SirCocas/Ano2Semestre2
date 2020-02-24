package Aula1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;

public class Ex6Pt2 {
    public static HashMap<String, String> definitions = new HashMap<>();

    public static void main(String[] args) {
        String data = null;
        try {
            data = readFile("texto1.txt");
        } catch (FileNotFoundException e) {
            System.out.println("File not found!");
        }
        makeAssociations("definitions.txt");
        System.out.println(redefined(data));
    }

    private static String redefined(String data) {
        String allData = data;  //creating a new variable to preserve the original data
        boolean mightBeUndefined = true;
        while (mightBeUndefined) {
            mightBeUndefined = false;
            String[] allWords = allData.split("\\W");
            var keys = definitions.keySet().toArray();
            for (int i = 0; i < keys.length; i++) {
                for (int j = 0; j < allWords.length; j++) {
                    if (allWords[j].equals(keys[i])) {
                        mightBeUndefined = true;
                        allWords[j] = definitions.get(keys[i]);
                    }
                }
                String temp = "";
                for (int j = 0; j < allWords.length; j++) {
                    temp += allWords[j] + " ";
                }
                allData = temp;
            }
        }
        String temp = "";
        String[] finalWords = allData.split("\\W");
        for (int i = 0; i < finalWords.length; i++) {
            if (!finalWords[i].isEmpty()) {
                temp += finalWords[i] + " ";
            }
        }
        return temp;
    }

    private static void makeAssociations(String fileName) {
        File dataIn = new File(fileName);
        try {
            Scanner reader = new Scanner(dataIn);
            while (reader.hasNextLine()) {
                String line = reader.nextLine();
                String[] words = line.split("\\W");
                String word = words[0];
                String meaning = "";
                for (int i = 1; i < words.length; i++) {
                    words[i].replaceAll(" ", "");
                    meaning += words[i] + " ";
                }
                definitions.put(word, meaning);
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found!");
        }
    }

    private static String readFile(String fileName) throws FileNotFoundException {
        File dataIn = new File(fileName);
        Scanner reader = new Scanner(dataIn);
        String data = "";
        while (reader.hasNextLine()) {
            data += reader.nextLine() + "\n";
        }
        return data;
    }
}
