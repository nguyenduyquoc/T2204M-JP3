package Address_Books_prac;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class AddressBook {
    public static HashMap<String, Contact> contacts = new HashMap<String, Contact>();

    public static void addContact(Scanner scanner) {
        System.out.print("Enter contact name: ");
        String name = scanner.next();

        System.out.print("Enter contact phone number: ");
        String phone = scanner.next();

        Contact contact = new Contact(name, phone);
        contacts.put(name, contact);

        System.out.println("Contact added: " + contact);
    }

    public static void findContact(Scanner scanner) {
        System.out.print("Enter contact name: ");
        String name = scanner.next();

        if (contacts.containsKey(name)) {
            Contact contact = contacts.get(name);
            System.out.println("Contact found: " + contact);
        } else {
            System.out.println("Contact not found.");
        }
    }

    public static void displayContacts() {
        System.out.println("Contacts:");

        for (Map.Entry<String, Contact> contact : contacts.entrySet()) {
            System.out.println(contact.getValue());
        }
    }
}
