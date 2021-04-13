package com.prs.web;

import java.util.List;
import java.util.Optional;

import com.prs.business.LineItem;
import com.prs.business.Request;
import com.prs.business.Product;
import com.prs.db.LineItemRepo;
import com.prs.db.ProductRepo;
import com.prs.db.RequestRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@CrossOrigin
	@RestController
	@RequestMapping("/api/lineitems")
public class LineItemController {
		@Autowired
		private LineItemRepo LineItemRepo;
		@Autowired
		private RequestRepo RequestRepo;
		@Autowired
		private ProductRepo ProductRepo;
		
		@GetMapping("/")
		public List<LineItem> getAll() {
			return LineItemRepo.findAll();
		}

		@GetMapping("/{id}")
		public LineItem getById(@PathVariable int id) {
			return LineItemRepo.findById(id).get();
		}
		
		@PostMapping("/")
		public LineItem create(@RequestBody LineItem LineItem) {
			return LineItemRepo.save(LineItem);
		}
		
		@PutMapping("/")
		public LineItem update(@RequestBody LineItem LineItem) {
			return LineItemRepo.save(LineItem);
		}
		
		@DeleteMapping("/{id}")
		public LineItem update(@PathVariable int id) {
			Optional<LineItem> LineItem = LineItemRepo.findById(id);
			if (LineItem.isPresent()) {
				LineItemRepo.delete(LineItem.get());
			}
			else {
				System.out.println("Delete Error - LineItem not found for id: "+id);
			}
			return LineItem.get();
		}

		@GetMapping("/line-items/lines-for-pr/{id}")
		public List<LineItem> getPrLines(@RequestBody LineItem li) {
			//Request r = li.getRequest(); could declare it a variable, useful for multiple functions, more likely just unnecessary for future use
			List<LineItem> lipr = LineItemRepo.findByRequestId(li.getRequest());
			
			 return lipr;
		}
		
}
