package com.shopping.list.controllers;

import com.shopping.list.services.BasketService;
import com.shopping.list.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {

  ProductService productService;
  BasketService basketService;

  @Autowired
  public MainController(ProductService productService, BasketService basketService) {
    this.productService = productService;
    this.basketService = basketService;
  }


  @RequestMapping("/")
  public String home(){
    return "homepage";
  }

  @RequestMapping("/list")
  public String getList(Model model){
    model.addAttribute("items", basketService.getAll());
    return "list";
  }

  @RequestMapping("/add")
  public String addToList(Model model){
    model.addAttribute("products", productService.notInTheList());
    model.addAttribute("items", basketService.getAll());
    return "addtolist";
  }

  @RequestMapping("/new")
  public String addNewProduct(Model model){
    return "newproduct";
  }

  @RequestMapping("/delete-item")
  public String deleteItem(Model model){
    model.addAttribute("products", productService.getAll());
    return "deleteitem";
  }
}
