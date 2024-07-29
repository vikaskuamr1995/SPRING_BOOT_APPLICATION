package com.Product.App.Service;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Product.App.Entity.Product;
import com.Product.App.Exception.ExcelDownloadFailed;
import com.Product.App.Reposiotry.ProductReposiotry;
import com.Product.App.Utility.ExcelUtility;

@Service
public class productServiceImpl implements productService {

	@Autowired
	ProductReposiotry productReposiotry;

	@Override
	public void saveProduct(Product product) {

		productReposiotry.save(product);
	}

	@Override
	public List<Product> fetchAllProduct() {

		List<Product> product = productReposiotry.findAll();

		return product;
	}

	@Override
	public ByteArrayInputStream downloadExcel() throws ExcelDownloadFailed, IOException {
		
	List<Product>list=productReposiotry.findAll();
	
	
	   ByteArrayInputStream input= ExcelUtility.excelDownload(list);
	   
	   return input;
	}

}
