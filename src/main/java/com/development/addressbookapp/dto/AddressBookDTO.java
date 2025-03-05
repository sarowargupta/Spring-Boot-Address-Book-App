package com.development.addressbookapp.dto;
import lombok.*;

//Section:-03 Application Setting
//UC-03 Determine logging levels

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