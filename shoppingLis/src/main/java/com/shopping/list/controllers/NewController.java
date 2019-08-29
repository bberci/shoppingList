package com.shopping.list.controllers;

import com.shopping.list.services.BasketService;
import com.shopping.list.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
  public String newProduct(@RequestParam("name") String name, Model model){
    if(productService.existsInTheList(name)){
      model.addAttribute("exists", "Már van ilyen elem az áruk listájában, vagy üresen maradt a mező!");
      return "newproduct";
    }
    productService.newProduct(name);
    model.addAttribute("exists", "Áru mentve az adatbázisba!");
    return "newproduct";
  }
}
