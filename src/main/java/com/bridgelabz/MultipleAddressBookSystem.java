package com.bridgelabz;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;

public class MultipleAddressBookSystem {
    Scanner scanner = new Scanner(System.in);
    AddressBookSystem addressBookSystem = new AddressBookSystem();
    HashMap<String, AddressBookSystem> multipleAddressBookHashMap = new HashMap<>();

    public void addAddressBook() {
        System.out.println("Enter name of the address book");
        String bookName = scanner.next();
        if (multipleAddressBookHashMap.containsKey(bookName)) {
            System.out.println("Book Already Exists");
        } else {


            multipleAddressBookHashMap.put(bookName, addressBookSystem);
            System.out.println("New Address Book Created with name: " + bookName);
        }

    }

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
                multipleAddressBookHashMap.get(existingBook).addContact();
            }
        }
    }

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
                multipleAddressBookHashMap.get(existingBook).editContact();
            }
        }
    }

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
                multipleAddressBookHashMap.get(existingBook).deleteContact();
            }
        }
    }

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
                multipleAddressBookHashMap.get(existingBook).printAddressBook();
            }
        }
    }

    public void searchByCity() {
        System.out.println("Enter the name of the City to search contacts : ");
        String cityName = scanner.next();
        for (String i : multipleAddressBookHashMap.keySet()) {
            ArrayList<Contact> contactArrayList1 = multipleAddressBookHashMap.get(i).contactArrayList;
            contactArrayList1.stream().filter(person -> person.getCity().equals(cityName)).forEach(person -> System.out.println(person.getFirstName()));
        }
    }

    public void countByCity() {
        System.out.println("Enter the name of the City to search contacts : ");
        String cityName = scanner.next();

        for (String i : multipleAddressBookHashMap.keySet()) {
            AtomicInteger count = new AtomicInteger();
            ArrayList<Contact> contactArrayList1 = multipleAddressBookHashMap.get(i).contactArrayList;
            contactArrayList1.stream().filter(person -> person.getState().equalsIgnoreCase(cityName)).forEach(person -> count.getAndIncrement());
            System.out.println("Number on contacts in the city are: " + count);
        }
    }

    public void sortAddressBook() {
        for (String i : multipleAddressBookHashMap.keySet()) {
            ArrayList<Contact> contactArrayList1 = multipleAddressBookHashMap.get(i).contactArrayList;

            List<Contact> sorted = contactArrayList1.stream().sorted((firstperson, secondperson) ->
                    firstperson.getFirstName().compareTo(secondperson.getFirstName())).toList();

            System.out.println("------ Sorted Address Book ------");
            for (Contact contact : sorted) {
                System.out.println(contact);
                System.out.println();
            }
        }
    }

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
                multipleAddressBookHashMap.get(existingBook).writeToFile();
            }
        }
    }

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
                multipleAddressBookHashMap.get(existingBook).readFromFile();
            }
        }
    }
}
