package com.development.addressbookapp.dto;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

//Section:-02 Handling AddressBook DTO and Model in Address book Service layer
//UC-02 Introducing Service layer in Address Book app

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

    public AddressBookDTO(String name, String phone) {
        this.name = name;
        this.phone = phone;
    }

}