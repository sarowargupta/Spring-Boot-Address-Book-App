package com.development.addressbookapp.service;
import com.development.addressbookapp.model.AddressBook;
import com.development.addressbookapp.repository.AddressBookRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;


@Service
public class AddressBookService {

    //Section:-02 Handling AddressBook DTO and Model in Address book Service layer
    //UC-01 Introducing DTO and Model yo AddressBook App

    private final AddressBookRepository repository;

    public AddressBookService(AddressBookRepository repository) {
        this.repository = repository;
    }

    public List<AddressBook> getAllEntries() {
        return repository.findAll();
    }

    public Optional<AddressBook> getEntryById(Long id) {
        return repository.findById(id);
    }

    public AddressBook addEntry(AddressBook entry) {
        return repository.save(entry);
    }

    public AddressBook updateEntry(Long id, AddressBook newEntry) {
        return repository.findById(id).map(entry -> {
            entry.setName(newEntry.getName());
            entry.setPhone(newEntry.getPhone());
            entry.setEmail(newEntry.getEmail());
            entry.setAddress(newEntry.getAddress());
            return repository.save(entry);
        }).orElseThrow(() -> new RuntimeException("Entry not found with id: " + id));
    }

    public void deleteEntry(Long id) {
        repository.deleteById(id);
    }

}
