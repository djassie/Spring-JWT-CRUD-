package com.example.auth.repositories;

import com.example.auth.entities.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface AddressRepository extends JpaRepository<Address, Integer> {
    @Query("select a from Address a where a.user =: id")
    Optional<List<Address>> findAddressByUserId(int id);

    List<Address> findByUserId(int id);
}
