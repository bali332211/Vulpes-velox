package com.vulpes.velox.services;

import com.vulpes.velox.models.Product;

public interface ProductService {

  void save(Product product);

  void deleteAll();

  boolean existsByName(String name);

  Product getByName(String name);

}
