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

                case 3:
                    System.out.print("Enter Contact name to delete: ");
                    String nameDel = sc.nextLine();
                    contact.remove(nameDel);
                    System.out.println("Contact deleted Successfully");
                    saveContactsToCSV(contact);
                    break;

                case 4:
                    System.out.print("Enter contact name to modify: ");
                    String nameMod = sc.nextLine();
                    System.out.print("Enter new Contact Number: ");
                    String contactMod = sc.nextLine();
                    contact.put(nameMod, contactMod);
                    System.out.println("Contact Number Modified Successfully...");
                    saveContactsToCSV(contact);
                    break;

                case 5:
                    System.out.println("Displaying all contacts:");
                    for (String key : contact.keySet()) {
                        System.out.println("Name: " + key + " Number: " + contact.get(key));
                    }
                    break;

                case 6:
                    System.out.println("Thank You For Visiting Our Contact Book Management System");
                    sc.close();
                    isRunning = false;
                    break;

                default:
                    System.out.println("Invalid Choice");
            }
        }
    }

    public static void saveContactsToCSV(HashMap<String, String> contacts) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("contacts.csv"))) {
            bw.write("Name,Number");
            bw.newLine();
            for (String name : contacts.keySet()) {
                bw.write(name + "," + contacts.get(name));
                bw.newLine();
            }
            System.out.println("Contacts saved to CSV file successfully.");
        } catch (IOException e) {
            System.out.println("An error occurred while saving to CSV file.");
            e.printStackTrace();
        }
    }
}
