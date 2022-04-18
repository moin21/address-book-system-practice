package com.bridgelabz;

/**
 * POJO Class for Contact Entity.
 *
 * @author - Moinuddin
 */
public class Contact {
    /**
     * firstName - First Name of Contact.
     * lastName - Last Name of Contact.
     * address - Address of Contact.
     * city - City Name of Contact.
     * state - State Name of Contact.
     * zip - Zip Code of Contact.
     * phoneNumber - Phone Number related to Contact.
     * email - Email of Contact.
     */

    public String firstName, lastName, address, city, state, zip, phoneNumber, email;

    /**
     * Constructor - For Contact Entity.
     *
     * @param firstName   - First Name of Contact.
     * @param lastName    - Last Name of Contact.
     * @param address     - Address of Contact.
     * @param city        - City Name of Contact.
     * @param state       - State Name of Contact.
     * @param zip         - Zip Code of Contact.
     * @param phoneNumber - Phone Number related to Contact.
     * @param email       - Email of Contact.
     */
    public Contact(String firstName, String lastName, String address, String city, String state, String zip, String phoneNumber, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.city = city;
        this.state = state;
        this.zip = zip;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

    /**
     * Default Constructor.
     */
    public Contact() {

    }

    /**
     * Getters and Setters for above mentioned fields.
     */
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * To String method to Print ArrayList.
     *
     * @return - String form of ArrayList.
     */
    @Override
    public String toString() {
        return "Contact{" + "firstName='" + firstName + '\'' + ", lastName='" + lastName + '\'' + ", address='" + address + '\'' + ", city='" + city + '\'' + ", state='" + state + '\'' + ", zip='" + zip + '\'' + ", phoneNumber='" + phoneNumber + '\'' + ", email='" + email + '\'' + '}' + "\n";
    }
}
