package org.tienda.tiendavirtualapi.service;

import org.tienda.tiendavirtualapi.model.Customer;
import org.tienda.tiendavirtualapi.model.dto.CustomerDto;

import java.util.List;

public interface CustomerService {
    List<CustomerDto> getAllCustomers();
    CustomerDto getCustomerById(Integer id);
    CustomerDto createCustomer(Customer customer);
    CustomerDto updateCustomer(Integer id, Customer customer);
    void deleteCustomer(Integer id);
}
