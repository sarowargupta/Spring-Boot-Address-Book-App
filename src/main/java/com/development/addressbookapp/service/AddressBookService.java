package com.development.addressbookapp.service;
import com.development.addressbookapp.dto.AddressBookDTO;
import com.development.addressbookapp.exception.AddressBookNotFoundException;
import com.development.addressbookapp.model.AddressBook;
import com.development.addressbookapp.repository.AddressBookRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class AddressBookService {

    //Section:-04 Data Validation and Exception Handling in Address Book App
    //UC-03 Ability to throw User Friendly Errors

    private final AddressBookRepository addressBookRepository;

    public AddressBookService(AddressBookRepository addressBookRepository) {
        this.addressBookRepository = addressBookRepository;
    }

    //get all entry
    public List<AddressBook> getAllEntries() {
        return addressBookRepository.findAll();
    }

    //get entry by id
    public AddressBook getEntryById(Long id) {
        return addressBookRepository.findById(id)
                .orElseThrow(() -> new AddressBookNotFoundException("Address Book entry not found for ID: " + id));
    }

    //add a new entry
    public AddressBook createEntry(AddressBookDTO addressBookDTO) {
        AddressBook addressBook = convertToEntity(addressBookDTO);
        return addressBookRepository.save(addressBook);
    }

    //update entry by its id
    public AddressBook updateEntry(Long id, AddressBookDTO addressBookDTO) {
        AddressBook existingEntry = getEntryById(id);
        AddressBook updatedEntry = convertToEntity(addressBookDTO);
        updatedEntry.setId(existingEntry.getId()); // Ensure ID remains the same
        return addressBookRepository.save(updatedEntry);
    }

    //delete entry by id
    public void deleteEntry(Long id) {
        AddressBook existingEntry = getEntryById(id);
        addressBookRepository.delete(existingEntry);
    }

    //`convertToEntity()
    private AddressBook convertToEntity(AddressBookDTO dto) {
        AddressBook entity = new AddressBook();
        entity.setName(dto.getName());
        entity.setPhone(dto.getPhone());
        entity.setEmail(dto.getEmail());
        entity.setAddress(dto.getAddress());
        return entity;
    }
}