package com.shopping.list.models;

import javax.persistence.*;

@Entity
@Table(name = "Products")
public class Product {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private int id;
  private String name;
  private int amount;
  private String typeOfAmount;

  public Product(String name) {
    this.name = name;
  }

  public Product() {
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

  public void setTypeOfamount(String typeOfamount) {
    this.typeOfAmount = typeOfamount;
  }
}
