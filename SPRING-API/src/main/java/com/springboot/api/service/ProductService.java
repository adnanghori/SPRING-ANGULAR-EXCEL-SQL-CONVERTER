package com.springboot.api.service;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.springboot.api.helper.ProductExcelHelper;
import com.springboot.api.model.Product;
import com.springboot.api.repository.ProductRepository;

@Service
public class ProductService {
	@Autowired
	private ProductRepository productRepository;
		public void save(MultipartFile file) {
			try {
				List<Product> products = ProductExcelHelper.convert(file.getInputStream());
				this.productRepository.saveAll(products);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		/*Returns list of products as JSON*/
		public List<Product> getAllProduct(){
			List<Product> products = this.productRepository.findAll();
			return products;
		}
	
}
