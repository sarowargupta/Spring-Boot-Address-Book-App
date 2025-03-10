package com.development.addressbookapp.model;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
//class Address Book
public class AddressBook {

    //Section:-04 Data Validation and Exception Handling in Address Book App
    //UC-03 Ability to throw User Friendly Errors

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Auto-increment ID
    private Long id;
    private String name;
    private String phone;
    private String email;
    private String address;

    public AddressBook(String name, String phone, String email, String address) {
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.address = address;
    }

}

