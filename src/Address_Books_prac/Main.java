package Address_Books_prac;

import java.util.Scanner;

import static Address_Books_prac.AddressBook.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;
        do {
            System.out.println("Address Book Options:");
            System.out.println("1. Add new contact");
            System.out.println("2. Find a contact by name");
            System.out.println("3. Display all contacts");
            System.out.println("4. Exit");

            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    addContact(scanner);
                    break;
                case 2:
                    findContact(scanner);
                    break;
                case 3:
                    displayContacts();
                    break;
                case 4:
                    System.out.println("Exiting Address Book.");
                    break;
                default:
                    System.out.println("Invalid choice. Try again.");
                    break;
            }
        } while (choice != 4);

        scanner.close();
    }
}