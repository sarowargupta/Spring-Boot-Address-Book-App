package com.development.addressbookapp.dto;
import lombok.*;

//Section:-03 Application Setting
//UC-04 Database setting as Environment Variables

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