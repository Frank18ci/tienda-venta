package org.tienda.tiendavirtualapi.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.tienda.tiendavirtualapi.exception.types.ResourceNotFound;
import org.tienda.tiendavirtualapi.model.Customer;
import org.tienda.tiendavirtualapi.model.dto.CustomerDto;
import org.tienda.tiendavirtualapi.model.utils.mapper.CustomerMapper;
import org.tienda.tiendavirtualapi.repository.CustomerRepository;
import org.tienda.tiendavirtualapi.service.CustomerService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {
    private final CustomerRepository customerRepository;

    @Override
    public List<CustomerDto> getAllCustomers() {
        return CustomerMapper.toDtoList(customerRepository.findAll());
    }

    @Override
    public CustomerDto getCustomerById(Integer id) {
        return CustomerMapper.toDto(customerRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFound("Customer not found with id: " + id)));
    }

    @Override
    public CustomerDto createCustomer(Customer customer) {
        return CustomerMapper.toDto(customerRepository.save(customer));
    }

    @Override
    public CustomerDto updateCustomer(Integer id, Customer customer) {
        Customer existingCustomer = customerRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFound("Customer not found with id: " + id));

        existingCustomer.setCustomerName(customer.getCustomerName());
        existingCustomer.setContactLastName(customer.getContactLastName());
        existingCustomer.setContactFirstName(customer.getContactFirstName());
        existingCustomer.setPhone(customer.getPhone());
        existingCustomer.setAddressLine1(customer.getAddressLine1());
        existingCustomer.setAddressLine2(customer.getAddressLine2());
        existingCustomer.setCity(customer.getCity());
        existingCustomer.setState(customer.getState());
        existingCustomer.setPostalCode(customer.getPostalCode());
        existingCustomer.setCountry(customer.getCountry());
        existingCustomer.setSalesRepEmployeeNumber(customer.getSalesRepEmployeeNumber());
        existingCustomer.setCreditLimit(customer.getCreditLimit());

        return CustomerMapper.toDto(customerRepository.save(existingCustomer));
    }

    @Override
    public void deleteCustomer(Integer id) {
        if (!customerRepository.existsById(id)) {
            throw new ResourceNotFound("Customer not found with id: " + id);
        }
        customerRepository.deleteById(id);
    }
}
