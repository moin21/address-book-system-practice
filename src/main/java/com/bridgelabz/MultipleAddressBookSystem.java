package com.bridgelabz;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvDataTypeMismatchException;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;

import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Class containing methods for multiple AddressBooks.
 *
 * @author - Moinudddin
 */
public class MultipleAddressBookSystem {
    /**
     * Scanner object to take user input - scanner.
     */
    Scanner scanner = new Scanner(System.in);
    /**
     * Object created for {@link AddressBookSystem} class - addressBookSystem
     */
    AddressBookSystem addressBookSystem = new AddressBookSystem();
    /**
     * Hash map containg String(AddressBook Name) as key and AddressBookSystem as value - multipleAddressBookHashMap.
     */
    HashMap<String, AddressBookSystem> multipleAddressBookHashMap = new HashMap<>();

    /**
     * Method to read AddressBook data from CSV file.
     * Using Try Catch Blocks to handle exception - exception.
     * Created CSVReader object using FileReader object - csvReader (File - addressbook-csv.csv)
     * While csvReader.readNext is not null (Until next line is not null.)
     * csvReader.readNext method called to read specific line.
     * Printed the same using toString method for Arrays.
     * closed csvReader object.
     * Catch block to handle exception.
     */
    public static void readFromCSV() {

        try {

            CSVReader csvReader = new CSVReader(new FileReader("addressbook-csv.csv"));

            while (csvReader.readNext() != null) {
                csvReader.readNext();
                System.out.println(Arrays.toString(csvReader.readNext()));

            }
            csvReader.close();
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    /**
     * Method to create AddressBook.
     * Taking user input for addressBook name.
     * If - Hashmaps contains key of the same name.: Shows message AddressBook Already Exists.
     * Else - Add new element to HashMap with the same key.
     * Shows message - New Address Book Created with name: .
     */
    public void addAddressBook() {
        System.out.println("Enter name of the address book");
        String bookName = scanner.next();
        if (multipleAddressBookHashMap.containsKey(bookName)) {
            System.out.println("AddressBook Already Exists");
        } else {
            multipleAddressBookHashMap.put(bookName, addressBookSystem);
            System.out.println("New Address Book Created with name: " + bookName);
        }

    }

    /**
     * Method to add contact to specific addressBook.
     * If - HashMap is empty: message to create AddressBook First.
     * Else - Taking user input for AddressBook name in which contact will be created.
     * Creating {@link AddressBookSystem} type object by get method from multipleAddressBookHashMap - addressBook.
     * If addressBook is null, no matches found: Prints message for the same.
     * Else - Calling addContact method for addressBook object.
     */
    public void addingContacts() {

        if (multipleAddressBookHashMap.isEmpty()) {
            System.out.println("There are No Address Books, First Add an AddressBook to Add Contacts in it.");
        } else {
            System.out.println("Enter name of address book you want to add contact in");
            String existingBook = scanner.next();
            AddressBookSystem addressBook = multipleAddressBookHashMap.get(existingBook);
            if (addressBook == null) {
                System.out.println("No address book exists with given name");
            } else {
                addressBook.addContact();
            }
        }
    }

    /**
     * Method to edit contact in specific addressBook.
     * If - HashMap is empty: message for no AddressBook.
     * Else - Taking user input for AddressBook name in which contact will be edited.
     * Creating {@link AddressBookSystem} type object by get method from multipleAddressBookHashMap - addressBook.
     * If addressBook is null, no matches found: Prints message for the same.
     * Else - Calling editContact method for addressBook object.
     */
    public void editingContacts() {

        if (multipleAddressBookHashMap.isEmpty()) {
            System.out.println("There are no Address Books.");
        } else {
            System.out.println("Enter name of address book you want to edit contact in");
            String existingBook = scanner.next();
            AddressBookSystem addressBook = multipleAddressBookHashMap.get(existingBook);
            if (addressBook == null) {
                System.out.println("No address book exists with given name");
            } else {
                addressBook.editContact();
            }
        }
    }

    /**
     * Method to delete contact in specific addressBook.
     * If - HashMap is empty: message for no AddressBook.
     * Else - Taking user input for AddressBook name in which contact will be edited.
     * Creating {@link AddressBookSystem} type object by get method from multipleAddressBookHashMap - addressBook.
     * If addressBook is null, no matches found: Prints message for the same.
     * Else - Calling deleteContact method for addressBook object.
     */
    public void deletingContacts() {

        if (multipleAddressBookHashMap.isEmpty()) {
            System.out.println("There are no Address Books.");
        } else {
            System.out.println("Enter name of address book you want to delete contact in");
            String existingBook = scanner.next();
            AddressBookSystem addressBook = multipleAddressBookHashMap.get(existingBook);
            if (addressBook == null) {
                System.out.println("No address book exists with given name");
            } else {
                addressBook.deleteContact();
            }
        }
    }

    /**
     * Method to print contacts in specific addressBook.
     * If - HashMap is empty: message for no AddressBook.
     * Else - Taking user input for AddressBook name in which contact will be edited.
     * Creating {@link AddressBookSystem} type object by get method from multipleAddressBookHashMap - addressBook.
     * If addressBook is null, no matches found: Prints message for the same.
     * Else - Calling printAddressBook method for addressBook object.
     */
    public void printingContacts() {

        if (multipleAddressBookHashMap.isEmpty()) {
            System.out.println("There are no Address Books.");
        } else {
            System.out.println("Enter name of address book you want to print");
            String existingBook = scanner.next();
            AddressBookSystem addressBook = multipleAddressBookHashMap.get(existingBook);
            if (addressBook == null) {
                System.out.println("No address book exists with given name");
            } else {
                addressBook.printAddressBook();
            }
        }
    }

    /**
     * Method to search contacts by city.
     * Taking to user input for city name.
     * For every key of multipleAddressBookHashMap. Creating arrayList of Contact Type from contactArrayList of every HashMap element - contactArrayList1.
     * Using stream.filter on contactArrayList1 by matching every element's cityName with userInput, for each match: Printing firstName.
     */
    public void searchByCity() {
        System.out.println("Enter the name of the City to search contacts : ");
        String cityName = scanner.next();
        for (String i : multipleAddressBookHashMap.keySet()) {
            ArrayList<Contact> contactArrayList1 = multipleAddressBookHashMap.get(i).contactArrayList;
            contactArrayList1.stream().filter(person -> person.getCity().equals(cityName)).forEach(person -> System.out.println(person.getFirstName()));
        }
    }

    /**
     * Method to count contacts in a city.
     * Taking user input for cityName.
     * Declaring AtomicInteger - count.
     * For every key of multipleAddressBookHashMap. Creating arrayList of Contact Type from contactArrayList of every HashMap element - contactArrayList1.
     * Using stream.filter to match every elements cityName with user input.
     * With every match count value gets increased using getAndIncrement method.
     * Printing count.
     */
    public void countByCity() {
        System.out.println("Enter the name of the City to search contacts : ");
        String cityName = scanner.next();
        AtomicInteger count = new AtomicInteger();
        for (String i : multipleAddressBookHashMap.keySet()) {
            ArrayList<Contact> contactArrayList1 = multipleAddressBookHashMap.get(i).contactArrayList;
            contactArrayList1.stream().filter(person -> person.getState().equalsIgnoreCase(cityName)).forEach(person -> count.getAndIncrement());
            System.out.println("Number on contacts in the city are: " + count);
        }
    }

    /**
     * Method to contacts by first name.
     * For every key of multipleAddressBookHashMap. Creating arrayList of Contact Type from contactArrayList of every HashMap element - contactArrayList1.
     * Using stream.sorted on contactArrayList1 by comparing firstName using Comparator.comparing method and then converting it to list using toList method. - sorted
     * Using for loop to print elements of sorted List.
     */
    public void sortAddressBook() {
        for (String i : multipleAddressBookHashMap.keySet()) {
            ArrayList<Contact> contactArrayList1 = multipleAddressBookHashMap.get(i).contactArrayList;

            List<Contact> sorted = contactArrayList1.stream().sorted(Comparator.comparing(Contact::getFirstName)).toList();

            System.out.println("------ Sorted Address Book ------");
            for (Contact contact : sorted) {
                System.out.println(contact);
                System.out.println();
            }
        }
    }

    /**
     * Method to write contact in specific addressBook to txt file.
     * If - HashMap is empty: message for no AddressBook.
     * Else - Taking user input for AddressBook name in which contact will be edited.
     * Creating {@link AddressBookSystem} type object by get method from multipleAddressBookHashMap - addressBook.
     * If addressBook is null, no matches found: Prints message for the same.
     * Else - Calling writeToFile method for addressBook object.
     *
     * @throws IOException
     */
    public void writingContacts() throws IOException {

        if (multipleAddressBookHashMap.isEmpty()) {
            System.out.println("There are no Address Books.");
        } else {
            System.out.println("Enter name of address book you want to delete contact in");
            String existingBook = scanner.next();
            AddressBookSystem addressBook = multipleAddressBookHashMap.get(existingBook);
            if (addressBook == null) {
                System.out.println("No address book exists with given name");
            } else {
                addressBook.writeToFile();
            }
        }
    }

    /**
     * Method to read contact from specific addressBook txt file.
     * If - HashMap is empty: message for no AddressBook.
     * Else - Taking user input for AddressBook name in which contact will be edited.
     * Creating {@link AddressBookSystem} type object by get method from multipleAddressBookHashMap - addressBook.
     * If addressBook is null, no matches found: Prints message for the same.
     * Else - Calling readFromFile method for addressBook object.
     *
     * @throws IOException
     */
    public void readingContacts() throws IOException {

        if (multipleAddressBookHashMap.isEmpty()) {
            System.out.println("There are no Address Books.");
        } else {
            System.out.println("Enter name of address book you want to delete contact in");
            String existingBook = scanner.next();
            AddressBookSystem addressBook = multipleAddressBookHashMap.get(existingBook);
            if (addressBook == null) {
                System.out.println("No address book exists with given name");
            } else {
                addressBook.readFromFile();
            }
        }
    }

    /**
     * Method to write AddressBook to a csv file
     * If - HashMap is empty: message for no AddressBook.
     * Else - Taking user input for AddressBook name in which contact will be edited.
     * Creating {@link AddressBookSystem} type object by get method from multipleAddressBookHashMap - addressBook.
     * If addressBook is null, no matches found: Prints message for the same.
     * Else - Calling writeDataToCSV method for addressBook object.
     *
     * @throws IOException
     * @throws CsvRequiredFieldEmptyException
     * @throws CsvDataTypeMismatchException
     */
    public void writingDataToCSV() throws IOException, CsvRequiredFieldEmptyException, CsvDataTypeMismatchException {

        if (multipleAddressBookHashMap.isEmpty()) {
            System.out.println("There are no Address Books.");
        } else {
            System.out.println("Enter name of address book you want to delete contact in");
            String existingBook = scanner.next();
            AddressBookSystem addressBook = multipleAddressBookHashMap.get(existingBook);
            if (addressBook == null) {
                System.out.println("No address book exists with given name");
            } else {
                addressBook.writeDataToCSV();
            }
        }
    }

    public void writingDataToJson() throws IOException {

        if (multipleAddressBookHashMap.isEmpty()) {
            System.out.println("There are no Address Books.");
        } else {
            System.out.println("Enter name of address book you want to delete contact in");
            String existingBook = scanner.next();
            AddressBookSystem addressBook = multipleAddressBookHashMap.get(existingBook);
            if (addressBook == null) {
                System.out.println("No address book exists with given name");
            } else {
                addressBook.writeToJson();
            }
        }
    }
}
