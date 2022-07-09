package com.springboot.api.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.springboot.api.helper.ProductExcelHelper;
import com.springboot.api.model.Product;
import com.springboot.api.service.ProductService;

@RestController
@CrossOrigin("*")
public class ProductController {
		@Autowired
		private ProductService productService;
		
		@PostMapping("/product/file")
		public ResponseEntity<?> upload(@RequestParam("file") MultipartFile file) throws InterruptedException{
			Thread.sleep(5000);
			if(ProductExcelHelper.checkFileFormat(file)) {
				
				this.productService.save(file);
				return ResponseEntity.ok(Map.of("message","File Uploaded"));
			}
			else {
				return ResponseEntity.badRequest().body("File Not Mathced");
			}
			
		}
		@GetMapping("/product")
		public List<Product> getAllProducts(){
			return this.productService.getAllProduct();
		}
}
