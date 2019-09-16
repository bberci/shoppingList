package com.shopping.list.repositories;

import com.shopping.list.models.Basket;
import org.springframework.data.repository.CrudRepository;

public interface BasketRepository extends CrudRepository<Basket, Integer> {

  boolean existsByAmount();
  boolean existsByName(String name);
}
