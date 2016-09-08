package com.learn.springdata.mysql.dao;

import com.learn.springdata.mysql.dao.Customer;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CustomerRepository extends CrudRepository<Customer, Long> {
    List<Customer> findByName(String name);
}