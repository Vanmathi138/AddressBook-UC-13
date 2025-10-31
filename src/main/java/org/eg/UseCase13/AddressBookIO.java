package org.eg.UseCase13;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AddressBookIO {
    private static final String FILE_NAME = "AddressBook.txt";
    private List<Person> personList = new ArrayList<>();

    public void writeFile(){
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(FILE_NAME))){
            for(Person p: personList){
                bw.append(p.toString());
                bw.newLine();
                System.out.println("Success");
            }
        }catch (Exception e){
            e.getStackTrace();
        }
    }

    public void readFile(){
        try (BufferedReader br = new BufferedReader(new FileReader(FILE_NAME))){
            String line;
            while ((line = br.readLine())!=null){
                System.out.println( line);
            }
        }catch (Exception e){
            System.out.println(e);
        }
    }
    public void addContacts(String n1, String n2, String e, String num) {
        personList.add(new Person(n1,n2, e,num));
    }

    public static void main(String[] args) {
        AddressBookIO a = new AddressBookIO();
        Scanner sc = new Scanner(System.in);

        while (true){
            System.out.println("\n--- Address Book Menu ---");
            System.out.println("1. Add Contact");
            System.out.println("2. Write Contacts to File");
            System.out.println("3. Read Contacts from File");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice){
                case 1:
                    System.out.println("Enter first name: ");
                    String n1 = sc.nextLine();
                    System.out.println("Enter last name: ");
                    String n2 = sc.nextLine();
                    System.out.println("Enter email: ");
                    String e = sc.nextLine();
                    System.out.println("Enter phone number: ");
                    String num = sc.nextLine();

                    a.addContacts(n1, n2, e, num);
                    break;

                case 2:
                    a.writeFile();
                    break;

                case 3:
                    a.readFile();
                    break;

                case 4:
                    System.out.println("Exiting....");
                    sc.close();
                    return;
            }
        }

    }

}
