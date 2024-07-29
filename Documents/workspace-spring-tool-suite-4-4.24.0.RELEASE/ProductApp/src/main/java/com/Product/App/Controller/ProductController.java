package com.Product.App.Controller;

import java.io.ByteArrayInputStream;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.Product.App.Entity.Product;
import com.Product.App.Service.productService;

@RestController
@RequestMapping("/app")
public class ProductController {

	@Autowired
	productService productServices;

	@PostMapping("/save")
	public ResponseEntity<?> saveProducts(@RequestBody Product product) {

		productServices.saveProduct(product);

		return new ResponseEntity<>("Product saved sucessfully", HttpStatus.CREATED);
	}

	@GetMapping("/fetch")
	public ResponseEntity<?> fetchProducts() {

		return new ResponseEntity<>(productServices.fetchAllProduct(), HttpStatus.OK);
	}
	
	
	@GetMapping("/download")
    private ResponseEntity<InputStreamResource> download() throws IOException {
          String fileName ="products.xlsx";
         ByteArrayInputStream inputStream = productServices.downloadExcel();
         InputStreamResource    response = new InputStreamResource(inputStream);

         ResponseEntity<InputStreamResource> responseEntity = ResponseEntity.ok()
                 .header(HttpHeaders.CONTENT_DISPOSITION,"attachment;filename="+fileName)
                 .contentType(MediaType.parseMediaType("application/vnd.ms-excel")).body(response);
         return responseEntity;
    }
}
