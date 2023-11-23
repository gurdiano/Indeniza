package com.gdn.indeniza.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gdn.indeniza.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
