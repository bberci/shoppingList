package com.shopping.list.controllers;

import com.shopping.list.repositories.BasketRepositories;
import com.shopping.list.repositories.ProductRepository;
import com.shopping.list.services.BasketService;
import com.shopping.list.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class NewController {

  BasketService basketService;
  ProductService productService;

  @Autowired
  public NewController(BasketService basketService, ProductService productService) {
    this.basketService = basketService;
    this.productService = productService;
  }

  @PostMapping("/new-product")
  public String newProduct(@RequestParam("name") String name){
    productService.newProduct(name);
    return "redirect:/";
  }
}
