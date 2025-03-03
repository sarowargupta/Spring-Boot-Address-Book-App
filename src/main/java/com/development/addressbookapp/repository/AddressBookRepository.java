package com.development.addressbookapp.repository;

import com.development.addressbookapp.model.AddressBook;
import org.springframework.data.jpa.repository.JpaRepository;


public interface AddressBookRepository extends JpaRepository<AddressBook, Long> {
}
