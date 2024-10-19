package com.demo.serviceImpl;

import java.util.List;

import com.demo.dao.CustomerDao;
import com.demo.daoImpl.CustomerDaoImpl;
import com.demo.entity.Customer;
import com.demo.service.CustomerService;

public class CustomerServiceImpl implements CustomerService {

    CustomerDao customerDao = new CustomerDaoImpl();

    @Override
    public Customer createCustomer(Customer customer) {
        // Invoke dao method to save customer object
        return customerDao.createCustomer(customer);
    }

    @Override
    public List<Customer> getAllCustomers() {
        // Retrieve all customers
        return customerDao.getAllCustomers();
    }

    @Override
    public Customer getCustomerById(int customerId) {
        // Retrieve customer by ID
        return customerDao.getCustomerById(customerId);
    }

    @Override
    public Customer updateCustomer(int customerId, Customer updatedCustomer) {
        // Update customer details
        return customerDao.updateCustomer(customerId, updatedCustomer);
    }

    @Override
    public String deleteCustomer(int customerId) {
        // Delete customer by ID
        return customerDao.deleteCustomer(customerId);
    }
}
