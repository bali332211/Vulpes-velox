package com.vulpes.velox.services;

import com.vulpes.velox.models.BulkProduct;
import com.vulpes.velox.repositories.BulkProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BulkProductServiceImpl implements BulkProductService {

  private BulkProductRepository bulkProductRepository;

  @Autowired
  public BulkProductServiceImpl(BulkProductRepository bulkProductRepository) {
    this.bulkProductRepository = bulkProductRepository;
  }

  @Override
  public List<BulkProduct> getAll() {
    return bulkProductRepository.findAll();
  }
}