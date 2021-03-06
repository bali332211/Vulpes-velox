package com.vulpes.velox.controllers;

import com.vulpes.velox.models.OrderedProduct;
import com.vulpes.velox.services.orderedproductservice.OrderedProductService;
import com.vulpes.velox.services.orderservice.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class OrderedProductController {

  private OrderedProductService orderedProductService;
  private OrderService orderService;

  @Autowired
  public OrderedProductController(OrderedProductService orderedProductService, OrderService orderService) {
    this.orderedProductService = orderedProductService;
    this.orderService = orderService;
  }

  @GetMapping("/order/{orderName}")
  public String addOrderedProducts(@PathVariable(value = "orderName") String orderName,
                                   @ModelAttribute(value = "orderedProductNew") OrderedProduct orderedProduct,
                                   Model model) {
    model.addAttribute("orderedProducts", orderedProductService.getAllByOrder(orderService.getByName(orderName)));
    model.addAttribute("orderName", orderName);
    return "addOrderedProducts";
  }

  @PostMapping("/ordered-product/{orderName}/add")
  public String addOrderedProduct(@PathVariable(value = "orderName") String orderName,
                                  @ModelAttribute(value = "orderedProductNew") OrderedProduct orderedProduct,
                                  RedirectAttributes redirectAttributes) {
    orderedProduct.setOrder(orderService.getByName(orderName));
    orderedProductService.save(orderedProduct);

    redirectAttributes.addAttribute("orderName", orderName);
    return "redirect:/order/{orderName}";
  }
}
