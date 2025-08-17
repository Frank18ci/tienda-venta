package org.tienda.tiendavirtualapi.model.utils.mapper;

import org.tienda.tiendavirtualapi.model.Customer;
import org.tienda.tiendavirtualapi.model.dto.CustomerDto;

import java.util.List;

public class CustomerMapper {
    public static CustomerDto toDto(Customer customer) {
        return CustomerDto.builder()
                .customerNumber(customer.getCustomerNumber())
                .customerName(customer.getCustomerName())
                .contactLastName(customer.getContactLastName())
                .contactFirstName(customer.getContactFirstName())
                .phone(customer.getPhone())
                .addressLine1(customer.getAddressLine1())
                .addressLine2(customer.getAddressLine2())
                .city(customer.getCity())
                .state(customer.getState())
                .postalCode(customer.getPostalCode())
                .country(customer.getCountry())
                .salesRepEmployeeNumber(EmployeMapper.toDto(customer.getSalesRepEmployeeNumber()))
                .creditLimit(customer.getCreditLimit())
                .build();
    }
    public static List<CustomerDto> toDtoList(List<Customer> customers) {
        return customers.stream().map(CustomerMapper::toDto).toList();
    }
}
