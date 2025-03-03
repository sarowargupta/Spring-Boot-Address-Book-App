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

    //Section:-02 Handling AddressBook DTO and Model in Address book Service layer
    //UC-02 Introducing Service layer in Address Book app

    @Autowired
    private AddressBookRepository repository;

    //get all entries
    public List<AddressBookDTO> getAllEntries() {
        return repository.findAll()
                .stream()
                .map(entry -> new AddressBookDTO(entry.getName(), entry.getPhone()))
                .collect(Collectors.toList());
    }

    //get entry by id
    public Optional<AddressBookDTO> getEntryById(Long id) {
        return repository.findById(id)
                .map(entry -> new AddressBookDTO(entry.getName(), entry.getPhone()));
    }

    //add new entry
    public AddressBook addEntry(AddressBookDTO dto) {
        AddressBook entry = new AddressBook();
        entry.setName(dto.getName());
        entry.setPhone(dto.getPhone());
        return repository.save(entry);
    }

    //update entry by id
    public AddressBook updateEntry(Long id, AddressBookDTO dto) {
        return repository.findById(id).map(entry -> {
            entry.setName(dto.getName());
            entry.setPhone(dto.getPhone());
            return repository.save(entry);
        }).orElseThrow(() -> new RuntimeException("Entry not found with id: " + id));
    }

    //delete entry by id
    public void deleteEntry(Long id) {
        repository.deleteById(id);
    }

}
