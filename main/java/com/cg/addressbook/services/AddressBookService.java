package com.cg.addressbook.services;

import java.util.ArrayList;
import java.util.List;

import com.cg.addressbook.exceptions.AddressBookException;
import org.springframework.stereotype.Service;

import com.cg.addressbook.dto.AddressBookDTO;
import com.cg.addressbook.model.AddressBookData;

@Service
public class AddressBookService implements IAddressBookService{

    private List<AddressBookData> contactList = new ArrayList<>();

    public List<AddressBookData> getAddressBookData() {
        return contactList;
    }

    public AddressBookData getAddressBookDataById(int contactId) {
        return contactList.stream()
                .filter(contactData -> contactData.getContactId()==contactId)
                .findFirst()
                .orElseThrow(() -> new AddressBookException("Contact not Found"));
    }

    public AddressBookData createAddressBookData(AddressBookDTO addressBookDTO) {
        AddressBookData addressBookData = null;
        addressBookData = new AddressBookData(contactList.size()+1,addressBookDTO);
        return addressBookData;
    }

    public AddressBookData updateAddressBookData(int contactId, AddressBookDTO addressBookDTO) {
        AddressBookData addressBookData = this.getAddressBookDataById(contactId);
        addressBookData.setName(addressBookDTO.name);
        addressBookData.setAddress(addressBookDTO.address);
        addressBookData.setCity(addressBookDTO.city);
        addressBookData.setState(addressBookDTO.state);
        addressBookData.setPhone(addressBookDTO.phone);
        contactList.set(contactId-1,addressBookData);
        return addressBookData;
    }

    public void deleteAddressBookData(int contactId) {
        contactList.remove(contactId-1);
    }
}