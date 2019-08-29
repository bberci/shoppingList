package com.shopping.list.services;

import com.shopping.list.models.Basket;
import com.shopping.list.repositories.BasketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BasketServiceImpl implements BasketService {

  BasketRepository basketRepository;

  @Autowired
  public BasketServiceImpl(BasketRepository basketRepository) {
    this.basketRepository = basketRepository;
  }

  @Override
  public Iterable<Basket> getAll() {
    return basketRepository.findAll();
  }

  @Override
  public void changeIsInTheBasket(int id) {
    basketRepository.findById(id).get().setInTheBasket(true);
    basketRepository.save(basketRepository.findById(id).get());
  }

  @Override
  public void addItemToTheList(String name, int amount, String type) {
    basketRepository.save(new Basket(name, amount, type));
  }

  @Override
  public void deleteItem(int id) {
    basketRepository.deleteById(id);
  }

  @Override
  public void deleteAll() {
    basketRepository.deleteAll();
  }

  @Override
  public boolean checkTheAmount(int amount) {
    if(amount <= 0){
      return true;
    }
    return false;
  }
}
