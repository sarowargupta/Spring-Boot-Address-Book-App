package com.development.addressbookapp.service;
import com.development.addressbookapp.dto.AddressBookDTO;
import com.development.addressbookapp.model.AddressBook;
import com.development.addressbookapp.repository.AddressBookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
public class AddressBookService {

    //Section:-03 Application Setting
    //UC-01 use Lombok library to auto generate getters and setters for the DTO
    @Autowired
    private AddressBookRepository repository;

    // Convert Model to DTO
    private AddressBookDTO convertToDTO(AddressBook addressBook) {
        return new AddressBookDTO(addressBook.getId(), addressBook.getName(), addressBook.getPhone(), addressBook.getEmail(), addressBook.getAddress());
    }


    // Get all entries
    public List<AddressBookDTO> getAllEntries() {
        return repository.findAll().stream()
                .map(entry -> new AddressBookDTO(entry.getId(), entry.getName(), entry.getPhone(), entry.getEmail(), entry.getAddress()))
                .collect(Collectors.toList());
    }

    // Get entry by ID
    public Optional<AddressBookDTO> getEntryById(Long id) {
        return repository.findById(id)
                .map(entry -> new AddressBookDTO(entry.getId(), entry.getName(), entry.getPhone(), entry.getEmail(), entry.getAddress()));
    }

    // Add a new entry
    public AddressBook addEntry(AddressBookDTO dto) {
        AddressBook entry = new AddressBook(null, dto.getName(), dto.getPhone(), dto.getEmail(), dto.getAddress());
        return repository.save(entry);
    }

    // Update an existing entry
    public Optional<AddressBook> updateEntry(Long id, AddressBookDTO dto) {
        return repository.findById(id)
                .map(entry -> {
                    entry.setName(dto.getName());
                    entry.setPhone(dto.getPhone());
                    entry.setEmail(dto.getEmail());
                    entry.setAddress(dto.getAddress());
                    return repository.save(entry);
                });
    }

    // Delete an entry
    public boolean deleteEntry(Long id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
            return true;
        }
        return false;
    }
}