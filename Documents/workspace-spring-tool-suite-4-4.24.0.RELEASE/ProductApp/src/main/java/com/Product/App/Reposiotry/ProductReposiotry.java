package com.Product.App.Reposiotry;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Product.App.Entity.Product;

public interface ProductReposiotry extends JpaRepository<Product, Long> {

}
