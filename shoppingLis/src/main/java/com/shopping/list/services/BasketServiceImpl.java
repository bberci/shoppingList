package com.shopping.list.services;

import com.shopping.list.models.Basket;
import com.shopping.list.models.Product;
import com.shopping.list.repositories.BasketRepositories;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BasketServiceImpl implements BasketService {

  BasketRepositories basketRepositories;

  @Autowired
  public BasketServiceImpl(BasketRepositories basketRepositories) {
    this.basketRepositories = basketRepositories;
  }

  @Override
  public Iterable<Basket> getAll() {
    return basketRepositories.findAll();
  }

  @Override
  public void changeIsInTheBasket(int id) {
    basketRepositories.findById(id).get().setInTheBasket(true);
    basketRepositories.save(basketRepositories.findById(id).get());
  }

  @Override
  public void addItemToTheList(String name, int amount, String type) {
    basketRepositories.save(new Basket(name, amount, type));
  }

  @Override
  public void deleteItem(int id) {
    basketRepositories.deleteById(id);
  }
}
