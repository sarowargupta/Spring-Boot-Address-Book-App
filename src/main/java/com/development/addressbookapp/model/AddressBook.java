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

    //Section:-02 Handling AddressBook DTO and Model in Address book Service layer
    //UC-03 Ability for the Services Layer to store the AddressBook Data

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String phone;
    private String email;
    private String address;

}

