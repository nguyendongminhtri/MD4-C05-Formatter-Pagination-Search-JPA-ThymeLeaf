package chinh.anh.service;

import chinh.anh.model.Customer;
import chinh.anh.model.Province;

import java.util.Optional;

public interface ICustomerService {
    Iterable<Customer> findAll();
    Optional<Customer> findById(Long id);
    void save(Customer customer);
    Iterable<Customer> findAllByProvince(Province province);
}
