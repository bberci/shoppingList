package com.shopping.list.controllers;

import com.shopping.list.services.BasketService;
import com.shopping.list.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AddController {

  BasketService basketService;
  ProductService productService;

  @Autowired
  public AddController(BasketService basketService, ProductService productService) {
    this.basketService = basketService;
    this.productService = productService;
  }

  @PostMapping("/add-to-basket")
  public String AddToList(Model model, @RequestParam("name") String name, @RequestParam("amount") int amount, @RequestParam("type") String type) {
    if (basketService.checkTheAmount(amount)) {
      model.addAttribute("products", productService.notInTheList());
      model.addAttribute("items", basketService.getAll());
      model.addAttribute("amount", "Nincs megadott mennyiség.");
      return "addtolist";
    } else {
      basketService.addItemToTheList(name, amount, type);
    }
      return "redirect:/add";
  }

  @PostMapping("/delete")
  public String deleteItem(@RequestParam("delete") int id){
    basketService.deleteItem(id);
    return "redirect:/add";
  }

  @RequestMapping("/back")
  public String backToHome(){
    return "redirect:/";
  }
}
