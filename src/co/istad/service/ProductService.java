package co.istad.service;

import co.istad.model.Product;

import java.util.List;
import java.util.Optional;

public interface ProductService {
    // CRUD = Create, Read, Update, Delete
    Product insert(Product product);

    List<Product> select();
    Optional<Product> selectById(long id);

    Product updateById(Product product);
    Product deleteById(long id);
    List <Product> searchByName(String name);
}
