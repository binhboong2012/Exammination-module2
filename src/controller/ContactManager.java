package controller;

import model.Contact;

import java.util.ArrayList;
import java.util.List;

public class ContactManager {
    private static List<Contact> contacts = new ArrayList<>();

    public List<Contact> getContacts() {
        return contacts;
    }

    public void setContacts(List<Contact> contacts) {
        this.contacts = contacts;
    }

    public int size() {
        return contacts.size();
    }

    public void displayAllContact() {
        for (int i = 0; i < contacts.size(); i++) {
            System.out.println(contacts.get(i));
        }
    }

    public void addNewContact(Contact contact) {
        this.contacts.add(contact);
    }

    public void updateContact(int index, Contact contact) {
        contact.set(index, contact);

    }

    public void remoContact(int index) {
        contacts.remove(index);
    }

//    public Contact findHotelByName(String searchName) {
//        Contact result = null;
//
//        for (Contact contact : contacts) {
//            Phonenumber phonenumber= contact.getPhoneNumber();
//            boolean found = phonenumber.get().equals(searchName);
//            if (found) {
//                result = hotel;
//                break;
//            }
//        }
//
//        return result;

    public int findContactByName(String name) {
        int index = -1;
        for (int i = 0; i < contacts.size(); i++) {
            if (contacts.get(i).getName().equals(name)){
                index = i;
                break;
            }
        }
        return index;
    }
}