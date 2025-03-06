package com.javaexpress.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.javaexpress.model.Credential;
import com.javaexpress.model.User;

public interface CredentialRepository extends JpaRepository<Credential,Integer> {

}
