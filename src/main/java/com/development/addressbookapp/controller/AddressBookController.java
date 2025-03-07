package com.development.addressbookapp.controller;
import com.development.addressbookapp.dto.AddressBookDTO;
import com.development.addressbookapp.model.AddressBook;
import com.development.addressbookapp.service.AddressBookService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/addressbook")
public class AddressBookController {

     //Section:-04 Data Validation and Exception Handling in Address Book App
     //UC-03 Ability to throw User Friendly Errors

    private final AddressBookService addressBookService;

    public AddressBookController(AddressBookService addressBookService) {
        this.addressBookService = addressBookService;
    }

    //get all entry
    @GetMapping
    public ResponseEntity<List<AddressBook>> getAllEntries() {
        return ResponseEntity.ok(addressBookService.getAllEntries());
    }

    //get entry by id
    @GetMapping("/{id}")
    public ResponseEntity<AddressBook> getEntryById(@PathVariable Long id) {
        return ResponseEntity.ok(addressBookService.getEntryById(id));
    }

    //add a new entry
    @PostMapping
    public ResponseEntity<AddressBook> createEntry(@Valid @RequestBody AddressBookDTO addressBookDTO) {
        AddressBook createdEntry = addressBookService.createEntry(addressBookDTO);
        return ResponseEntity.ok(createdEntry);
    }

    //update entry by id
    @PutMapping("/{id}")
    public ResponseEntity<AddressBook> updateEntry(@PathVariable Long id, @Valid @RequestBody AddressBookDTO addressBookDTO) {
        AddressBook updatedEntry = addressBookService.updateEntry(id, addressBookDTO);
        return ResponseEntity.ok(updatedEntry);
    }

    //delete entry by id
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteEntry(@PathVariable Long id) {
        addressBookService.deleteEntry(id);
        return ResponseEntity.ok("Entry deleted successfully!");
    }
}