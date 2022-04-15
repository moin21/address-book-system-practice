package com.bridgelabz;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.stream.IntStream;

public class AddressBookSystem {
    Scanner scanner = new Scanner(System.in);
    ArrayList<Contact> contactArrayList = new ArrayList<>();

    public void addContact() {
        Contact contact = new Contact();
        System.out.println("Enter Number of Contacts You Want To Add: ");
        int count = scanner.nextInt();
        IntStream.range(0, count).forEach(count1 -> {
            System.out.println("Enter First Name");
            String firstName = scanner.next();
            if (contactArrayList.stream().anyMatch(contact1 -> contact1.getFirstName().equalsIgnoreCase(firstName))) {
                System.out.println("Contact with Given First Name Already Exists");
            } else System.out.println("Enter Last Name");
            String lastName = scanner.next();
            System.out.println("Enter Address");
            String address = scanner.next();
            System.out.println("Enter City Name");
            String city = scanner.next();
            System.out.println("Enter State Name");
            String state = scanner.next();
            System.out.println("Enter Zip Code");
            String zip = scanner.next();
            System.out.println("Enter Phone Number");
            String phoneNumber = scanner.next();
            System.out.println("Enter Email");
            String email = scanner.next();

            contact.setFirstName(firstName);
            contact.setLastName(lastName);
            contact.setAddress(address);
            contact.setCity(city);
            contact.setState(state);
            contact.setZip(zip);
            contact.setPhoneNumber(phoneNumber);
            contact.setEmail(email);
            contactArrayList.add(contact);
        });

    }

    public void deleteContact() {
        Contact contact = new Contact();

        System.out.println("Enter First Name of Contact You Want to Delete:");
        String firstName = scanner.next();
        boolean removeIf = contactArrayList.removeIf(contact1 -> contact1.getFirstName().equalsIgnoreCase(firstName));
        if (removeIf) {
            System.out.println("Contact Deleted Successfully");
        } else System.out.println("No Contact Found with given First Name");
    }

    public void editContact() {
        System.out.println("Enter First Name of Contact You Want to Edit:");
        String firstName = scanner.next();
        boolean removeIf = contactArrayList.removeIf(contact1 -> contact1.getFirstName().equalsIgnoreCase(firstName));
        if (removeIf) {
            addContact();
        } else System.out.println("No Contact Found with given First Name");
    }

    public void printAddressBook() {
        System.out.println(contactArrayList);
    }
}




