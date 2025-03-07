package com.development.addressbookapp.dto;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.*;

@Data
public class AddressBookDTO {

    //Section:-04 Data Validation and Exception Handling in Address Book App
    //UC-02 Provide User Friendly in case validation fails

 private Long id;
    @NotEmpty(message = "Name cannot be empty")
    @Pattern(regexp = "^[A-Z][a-zA-Z\\s]{2,}$",
            message = "Name must start with a capital letter and have at least 3 characters")
    private String name;

    @NotEmpty(message = "Phone number cannot be empty")
    private String phone;

    @NotEmpty(message = "Email cannot be empty")
    private String email;

    @NotEmpty(message = "Address cannot be empty")
    private String address;
}