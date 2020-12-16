package com.cg.addressbook.services;

import java.util.ArrayList;
import java.util.List;

import com.cg.addressbook.exceptions.AddressBookException;
import com.cg.addressbook.repository.AddressBookRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.addressbook.dto.AddressBookDTO;
import com.cg.addressbook.model.AddressBookData;

@Service
@Slf4j
public class AddressBookService implements IAddressBookService{

    @Autowired
    private AddressBookRepository addressBookRepository;

    public List<AddressBookData> getAddressBookData() {
        return addressBookRepository.findAll();
    }

    public AddressBookData getAddressBookDataById(int contactId) {
        return addressBookRepository
                .findById(contactId)
                .orElseThrow(() -> new AddressBookException("ContactId "+contactId+" not Found"));
    }

    public AddressBookData createAddressBookData(AddressBookDTO addressBookDTO) {
        AddressBookData addressBookData = null;
        addressBookData = new AddressBookData(addressBookDTO);
        log.debug("AddressBook Data "+addressBookData.toString());
        return addressBookRepository.save(addressBookData);
    }

    public AddressBookData updateAddressBookData(int contactId, AddressBookDTO addressBookDTO) {
        AddressBookData addressBookData = this.getAddressBookDataById(contactId);
        addressBookData.updateAddressBookData(addressBookDTO);
        return addressBookRepository.save(addressBookData);
    }

    public void deleteAddressBookData(int contactId) {
        AddressBookData addressBookData = this.getAddressBookDataById(contactId);
        addressBookRepository.delete(addressBookData);

    }
}