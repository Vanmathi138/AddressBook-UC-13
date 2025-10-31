package org.eg.UseCase15;


import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AddressBookGSON {
    private static final String FILE_NAME = "addressBook.json";
    private List<Person> personList = new ArrayList<>();
    private Gson gson = new Gson();

    public void writeContactsToJSON(){
        try(FileWriter fw = new FileWriter(FILE_NAME)){
            gson.toJson(personList, fw);
            System.out.println("Contact successfully written to "+FILE_NAME);
        }catch (IOException e){
            e.printStackTrace();
        }
    }
    public void readContactsFromJSON() {
        personList.clear();
        try (FileReader reader = new FileReader(FILE_NAME)) {
            Type listType = new TypeToken<ArrayList<Person>>() {}.getType();
            personList = gson.fromJson(reader, listType);

            System.out.println("\nContacts read from JSON file:");
            for (Person p : personList) {
                System.out.println(p);
            }
        } catch (FileNotFoundException e) {
            System.out.println(" File not found! Please write contacts first.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void addContacts(String n1, String n2, String e, String num)
    {
        personList.add(new Person(n1,n2, e,num));
    }
    public static void main(String[] args) {
        AddressBookGSON ab = new AddressBookGSON();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n--- Address Book Menu ---");
            System.out.println("1. Add Contact");
            System.out.println("2. Write Contacts to JSON File");
            System.out.println("3. Read Contacts from JSON File");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    System.out.println("Enter first name: ");
                    String n1 = sc.nextLine();
                    System.out.println("Enter last name: ");
                    String n2 = sc.nextLine();
                    System.out.println("Enter email: ");
                    String e = sc.nextLine();
                    System.out.println("Enter phone number: ");
                    String num = sc.nextLine();

                    ab.addContacts(n1, n2, e, num);
                    break;

                case 2:
                    ab.writeContactsToJSON();
                    break;

                case 3:
                    ab.readContactsFromJSON();
                    break;

                case 4:
                    System.out.println("Exiting....");
                    sc.close();
                    return;
                default:
                    System.out.println("Invalid input");
            }
        }
    }
}