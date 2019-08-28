package com.shopping.list.repositories;

import com.shopping.list.models.Basket;
import com.shopping.list.models.Product;
import org.springframework.data.repository.CrudRepository;

public interface BasketRepositories extends CrudRepository<Basket, Integer> {
}
