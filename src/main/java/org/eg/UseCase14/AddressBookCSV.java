package org.eg.UseCase14;

import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;

import java.io.FileReader;
import java.io.FileWriter;
import java.util.*;

public class AddressBookCSV {
        private static final String FILE_NAME = "CsvFile.csv";
        private List<Person> personList = new ArrayList<>();

        public void writeContactsToCSV(){
            try(CSVWriter  csvWriter = new CSVWriter(new FileWriter(FILE_NAME))) {
                String[] header = {"First Name ","Last Name ", "Email", "Phone number"};
                csvWriter.writeNext(header);

                for(Person p: personList){
                    csvWriter.writeNext(p.toCSV());
                }
            }catch (Exception e){
                System.out.println(e);
            }
        }
        public void readCSVFile(){
            personList.clear();
              try (CSVReader reader = new CSVReader(new FileReader(FILE_NAME))){
                  String line[];
                  reader.readNext();
                  while ((line = reader.readNext())!=null){
                      Person p = new Person(line[0],line[1], line[2], line[3]);
                      personList.add(p);
                  }
                  System.out.println("\n📖 Contacts read from file:");
                  for (Person p : personList) {
                      System.out.println(p);
                  }
              }catch (Exception e){
                  System.out.println(e);
              }

        }
        public void addContacts(String n1, String n2, String e, String num) {
        personList.add(new Person(n1,n2, e,num));
    }

    public static void main(String[] args) {
            AddressBookCSV csv = new AddressBookCSV();
            Scanner sc = new Scanner(System.in);
            while (true){
                System.out.println("\n--- Address Book Menu ---");
                System.out.println("1. Add Contact");
                System.out.println("2. Write Contacts to CSV File");
                System.out.println("3. Read Contacts from CSV File");
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

                        csv.addContacts(n1, n2, e, num);
                        break;
                    case 2:
                        csv.writeContactsToCSV();
                        break;
                    case 3:
                        csv.readCSVFile();
                        break;
                    case 4:
                        System.out.println("Exiting...");
                        sc.close();
                        return;
                }
            }
    }
}
