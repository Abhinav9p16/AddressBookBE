package com.cg.addressbook.model;

import com.cg.addressbook.dto.AddressBookDTO;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "address_book")
public @Data
class AddressBookData {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "contact_id")
    private int contactId;

    @Column(name = "name")
    private String name;
    private String address;
    private String city;
    private String state;
    private String zip;
    private String phone;


    public AddressBookData() {
    }

    public AddressBookData(AddressBookDTO addressBookDTO) {
        this.updateAddressBookData(addressBookDTO);
    }

    public void updateAddressBookData(AddressBookDTO addressBookDTO) {
        this.name = addressBookDTO.name;
        this.address = addressBookDTO.address;
        this.city = addressBookDTO.city;
        this.state = addressBookDTO.state;
        this.zip = addressBookDTO.zip;
        this.phone = addressBookDTO.phone;
    }
}









