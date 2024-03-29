package com.shopping.list.services;

import com.shopping.list.models.Basket;

public interface BasketService {

  Iterable<Basket> getAll();
  void changeIsInTheBasket(int id);
  void addItemToTheList(String name, int amount, String type);
  void deleteItem(int id);
  void deleteAll();
  boolean checkTheAmount(int amount);
}
