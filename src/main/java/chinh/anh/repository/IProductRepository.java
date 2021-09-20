package chinh.anh.repository;

import chinh.anh.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

public interface IProductRepository extends PagingAndSortingRepository<Product, Long> {
    // 2 cách này tương đương nhau, 1 dùng Hàm có sẵn, 2 dùng Query
    Page<Product> findAllByNameContaining(String name, Pageable pageable);
    @Query("SELECT p FROM Product AS p WHERE p.name LIKE CONCAT('%',:name,'%')")
    Page<Product> findByNameProduct(@Param("name") String name, Pageable pageable);
}
