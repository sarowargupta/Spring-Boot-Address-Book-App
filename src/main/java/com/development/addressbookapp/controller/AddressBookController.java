package com.development.addressbookapp.controller;
import com.development.addressbookapp.dto.AddressBookDTO;
import com.development.addressbookapp.model.AddressBook;
import com.development.addressbookapp.service.AddressBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("addressbook")
public class AddressBookController {

    //Section:-03 Application Setting
    //UC-01 use Lombok library to auto generate getters and setters for the DTO

    @Autowired
    private AddressBookService service;

    // Get all contacts
    @GetMapping
    public ResponseEntity<List<AddressBookDTO>> getAll() {
        return ResponseEntity.ok(service.getAllEntries());
    }

    // Get contact by ID
    @GetMapping("/{id}")
    public ResponseEntity<AddressBookDTO> getById(@PathVariable Long id) {
        return service.getEntryById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Add new contact
    @PostMapping
    public ResponseEntity<AddressBook> addEntry(@RequestBody AddressBookDTO dto) {
        return ResponseEntity.ok(service.addEntry(dto));
    }

    // Update existing contact
    @PutMapping("/{id}")
    public ResponseEntity<AddressBook> updateEntry(@PathVariable Long id, @RequestBody AddressBookDTO dto) {
        return service.updateEntry(id, dto)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Delete contact
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEntry(@PathVariable Long id) {
        boolean deleted = service.deleteEntry(id);
        return deleted ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }
}

