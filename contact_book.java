import java.util.Scanner;
import java.util.HashMap;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

class ContactBook {

    public static void main(String[] args) {
        boolean isRunning = true;
        Scanner sc = new Scanner(System.in);
        HashMap<String, String> contact = new HashMap<>();

        while (isRunning) {
            System.out.println();
            System.out.println("1. Add Contact");
            System.out.println("2. Search Contact");
            System.out.println("3. Delete Contact");
            System.out.println("4. Modify Contact");        
            System.out.println("5. Display Contacts");        
            System.out.println("6. Exit");
            System.out.print("Enter Your Choice: ");
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter Name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter Number: ");
                    String no = sc.nextLine();
                    contact.put(name, no);
                    System.out.println(name + " " + no);
                    System.out.println("Data added Successfully");
                    saveContactsToCSV(contact);
                    break;

                case 2:
                    System.out.print("Enter name to Search: ");
                    String nameSearch = sc.nextLine();
                    String searchResult = contact.get(nameSearch);
                    if (searchResult != null) {
                        System.out.println("Contact number found for " + nameSearch + " is " + searchResult);
                    } else {
                        System.out.println("Contact not found.");
                    }
                    break;

