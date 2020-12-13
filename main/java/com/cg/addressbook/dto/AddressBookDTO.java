package com.cg.addressbook.dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;


public class AddressBookDTO {

    @Pattern(regexp = "^[A-Z][a-zA-z\\s]{2,}$", message = "Contact Name Invalid!")
    public String name;
    @NotEmpty(message = "Address Can't Be Empty!")
    public String address;
    @NotEmpty(message = "City Can't Be Empty!")
    public String city;
    @NotEmpty(message = "State Can't Be Empty!")
    public String state;
    @NotEmpty(message = "Zip Can't Be Empty!")
    public String zip;
    @Pattern(regexp = "^[98][0-9]{9}$", message = "Mobile No Invalid!")
    public String phone;

    public AddressBookDTO() { }

    public AddressBookDTO(String name, String address, String city, String state, String zip, String phone) {
        this.name = name;
        this.address = address;
        this.city = city;
        this.state = state;
        this.zip = zip;
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "AddressBookDTO{" +
                "name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", zip='" + zip + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }
}
