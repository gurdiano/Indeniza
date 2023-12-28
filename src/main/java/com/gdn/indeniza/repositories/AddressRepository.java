package com.gdn.indeniza.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gdn.indeniza.entities.Address;

public interface AddressRepository extends JpaRepository<Address, Long>{

}
