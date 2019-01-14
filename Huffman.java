package Hausaufgabe13;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Huffman {
    public static void main(String [] args){
        System.out.println(decode(new File("src/Hausaufgabe13/message.txt")));
    }

    public static String decode(File f){
        StringBuilder input;
        StringBuilder output = new StringBuilder("");
        String [] coding = new String[28];
        Scanner sc = null;

        try{
            sc = new Scanner(f);
        } catch (FileNotFoundException e){
            System.out.println("Datei "+f+" nicht vorhanden");
        }


        if (!sc.hasNextLine()){
            throw new IllegalArgumentException("kein passendes Dateiformat");
        }

        input = new StringBuilder(sc.nextLine());
        for (int i = 0; sc.hasNextLine(); i++){
            coding[i] = sc.nextLine();
        }
        sc.close();

        while (!input.toString().equals("")){
            for (int i = 0; i < coding.length; i++){
                if (input.indexOf(coding[i]) == 0 && !coding[i].equals("")){
                    if (i == coding.length-2){
                        output.append(" ");
                    } else {
                        output.append((char)(i+65));
                    }
                    input.replace(0, coding[i].length(), "");
                    break;
                }
            }
        }
        return output.toString();
    }
}
