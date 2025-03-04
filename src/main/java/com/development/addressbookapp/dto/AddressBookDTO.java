package com.development.addressbookapp.dto;
import lombok.*;

//Section:-03 Application Setting
//UC-01 use Lombok library to auto generate getters and setters for the DTO

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