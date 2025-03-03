package com.development.addressbookapp.dto;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

//Section:-02 Handling AddressBook DTO and Model in Address book Service layer
//UC-01 Introducing DTO and Model yo AddressBook App
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AddressBookDTO {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String phone;
    private String email;
    private String address;

}