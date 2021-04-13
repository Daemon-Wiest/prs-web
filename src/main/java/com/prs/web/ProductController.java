package com.prs.web;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.prs.business.Product;
import com.prs.db.ProductRepo;

@CrossOrigin
@RestController
@RequestMapping("/api/Products")
public class ProductController {
	@Autowired
	private ProductRepo ProductRepo;
	
	@GetMapping("/")
	public List<Product> getAll(){
		return ProductRepo.findAll();
	}
	@GetMapping("/{id}")
	public Product getById(@PathVariable int id){
		return ProductRepo.findById(id).get();
	}
	
	@PostMapping("/")
	public Product create(@RequestBody Product Product) {
		return ProductRepo.save(Product);
		
	}
	
	@PutMapping("/")
	public Product update(@RequestBody Product Product) {
		return ProductRepo.save(Product);
		
	}	
	@DeleteMapping("/{id}")
	public Product delete(@PathVariable int id) {
		Optional<Product> Product = ProductRepo.findById(id);
		if (Product.isPresent()) {
			ProductRepo.delete(Product.get());
		}
		else {
			System.out.println("delete error, Product not found for id: "+id);
		}
		return Product.get();
		
	}
	
	
	
}
