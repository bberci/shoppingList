package com.shopping.list.services;

import com.shopping.list.models.Product;
import com.shopping.list.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

  ProductRepository productRepository;

  @Autowired
  public ProductServiceImpl(ProductRepository productRepository) {
    this.productRepository = productRepository;
  }

  @Override
  public Iterable<Product> getAll() {
    return productRepository.findAll();
  }

  public void newProduct(String name){
    productRepository.save(new Product(name));
  }
}
