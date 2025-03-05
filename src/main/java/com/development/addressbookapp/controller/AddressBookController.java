package com.development.addressbookapp.controller;
import com.development.addressbookapp.dto.AddressBookDTO;
import com.development.addressbookapp.service.AddressBookService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/addressbook")
@Slf4j  // Enables logging
public class AddressBookController {

     //Section:-03 Application Setting
     // UC-02 use Lombok library for logging

    @Autowired
    private AddressBookService service;

    //get all entity
    @GetMapping
    public ResponseEntity<List<AddressBookDTO>> getAllEntries() {
        log.info("Received request to fetch all entries");
        return ResponseEntity.ok(service.getAllEntries());
    }

    //get entity by id
    @GetMapping("/{id}")
    public ResponseEntity<?> getEntryById(@PathVariable Long id) {
        log.info("Received request to fetch entry with ID: {}", id);
        AddressBookDTO dto = service.getEntryById(id);
        return dto != null ? ResponseEntity.ok(dto) : ResponseEntity.notFound().build();
    }

    //create a new entry
    @PostMapping
    public ResponseEntity<AddressBookDTO> addEntry(@RequestBody AddressBookDTO dto) {
        log.info("Received request to add new entry: {}", dto);
        return ResponseEntity.ok(service.addEntry(dto));
    }

    //update an entry
    @PutMapping("/{id}")
    public ResponseEntity<?> updateEntry(@PathVariable Long id, @RequestBody AddressBookDTO dto) {
        log.info("Received request to update entry with ID: {}", id);
        AddressBookDTO updatedDto = service.updateEntry(id, dto);
        return updatedDto != null ? ResponseEntity.ok(updatedDto) : ResponseEntity.notFound().build();
    }

    //delete an entry
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteEntry(@PathVariable Long id) {
        log.info("Received request to delete entry with ID: {}", id);
        boolean deleted = service.deleteEntry(id);
        return deleted ? ResponseEntity.ok("Entry deleted successfully") : ResponseEntity.notFound().build();
    }
}