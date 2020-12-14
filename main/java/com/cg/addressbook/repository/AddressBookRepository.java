package com.cg.addressbook.repository;

import com.cg.addressbook.model.AddressBookData;

import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressBookRepository extends JpaRepository<AddressBookData,Integer>{
}
