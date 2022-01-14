package com.mspringjpadata.onetomanyexample;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.mspringjpadata.onetomanyexample.model.Cart;
import com.mspringjpadata.onetomanyexample.model.Items;

@SpringBootApplication
public class OneToManyExampleApplication implements CommandLineRunner{

	@Autowired
	private CartRepository cartRepository;
	
	@Autowired
	private ItemsRepository itemsRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(OneToManyExampleApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		Cart shoppingCart1 = new Cart();
		Items item1 =  new Items();
		item1.setName("Maelk");
		//itemsRepository.save(item1);
		
		Items item2 =  new Items();
		item2.setName("Coffee");
		item2.setCart(shoppingCart1);
		//itemsRepository.save(item2);
		
		shoppingCart1.getItems().add(item1);
		shoppingCart1.getItems().add(item2);

		cartRepository.save(shoppingCart1);
		
		List<Cart> carts =  (List<Cart>)cartRepository.findAll();
		List<Items> ewqeqweqwe =  (List<Items>)itemsRepository.findAll();
		
		
		for (Cart cart : carts) {
			System.out.println("Cart " + cart.getId());
			Set<Items> items = cart.getItems();
		
			for (Items it : items) {
				System.out.println("Item : " + it.getName());
			}
			
		}
	}

}
