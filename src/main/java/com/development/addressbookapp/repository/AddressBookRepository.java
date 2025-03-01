package com.development.addressbookapp.repository;

import com.development.addressbookapp.entity.AddressBook;
import org.springframework.data.jpa.repository.JpaRepository;


public interface AddressBookRepository extends JpaRepository<AddressBook, Long> {
}
