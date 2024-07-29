package com.Product.App.Service;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.List;

import com.Product.App.Entity.Product;
import com.Product.App.Exception.ExcelDownloadFailed;

public interface productService {

	public void saveProduct(Product product);
	
	
	List<Product>fetchAllProduct();
	
	
	ByteArrayInputStream downloadExcel() throws ExcelDownloadFailed, IOException;
}
