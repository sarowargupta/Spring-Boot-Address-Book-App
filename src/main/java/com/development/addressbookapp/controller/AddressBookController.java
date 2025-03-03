package com.development.addressbookapp.controller;
import com.development.addressbookapp.model.AddressBook;
import com.development.addressbookapp.service.AddressBookService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("addressbook")
public class AddressBookController {

    //Section:-02 Handling AddressBook DTO and Model in Address book Service layer
    //UC-02 Introducing DTO and Model yo AddressBook App

    private final AddressBookService service;

    public AddressBookController(AddressBookService service) {
        this.service = service;
    }

    // Get all entries
    @GetMapping
    public ResponseEntity<List<AddressBook>> getAll() {
        List<AddressBook> entries = service.getAllEntries();
        return ResponseEntity.ok(entries);
    }

    // Get entry by ID
    @GetMapping("/{id}")
    public ResponseEntity<AddressBook> getById(@PathVariable Long id) {
        return service.getEntryById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Create a new entry
    @PostMapping
    public ResponseEntity<AddressBook> addEntry(@RequestBody AddressBook entry) {
        AddressBook savedEntry = service.addEntry(entry);
        return ResponseEntity.ok(savedEntry);
    }

    // Update an existing entry by ID
    @PutMapping("/{id}")
    public ResponseEntity<AddressBook> updateEntry(@PathVariable Long id, @RequestBody AddressBook entry) {
        return ResponseEntity.ok(service.updateEntry(id, entry));
    }

    // Delete an entry by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEntry(@PathVariable Long id) {
        service.deleteEntry(id);
        return ResponseEntity.noContent().build();
    }
}

