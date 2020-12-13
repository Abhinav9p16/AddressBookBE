package com.cg.addressbook.model;

import com.cg.addressbook.dto.AddressBookDTO;

public class AddressBookData {

    private int contactId;
    private String name;
    private String address;
    private String city;
    private String state;
    private String zip;
    private String phone;


    public AddressBookData() {
    }

    public AddressBookData(int contactId , AddressBookDTO addressBookDTO) {
        this.contactId = contactId;
        this.name = addressBookDTO.name;
        this.address = addressBookDTO.address;
        this.city = addressBookDTO.city;
        this.state = addressBookDTO.state;
        this.zip = addressBookDTO.zip;
        this.phone = addressBookDTO.phone;
    }

    public int getContactId() {
        return contactId;
    }

    public void setContactId(int contactId) {
        this.contactId = contactId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}









