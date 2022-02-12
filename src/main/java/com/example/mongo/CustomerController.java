package com.example.mongo;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import javax.websocket.server.PathParam;

@RestController
public class CustomerController {

    private final CustomerRepository repository;

    public CustomerController(CustomerRepository repository) {
        this.repository = repository;
    }

    @PostMapping("customer")
    public Customer create(@RequestParam String firstName, @RequestParam String lastName) {
        return repository.save(new Customer(null, firstName, lastName));
    }

    @GetMapping("customer")
    public List<Customer> findAll() {
        return repository.findAll();
    }

    @GetMapping("customer/firstname/{firstName}")
    public Customer findByFirstName(@PathVariable String firstName) {
        return repository.findByFirstName(firstName);
    }

    @GetMapping("customer/lastname/{lastName}")
    public List<Customer> findByLastName(@PathVariable String lastName) {
        return repository.findByLastName(lastName);
    }

    @DeleteMapping("customer/{id}")
    public void deleteById(@PathVariable String id) {
        repository.deleteById(id);
    }
}
