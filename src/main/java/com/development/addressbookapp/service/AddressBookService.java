package com.development.addressbookapp.service;
import com.development.addressbookapp.dto.AddressBookDTO;
import com.development.addressbookapp.model.AddressBook;
import com.development.addressbookapp.repository.AddressBookRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
@Slf4j  // Enables logging
public class AddressBookService {

    //Section:-03 Application Setting
    //UC-03 Determine the logging levels

    @Autowired
    private AddressBookRepository repository;

    //convert entity to dto
    private AddressBookDTO convertToDTO(AddressBook addressBook) {
        return new AddressBookDTO(addressBook.getId(), addressBook.getName(), addressBook.getPhone(), addressBook.getEmail(), addressBook.getAddress());
    }

    //get all entries
    public List<AddressBookDTO> getAllEntries() {
        log.info("Fetching all address book entries");
        return repository.findAll().stream().map(this::convertToDTO).collect(Collectors.toList());
    }

    //get entity by id
    public AddressBookDTO getEntryById(Long id) {
        log.debug("Fetching address book entry with ID: {}", id);
        Optional<AddressBook> addressBook = repository.findById(id);
        return addressBook.map(this::convertToDTO).orElse(null);
    }

    //add a new entry
    public AddressBookDTO addEntry(AddressBookDTO dto) {
        log.info("Adding new address book entry: {}", dto);
        AddressBook addressBook = new AddressBook(null, dto.getName(), dto.getPhone(), dto.getEmail(), dto.getAddress());
        return convertToDTO(repository.save(addressBook));
    }

    //update an entry
    public AddressBookDTO updateEntry(Long id, AddressBookDTO dto) {
        log.debug("Updating entry with ID: {}", id);
        Optional<AddressBook> addressBookOptional = repository.findById(id);
        if (addressBookOptional.isPresent()) {
            AddressBook addressBook = addressBookOptional.get();
            addressBook.setName(dto.getName());
            addressBook.setPhone(dto.getPhone());
            addressBook.setEmail(dto.getEmail());
            addressBook.setAddress(dto.getAddress());

            log.info("Updated entry: {}", addressBook);
            return convertToDTO(repository.save(addressBook));
        }
        log.warn("Entry with ID {} not found", id);
        return null;
    }

    //delete an entry
    public boolean deleteEntry(Long id) {
        log.debug("Deleting entry with ID: {}", id);
        if (repository.existsById(id)) {
            repository.deleteById(id);
            log.info("Entry with ID {} deleted successfully", id);
            return true;
        }
        log.warn("Entry with ID {} not found", id);
        return false;
    }
}