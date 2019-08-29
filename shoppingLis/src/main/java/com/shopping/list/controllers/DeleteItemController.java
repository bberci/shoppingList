package com.shopping.list.controllers;

import com.shopping.list.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class DeleteItemController {

  ProductService productService;

  @Autowired
  public DeleteItemController(ProductService productService) {
    this.productService = productService;
  }

  @PostMapping("/delete-this")
  public String deleteItem(@RequestParam("dlt") int id){
    productService.deleteItem(id);
    return "redirect:/delete-item";
  }
}
