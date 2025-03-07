package com.development.addressbookapp.service;
import com.development.addressbookapp.dto.AddressBookDTO;
import com.development.addressbookapp.model.AddressBook;
import com.development.addressbookapp.repository.AddressBookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class AddressBookService {

    //Section:-04 Data Validation and Exception Handling in Address Book App
    //UC-02 Provide User Friendly in case validation fails

    @Autowired
    private AddressBookRepository addressBookRepository;

    //get all entry
    public List<AddressBook> getAllEntries() {
        return addressBookRepository.findAll();
    }

    //get entry by id
    public AddressBook getEntryById(Long id) {
        return addressBookRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Entry not found with ID: " + id));
    }

    // Add a new entry
    public AddressBook createEntry(AddressBookDTO addressBookDTO) {
        AddressBook newEntry = new AddressBook();
        newEntry.setName(addressBookDTO.getName());
        newEntry.setPhone(addressBookDTO.getPhone());
        newEntry.setEmail(addressBookDTO.getEmail());
        newEntry.setAddress(addressBookDTO.getAddress());
        return addressBookRepository.save(newEntry);
    }

    // Update an entry by ID
    public AddressBook updateEntry(Long id, AddressBookDTO addressBookDTO) {
        AddressBook existingEntry = addressBookRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Entry not found with ID: " + id));

        existingEntry.setName(addressBookDTO.getName());
        existingEntry.setPhone(addressBookDTO.getPhone());
        existingEntry.setEmail(addressBookDTO.getEmail());
        existingEntry.setAddress(addressBookDTO.getAddress());

        return addressBookRepository.save(existingEntry);
    }

    //delete entry by id
    public void deleteEntry(Long id) {
        if (!addressBookRepository.existsById(id)) {
            throw new RuntimeException("Entry not found with ID: " + id);
        }
        addressBookRepository.deleteById(id);
    }
}