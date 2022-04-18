package com.bridgelabz;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class AddressBookMain {


    public static void main(String[] args) throws InputMismatchException, IOException {
        Scanner scanner = new Scanner(System.in);
        MultipleAddressBookSystem multipleAddressBookSystem = new MultipleAddressBookSystem();
        boolean moreChanges = true;
        while (moreChanges) {
            System.out.println("Choose a number to perform a specific action: ");
            System.out.println("1. To Add Contacts\n 2. To Print Contact List\n 3. To Edit Contact\n 4. To Delete Contact\n 5. To Add AddressBook\n 6. To Search By City\n 7. To Count Contacts By City\n 8. To Sort AddressBook\n 9. To Write AddressBook To txt Fil\n 10. To Read From Txt File\n 11. To Exit AddressBook\n");
            int action = scanner.nextInt();

            switch (action) {
                case 1 -> multipleAddressBookSystem.addingContacts();
                case 2 -> multipleAddressBookSystem.printingContacts();
                case 3 -> multipleAddressBookSystem.editingContacts();
                case 4 -> multipleAddressBookSystem.deletingContacts();
                case 5 -> multipleAddressBookSystem.addAddressBook();
                case 6 -> multipleAddressBookSystem.searchByCity();
                case 7 -> multipleAddressBookSystem.countByCity();
                case 8 -> multipleAddressBookSystem.sortAddressBook();
                case 9 -> multipleAddressBookSystem.writingContacts();
                case 10 -> multipleAddressBookSystem.readingContacts();
                case 11 -> moreChanges = false;
            }
        }
    }

}
