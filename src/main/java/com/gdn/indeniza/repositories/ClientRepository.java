package com.gdn.indeniza.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gdn.indeniza.entities.Client;

public interface ClientRepository extends JpaRepository<Client, Long>{

}
