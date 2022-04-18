package com.bridgelabz;

import com.opencsv.CSVReader;
import com.opencsv.bean.StatefulBeanToCsv;
import com.opencsv.bean.StatefulBeanToCsvBuilder;
import com.opencsv.exceptions.CsvDataTypeMismatchException;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

/**
 * Class containing methods for single AddressBook.
 *
 * @author - Moinuddin
 */
public class AddressBookSystem {
    /**
     * Scanner object creation for user input - scanner.
     */
    Scanner scanner = new Scanner(System.in);
    /**
     * Arraylist of Contact Type - contactArrayList.
     */
    ArrayList<Contact> contactArrayList = new ArrayList<>();



    /**
     * Method to Add Contact to contactArrayList.
     * Taking user input for number of contacts user wants to add - range
     * Using IntStream from range 0 to count to run for loop.
     * Taking user input for FirstName.
     * If - first name already exists in the contactArrayList: Print: Contact with Given First Name Already Exists.
     * Else - Create contact object and Take remaining field inputs from user - LastName, address, city, state, zip, phoneNumber and email.
     * calling set methods for the fields for the contact object.
     * Using add method to add this contact object to contactArrayList.
     */
    public void addContact() {

        System.out.println("Enter Number of Contacts You Want To Add: ");
        int count = scanner.nextInt();
        IntStream.range(0, count).forEach(count1 -> {
            System.out.println("Enter First Name");
            String firstName = scanner.next();
            if (contactArrayList.stream().anyMatch(contact1 -> contact1.getFirstName().equalsIgnoreCase(firstName))) {
                System.out.println("Contact with Given First Name Already Exists");
            } else System.out.println("Enter Last Name");
            Contact contact = new Contact();
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

    /**
     * Method to delete contact from AddressBoook.
     * Taking userInput to match contact by firstName.
     * Using removeIf method to remove contact from contactArrayList if user input matches with firstName of any contact. and taking boolean result out of it.
     * If true - shows confirmation message.
     * Else - Prints - No Contact Found with given First Name.
     */
    public void deleteContact() {

        System.out.println("Enter First Name of Contact You Want to Delete:");
        String firstName = scanner.next();
        boolean removeIf = contactArrayList.removeIf(contact1 -> contact1.getFirstName().equalsIgnoreCase(firstName));
        if (removeIf) {
            System.out.println("Contact Deleted Successfully");
        } else System.out.println("No Contact Found with given First Name");
    }

    /**
     * Method to edit Contact in contactArrayList.
     * Taking user input for firstName.
     * Using removeIf method to remove contact from contactArrayList if user input matches with firstName of any contact. and taking boolean result out of it.
     * If removed - calling addContact method.
     * Else - Prints - No Contact Found with given First Name.
     */
    public void editContact() {
        System.out.println("Enter First Name of Contact You Want to Edit:");
        String firstName = scanner.next();
        boolean removeIf = contactArrayList.removeIf(contact1 -> contact1.getFirstName().equalsIgnoreCase(firstName));
        if (removeIf) {
            addContact();
        } else System.out.println("No Contact Found with given First Name");
    }

    /**
     * Method to print contactArrayList using sout.
     */
    public void printAddressBook() {
        System.out.println(contactArrayList);
    }

    /**
     * Method to write AddressBook to txt file.
     * Created BufferedWriter objecct for FileWriter for addressbook.txt - writer.
     * For - Contact Type element contact1 of contactArrayList, calling write method to write string value of every element.
     * Closing writer object.
     *
     * @throws IOException
     */
    public void writeToFile() throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter("addressbook.txt"));
        for (Contact contact1 : contactArrayList) {
            writer.write(String.valueOf(contact1));
        }

        writer.close();
    }

    /**
     * Method to read AddressBook from txt file.
     * Created BufferedReader object for FileReader object to read from addressbook.txt - reader.
     * While reader.eradLine is not null. (Line is not empty.)
     * Prints every line calling readLine method for reader object.
     * Closed reader object.
     *
     * @throws IOException
     */
    public void readFromFile() throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("addressbook.txt"));
        while ((reader.readLine()) != null) {
            System.out.println(reader.readLine());
        }
        reader.close();
    }

    /**
     * Method to write AddressBook data to CSV file.
     * Created Writer Object using Files.newBufferedWriter object for path addressbook-csv.scv - writer.
     * StatefulBeanToCsvBuilder object for contact type created to set writer - builder.
     * StatefulBeanToCsv object created to write in CSV file - beanWriter.
     * Calling write method for beanWriter object using contactArrayList.
     * Closed writer object.
     * Message to print successful writing to csv.
     * Catch block handling IOException CsvDataTypeMismatchException and CsvRequiredFieldEmptyException.
     */
    public void writeDataToCSV() {


        try (Writer writer = Files.newBufferedWriter(Path.of("addressbook-csv.scv"))) {

            StatefulBeanToCsvBuilder<Contact> builder = new StatefulBeanToCsvBuilder<>(writer);
            StatefulBeanToCsv<Contact> beanWriter = builder.build();
            beanWriter.write(contactArrayList);
            writer.close();
            System.out.println("Written To CSV Successfully");
        } catch (IOException | CsvDataTypeMismatchException | CsvRequiredFieldEmptyException ioException) {
            ioException.printStackTrace();
        }
    }
}




