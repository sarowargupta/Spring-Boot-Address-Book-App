package com.development.addressbookapp.service;
import com.development.addressbookapp.entity.AddressBook;
import com.development.addressbookapp.repository.AddressBookRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;


@Service
public class AddressBookService {
    private final AddressBookRepository repository;

    //Section:-01Address Book App Setup
    //UC-01 Create an address book project to cater to REST Request from Address Book UI

    public AddressBookService(AddressBookRepository repository) {
        this.repository = repository;
    }

    //get all entries
    public List<AddressBook> getAllEntries() {
        return repository.findAll();
    }

    //add a new entry
    public AddressBook addEntry(AddressBook entry) {
        return repository.save(entry);
    }

    //update entry by its id
    public AddressBook updateEntry(Long id, AddressBook updatedEntry) {
        return repository.findById(id).map(entry -> {
            entry.setName(updatedEntry.getName());
            entry.setPhone(updatedEntry.getPhone());
            entry.setEmail(updatedEntry.getEmail());
            entry.setAddress(updatedEntry.getAddress());
            return repository.save(entry);
        }).orElseThrow(() -> new RuntimeException("Entry not found"));
    }

    //delete entry by id
    public void deleteEntry(Long id) {
        repository.deleteById(id);
    }

    //get entry by id
    public Optional<AddressBook> getEntryById(Long id) {
        return repository.findById(id);
    }

}
