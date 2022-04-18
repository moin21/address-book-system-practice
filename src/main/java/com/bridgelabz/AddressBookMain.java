package com.bridgelabz;

import com.opencsv.exceptions.CsvDataTypeMismatchException;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Class containing main method for Address Book System
 *
 * @author - Moinuddin
 */
public class AddressBookMain {
    /**
     * Created Scanner object for user input.
     * Created object for {@link MultipleAddressBookSystem } class - multipleAddressBookSystem.
     * Initialized boolean with true value - moreChanges (To rerun the switch after every action)
     * Using switch case to allow user to choose from actions. action (int) takes value to call specific method in switch cases.
     */
    public static void main(String[] args) throws InputMismatchException, IOException, CsvRequiredFieldEmptyException, CsvDataTypeMismatchException {
        /**
         * Scanner object for user input.
         */
        Scanner scanner = new Scanner(System.in);
        /**
         * Object created for {@link MultipleAddressBookSystem } class - multipleAddressBookSystem.
         */
        MultipleAddressBookSystem multipleAddressBookSystem = new MultipleAddressBookSystem();
        boolean moreChanges = true;
        while (moreChanges) {
            System.out.println("Choose a number to perform a specific action: ");
            System.out.println("1. To Add Contacts\n 2. To Print Contact List\n 3. To Edit Contact\n 4. To Delete Contact\n 5. To Add AddressBook\n 6. To Search By City\n 7. To Count Contacts By City\n 8. To Sort AddressBook\n 9. To Write AddressBook To txt Fil\n 10. To Read From Txt File\n 11. To read CSV\n 12. Write AddressBook To CSV\n 13. To Exit AddressBook\n");
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
                case 11 -> multipleAddressBookSystem.readFromCSV();
                case 12 -> multipleAddressBookSystem.writingDataToCSV();
                case 13 -> {
                    moreChanges = false;
                    System.out.println("You are out of the Address Book System");
                }
            }
        }
    }

}
