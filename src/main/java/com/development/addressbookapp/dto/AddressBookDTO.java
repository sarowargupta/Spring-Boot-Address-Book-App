package com.development.addressbookapp.dto;
import lombok.*;

//Section:-02 Handling AddressBook DTO and Model in Address book Service layer
//UC-03 Ability for the Services Layer to store the AddressBook Data

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AddressBookDTO {

    private Long id;
    private String name;
    private String phone;
    private String email;
    private String address;


}