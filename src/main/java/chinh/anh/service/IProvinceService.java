package chinh.anh.service;

import chinh.anh.model.Province;

import java.security.Provider;
import java.util.Optional;

public interface IProvinceService {
    Iterable<Province> findAll();
    Optional<Province> findById(Long id);
    void save(Province province);
    void delete(Long id);
}
