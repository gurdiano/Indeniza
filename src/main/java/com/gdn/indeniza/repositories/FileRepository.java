package com.gdn.indeniza.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gdn.indeniza.entities.File;

public interface FileRepository extends JpaRepository<File, Long>{

}
