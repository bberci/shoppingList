package com.shopping.list.controllers;

import com.shopping.list.services.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ListController {

  ProductService productService;

  @RequestMapping("/basket")
  public String inTheBasket(@RequestParam("done") int id){
    productService.changeIsInTheBasket(id);
    return "redirect:/list";
  }
}
