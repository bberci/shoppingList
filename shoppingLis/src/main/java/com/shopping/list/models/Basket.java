package com.shopping.list.models;

import javax.persistence.*;

@Entity
@Table(name = "Basket")
public class Basket {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private int id;
  private String name;
  private int amount;
  private String typeOfAmount;
  private boolean inTheBasket = false;

  public Basket(String name, int amount, String typeOfAmount) {
    this.name = name;
    this.amount = amount;
    this.typeOfAmount = typeOfAmount;
  }

  public Basket() {
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public int getAmount() {
    return amount;
  }

  public void setAmount(int amount) {
    this.amount = amount;
  }

  public String getTypeOfAmount() {
    return typeOfAmount;
  }

  public void setTypeOfAmount(String typeOfAmount) {
    this.typeOfAmount = typeOfAmount;
  }

  public boolean isInTheBasket() {
    return inTheBasket;
  }

  public void setInTheBasket(boolean inTheBasket) {
    this.inTheBasket = inTheBasket;
  }
}
