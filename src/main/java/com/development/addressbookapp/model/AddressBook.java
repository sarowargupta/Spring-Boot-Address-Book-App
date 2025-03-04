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

    //Section:-03 Application Setting
    //UC-01 use Lombok library to auto generate getters and setters for the DTO
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Auto-increment ID
    private Long id;
    private String name;
    private String phone;
    private String email;
    private String address;

}

