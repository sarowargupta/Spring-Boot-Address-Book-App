package com.development.addressbookapp.controller;
import com.development.addressbookapp.entity.AddressBook;
import com.development.addressbookapp.service.AddressBookService;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("addressbook")
public class AddressBookController {

    //Section:-01Address Book App Setup
    //UC-01 Create an address book project to cater to REST Request from Address Book UI

    private final AddressBookService service;

    public AddressBookController(AddressBookService service) {
        this.service = service;
    }

    //get all entries
    @GetMapping
    public List<AddressBook> getAll() {
        return service.getAllEntries();
    }

    //create a new entry
    @PostMapping
    public AddressBook addEntry(@RequestBody AddressBook entry) {
        return service.addEntry(entry);
    }

    //delete an entry by ID
    @DeleteMapping("/{id}")
    public void deleteEntry(@PathVariable Long id) {
        service.deleteEntry(id);
    }

    // Update an existing entry by ID
    @PutMapping("/{id}")
    public AddressBook updateEntry(@PathVariable Long id, @RequestBody AddressBook entry) {
        return service.updateEntry(id, entry);
    }

    // Get entry by ID
    @GetMapping("/{id}")
    public Optional<AddressBook> getById(@PathVariable Long id) {
        return service.getEntryById(id);
    }

}

