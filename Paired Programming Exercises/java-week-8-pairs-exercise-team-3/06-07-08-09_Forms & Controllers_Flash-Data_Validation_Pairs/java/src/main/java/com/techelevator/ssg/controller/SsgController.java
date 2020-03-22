package com.techelevator.ssg.controller;

import java.awt.event.ItemEvent;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.techelevator.ssg.model.calculator.AlienAgeCalculator;
import com.techelevator.ssg.model.calculator.AlienWeightCalculator;
import com.techelevator.ssg.model.store.Product;
import com.techelevator.ssg.model.store.ProductDao;
import com.techelevator.ssg.model.store.ShoppingCartItem;

@Controller
public class  SsgController {

	@Autowired               // Tell Spring MVC to automatically connect to the dataSource
	ProductDao theProducts;
	
	List<ShoppingCartItem> shoppingCart = new ArrayList<ShoppingCartItem>();
	
	
	@RequestMapping("/")
	public String displayHomePage() {
	
		return "homePage";
	}
	
	
	
	@RequestMapping("/alienTravelInput")
	public String displayAlienTravelInput() {
		
		return "alienTravelInput"; // name of jsp
	}
	
	
	@RequestMapping("/store")
	public String displayStoreHomePage(ModelMap productMap) {
		
		List<Product> allProducts = theProducts.getAllProducts();// Load all the products from database into a List
		productMap.put("products", allProducts);    // Put the product list in a map so teh jsp can access it
		  
		return "geekMart";  // name of jsp
	}
	@RequestMapping(path="/productDetail", method=RequestMethod.GET)
	public String displayProductDetail(@RequestParam Long id, ModelMap map) {
		
		Product aProduct = theProducts.getProductById(id);
		map.put("product",aProduct);
		
		return "productDetail";
	}
	
	@RequestMapping(path="/shoppingCart",  method=RequestMethod.POST)
	public String displayProductForSale(@RequestParam int quantity
			                           ,@RequestParam Long id
			                           ,HttpSession sessionMap) {
		
		
		ShoppingCartItem anItem = new ShoppingCartItem();
		anItem.setQuantity(quantity);
		anItem.setItem(theProducts.getProductById(id));
		
		shoppingCart.add(anItem);
		
		sessionMap.setAttribute("cart",shoppingCart);
		
		return "shoppingCart";
	}
	
	
	
	

}
