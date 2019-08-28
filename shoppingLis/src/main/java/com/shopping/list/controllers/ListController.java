package com.shopping.list.controllers;

import com.shopping.list.services.BasketService;
import com.shopping.list.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ListController {

  ProductService productService;
  BasketService basketService;

  @Autowired
  public ListController(ProductService productService, BasketService basketService) {
    this.productService = productService;
    this.basketService = basketService;
  }

  @PostMapping("/basket")
  public String inTheBasket(@RequestParam("done") int id){
    basketService.changeIsInTheBasket(id);
    return "redirect:/list";
  }

  @RequestMapping("/clean-list")
  public String cleanList(){
    basketService.deleteAll();
    return "redirect:/list";
  }
}
