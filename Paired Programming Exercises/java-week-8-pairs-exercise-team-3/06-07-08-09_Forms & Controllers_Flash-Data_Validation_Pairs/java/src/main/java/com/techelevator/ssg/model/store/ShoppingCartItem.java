package com.techelevator.ssg.model.store;

public class ShoppingCartItem {
  
  Product item;
  int     quantity;
  
public Product getItem() {
	return item;
}
public void setItem(Product item) {
	this.item = item;
}
public int getQuantity() {
	return quantity;
}
public void setQuantity(int quantity) {
	this.quantity = quantity;
}
@Override
public String toString() {
	return "ShoppingCartItem [item=" + item + ", quantity=" + quantity + "]";
}
  
  
}
