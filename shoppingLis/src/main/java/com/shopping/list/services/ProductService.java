package com.shopping.list.services;

import com.shopping.list.models.Product;

import java.util.List;

public interface ProductService {

  Iterable<Product> getAll();
  void changeIsInTheBasket(int id);
}
