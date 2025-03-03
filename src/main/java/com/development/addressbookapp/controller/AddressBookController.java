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

    //Section:-02 Handling AddressBook DTO and Model in Address book Service layer
    //UC-02 Introducing Service layer in Address Book app

    @Autowired
    private AddressBookService service;

    @GetMapping
    //get all entries
    public ResponseEntity<List<AddressBookDTO>> getAll() {
        return ResponseEntity.ok(service.getAllEntries());
    }

    //get entries by id
    @GetMapping("/{id}")
    public ResponseEntity<AddressBookDTO> getById(@PathVariable Long id) {
        return service.getEntryById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    //add new entry
    @PostMapping
    public ResponseEntity<AddressBook> addEntry(@RequestBody AddressBookDTO dto) {
        return ResponseEntity.ok(service.addEntry(dto));
    }

    //update entry by id
    @PutMapping("/{id}")
    public ResponseEntity<AddressBook> updateEntry(@PathVariable Long id, @RequestBody AddressBookDTO dto) {
        return ResponseEntity.ok(service.updateEntry(id, dto));
    }

    //delete entry by id
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEntry(@PathVariable Long id) {
        service.deleteEntry(id);
        return ResponseEntity.noContent().build();
    }

}

