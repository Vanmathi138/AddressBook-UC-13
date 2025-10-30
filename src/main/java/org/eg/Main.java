package org.eg;

import java.io.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        File f = new File("FileIO.txt");
        try(BufferedReader br = new BufferedReader(new FileReader(f))){
            String line;
            while ((line = br.readLine()) != null){
                System.out.println(line);

            }
        }catch (Exception e){
            System.out.println(e);
        }

        try(BufferedWriter bw = new BufferedWriter(new FileWriter("Write.txt"))){
            bw.write("Hi");
            bw.newLine();
            bw.write("Hello");
            System.out.println("Success");
        }catch (Exception e){
            System.out.println(e);
        }
    }
}