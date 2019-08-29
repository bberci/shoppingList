package com.shopping.list.services;

import com.shopping.list.models.Product;
import com.shopping.list.repositories.BasketRepository;
import com.shopping.list.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService {

  ProductRepository productRepository;
  BasketRepository basketRepository;

  @Autowired
  public ProductServiceImpl(ProductRepository productRepository, BasketRepository basketRepository) {
    this.productRepository = productRepository;
    this.basketRepository = basketRepository;
  }

  @Override
  public Iterable<Product> getAll() {
    return productRepository.findAll();
  }

  public void newProduct(String name){
    productRepository.save(new Product(name.toLowerCase()));
  }

  @Override
  public boolean existsInTheList(String name) {
    if(name.equals("") || productRepository.findByName(name.toLowerCase()).isPresent()){
      return true;
    }
    return false;
  }

  @Override
  public List<Product> notInTheList() {
    List<Product> notInTheList = new ArrayList<>();
    productRepository.findAll().iterator().forEachRemaining(notInTheList::add);
    for (int i = 0; i < notInTheList.size(); i++) {
      if(basketRepository.existsByName(notInTheList.get(i).getName())){
        notInTheList.remove(i);
      }
    }
    return notInTheList.stream().sorted((x, y) -> x.getName().compareTo(y.getName())).collect(Collectors.toList());
  }

  @Override
  public void deleteItem(int id) {
    productRepository.deleteById(id);
  }
}
