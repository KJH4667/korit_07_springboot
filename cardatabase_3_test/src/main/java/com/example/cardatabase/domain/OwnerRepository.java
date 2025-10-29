package com.example.cardatabase.domain;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


// public class가 아니라 public interface 이다. extends 를 붙이니깐 쓰이는것 같은데...
public interface OwnerRepository extends JpaRepository<Owner, Long> {
    Optional<Owner> findByFirstName(String firstname);
}