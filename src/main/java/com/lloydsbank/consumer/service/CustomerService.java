package com.lloydsbank.consumer.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lloydsbank.consumer.model.Customer;
import com.lloydsbank.consumer.repository.CustomerRepository;

@Service
public class CustomerService {
    @Autowired
    private CustomerRepository customerRepository;

    public Customer saveCustomer(Customer customer){
        return customerRepository.save(customer);

    }
     public List<Customer> getAllCustomers(){
        return customerRepository.findAll();

    }
    public Optional<Customer> getCustomerById(Long id){
        return customerRepository.findById(id);
    }
    public void deleteCustomerById(Long id){
        customerRepository.deleteById(id);
    }
    public Customer updateCustomer(Long id, Customer updatedCustomer ){
        Customer existingCustomer = customerRepository.findById(id).orElse(null);
        if(existingCustomer!=null){
           existingCustomer.setName(updatedCustomer.getName());
           existingCustomer.setEmail(updatedCustomer.getEmail());
           existingCustomer.setPhone(updatedCustomer.getPhone());
           existingCustomer.setAddress(updatedCustomer.getAddress());
           return customerRepository.save(existingCustomer);

        }else{
            return null;
        }
    }

}
