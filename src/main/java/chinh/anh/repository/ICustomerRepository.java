package chinh.anh.repository;

import chinh.anh.model.Customer;
import chinh.anh.model.Province;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface ICustomerRepository extends PagingAndSortingRepository<Customer, Long> {
    Iterable<Customer> findAllByProvince(Province province);
}
