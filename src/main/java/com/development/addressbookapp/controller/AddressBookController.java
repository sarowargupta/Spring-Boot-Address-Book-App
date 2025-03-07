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
     //UC-02 Provide User Friendly in case validation fails

    private final AddressBookService addressBookService;

    public AddressBookController(AddressBookService addressBookService) {
        this.addressBookService = addressBookService;
    }

    // Get all entries
    @GetMapping
    public ResponseEntity<List<AddressBook>> getAllEntries() {
        return ResponseEntity.ok(addressBookService.getAllEntries());
    }

    // Get entry by ID
    @GetMapping("/{id}")
    public ResponseEntity<AddressBook> getEntryById(@PathVariable Long id) {
        return ResponseEntity.ok(addressBookService.getEntryById(id));
    }

    // Add a new entry
    @PostMapping
    public ResponseEntity<AddressBook> createEntry(@Valid @RequestBody AddressBookDTO addressBookDTO) {
        AddressBook savedEntry = addressBookService.createEntry(addressBookDTO);
        return ResponseEntity.ok(savedEntry);
    }

    // Update an entry by ID
    @PutMapping("/{id}")
    public ResponseEntity<AddressBook> updateEntry(@PathVariable Long id, @Valid @RequestBody AddressBookDTO addressBookDTO) {
        AddressBook updatedEntry = addressBookService.updateEntry(id, addressBookDTO);
        return ResponseEntity.ok(updatedEntry);
    }

    // Delete an entry by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEntry(@PathVariable Long id) {
        addressBookService.deleteEntry(id);
        return ResponseEntity.noContent().build();
    }
}