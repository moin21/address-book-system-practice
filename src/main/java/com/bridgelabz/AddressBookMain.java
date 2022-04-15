package com.bridgelabz;

import java.util.Scanner;

public class AddressBookMain {


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        AddressBookSystem addressBookSystem = new AddressBookSystem();
        boolean moreChanges = true;
        while (moreChanges) {
            System.out.println("Choose a number to perform a specific action: ");
            System.out.println("1. To add contact\n 2. To Print Contact List\n 3. To Edit Contact\n 4. To Delete Contact\n 5. To Exit AddressBook\n");
            int action = scanner.nextInt();

            switch (action) {
                case 1 -> addressBookSystem.addContact();
                case 2 -> System.out.println(addressBookSystem.contactArrayList);
                case 3 -> addressBookSystem.editContact();
                case 4 -> addressBookSystem.deleteContact();
                case 5 -> moreChanges = false;
            }
        }
    }
}
