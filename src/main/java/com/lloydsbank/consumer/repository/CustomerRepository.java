package com.lloydsbank.consumer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lloydsbank.consumer.model.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

}
