package com.shopping.list.services;

import com.shopping.list.models.Product;

import java.util.List;

public interface ProductService {

  Iterable<Product> getAll();
  void newProduct(String name);
  boolean existsInTheList(String name);
  List<Product> notInTheList();
  void deleteItem(int id);
}
