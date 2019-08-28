package com.shopping.list.services;

import com.shopping.list.models.Basket;
import com.shopping.list.models.Product;

import java.util.List;

public interface BasketService {

  Iterable<Basket> getAll();
  void changeIsInTheBasket(int id);
  void addItemToTheList(String name, int amount, String type);
  void deleteItem(int id);
}
