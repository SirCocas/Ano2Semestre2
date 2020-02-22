package Aula1;

import java.util.Scanner;

public class Ex2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();
        while (line.isEmpty())
            line += sc.nextLine();
        String [] input = line.split(" ");
        
    }
}

// TODO: 20/02/2020 não esquecer que tenho de fazer isto
