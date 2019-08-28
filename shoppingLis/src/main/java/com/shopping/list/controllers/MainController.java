package com.shopping.list.controllers;

import com.shopping.list.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {

  ProductService productService;

  @Autowired
  public MainController(ProductService productService) {
    this.productService = productService;
  }

  @RequestMapping("/")
  public String home(){
    return "homepage";
  }

  @RequestMapping("/list")
  public String getList(Model model){
    model.addAttribute("products", productService.getAll());
    return "list";
  }
}
