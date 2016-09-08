package com.learn.springdata.mysql;

import com.learn.springdata.mysql.dao.Customer;
import com.learn.springdata.mysql.dao.CustomerRepository;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import java.util.List;

public class CustomerApp {
    public static void main(String[] args) {
        AbstractApplicationContext context = new AnnotationConfigApplicationContext(DataProvider.class);
        CustomerRepository repository = context.getBean(CustomerRepository.class);

        repository.save(new Customer("Jack", "Bauer"));
        repository.save(new Customer("Chloe", "O'Brian"));

        Iterable<Customer> customers = repository.findAll();
        System.out.println("Customer found with findAll():");
        System.out.println("--------------------------------------------");
        for (Object customer : customers) {
            System.out.println(customer);
        }

        List<Customer> jacks = repository.findByName("Jack");
        System.out.println("Customer found with findByName('Jack'):");
        System.out.println("--------------------------------------------");
        for (Customer c : jacks) {
            System.out.println(c);
        }

        context.close();
    }
}
