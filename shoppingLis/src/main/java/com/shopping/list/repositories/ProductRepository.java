package com.shopping.list.repositories;

import com.shopping.list.models.Product;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface ProductRepository extends CrudRepository<Product, Integer> {
  Optional<Product> findByName(String name);
  void deleteById(int id);
}
