package com.vulpes.velox.services.bulkproductservice;

import com.vulpes.velox.dtos.ProductDto;
import com.vulpes.velox.models.products.BulkProduct;
import com.vulpes.velox.repositories.BulkProductRepository;
import com.vulpes.velox.services.methodservice.MethodService;
import com.vulpes.velox.services.productservice.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.math.BigInteger;
import java.util.List;
import java.util.Map;

@Service
public class BulkProductServiceImpl implements BulkProductService {

  private BulkProductRepository bulkProductRepository;
  private ProductService productService;
  private MethodService methodService;

  @Autowired
  public BulkProductServiceImpl(BulkProductRepository bulkProductRepository,
                                ProductService productService,
                                MethodService methodService) {
    this.bulkProductRepository = bulkProductRepository;
    this.productService = productService;
    this.methodService = methodService;
  }

  @Override
  public List<BulkProduct> getAll() {
    return bulkProductRepository.findAll();
  }

  @Override
  public BulkProduct getEntityFromDto(ProductDto productDto) {
    BulkProduct bulkProduct = new BulkProduct();
    bulkProduct.setName(productDto.name);
    bulkProduct.setQuantity(productDto.quantity);
    return bulkProduct;
  }

  @Override
  public boolean existsByName(String name) {
    return bulkProductRepository.existsByName(name);
  }

  @Override
  public Map<String, ?> getErrorFlashAttributes(BulkProduct bulkProduct, RedirectAttributes redirectAttributes) {
    return methodService.getNameErrorAttributes(
        bulkProduct,
        redirectAttributes,
        "bulkProductError");
  }

  @Override
  public Map<String, ?> getNewBulkProductFlashAttributes(BulkProduct bulkProduct, RedirectAttributes redirectAttributes) {
    redirectAttributes.addFlashAttribute("savedBulkProduct", true);
    redirectAttributes.addFlashAttribute("bulkProductName", bulkProduct.getName());
    return redirectAttributes.getFlashAttributes();
  }

  @Override
  public List<BulkProduct> getAllFilteredBy(String filter) {
    return bulkProductRepository.findAllByNameContaining(filter);
  }

  @Override
  public void saveNewBulkProduct(BulkProduct bulkProduct, String unit) {
    bulkProduct.setQuantity((long) 0);
    bulkProduct.setPrice((long) 0);
    bulkProduct.setValue(BigInteger.valueOf(0));
    bulkProduct.setUnit(unit);
    productService.save(bulkProduct);
  }

}
