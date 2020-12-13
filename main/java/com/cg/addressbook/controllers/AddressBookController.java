package com.cg.addressbook.controllers;

import com.cg.addressbook.dto.AddressBookDTO;
import com.cg.addressbook.dto.ResponseDTO;
import com.cg.addressbook.model.AddressBookData;
import com.cg.addressbook.services.AddressBookService;
import com.cg.addressbook.services.IAddressBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import org.springframework.http.HttpStatus;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/employeepayrollservice")
public class AddressBookController {

    @Autowired
    private IAddressBookService addressBookService;

    @RequestMapping(value = {"", "/", "/get"})
    public ResponseEntity<ResponseDTO> getAddressBookData() {
        List<AddressBookData> contactList = null;
        contactList = addressBookService.getAddressBookData();
        ResponseDTO respDTO = new ResponseDTO("Get Call Successful", contactList);
        return new ResponseEntity<ResponseDTO>(respDTO, HttpStatus.OK);
    }

    @GetMapping("/get/{contactId}")
    public ResponseEntity<ResponseDTO> getAddressBookData(@PathVariable("contactId") int contactId) {
        AddressBookData addressBookData = null;
        addressBookData = addressBookService.getAddressBookDataById(contactId);
        ResponseDTO respDTO = new ResponseDTO("Get Call for ID Successful", addressBookData);
        return new ResponseEntity<ResponseDTO>(respDTO, HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<ResponseDTO> createAddressBookData(@Valid @RequestBody AddressBookDTO addressBookDTO) {
        AddressBookData addressBookData = null;
        addressBookData = addressBookService.createAddressBookData(addressBookDTO);
        ResponseDTO respDTO = new ResponseDTO("Created AddressBook Data Successfully", addressBookData);
        return new ResponseEntity<ResponseDTO>(respDTO, HttpStatus.OK);
    }

    @PutMapping("/update/{contactId}")
    public ResponseEntity<ResponseDTO> updateAddressBookData(@PathVariable("contactId") int contactId, @RequestBody AddressBookDTO addressBookDTO) {
        AddressBookData addressBookData = null;
        addressBookData = addressBookService.updateAddressBookData(contactId, addressBookDTO);
        ResponseDTO respDTO = new ResponseDTO("Updated AddressBook Data Successfully", addressBookData);
        return new ResponseEntity<ResponseDTO>(respDTO, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{contactId}")
    public ResponseEntity<ResponseDTO> deleteAddressBookData(@PathVariable("contactId") int contactId) {
        addressBookService.deleteAddressBookData(contactId);
        ResponseDTO respDTO = new ResponseDTO("Deleted Successfully", "Deleted id: " + contactId);
        return new ResponseEntity<ResponseDTO>(respDTO, HttpStatus.OK);
    }

}


