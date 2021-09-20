package chinh.anh.service.impl;

import chinh.anh.model.Product;
import chinh.anh.repository.IProductRepository;
import chinh.anh.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public class ProductServiceImpl implements IProductService {
    @Autowired
    IProductRepository productRepository;
    @Override
    public Page<Product> findAll(Pageable pageable) {
        return productRepository.findAll(pageable);
    }

    @Override
    public void save(Product product) {
productRepository.save(product);
    }

    @Override
    public Page<Product> findAllByNameContaining(String name, Pageable pageable) {
        return productRepository.findAllByNameContaining(name,pageable);
    }

    @Override
    public Page<Product> findByNameProduct(String name, Pageable pageable) {
        return productRepository.findByNameProduct(name,pageable);
    }
}
