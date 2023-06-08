package org.example;

import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = { "*" })
@RequestMapping(value = "/", produces = "application/json; charset=utf-8")
class ProductController {

  private final ProductRepository repository;

  ProductController(ProductRepository repository) {
    this.repository = repository;
  }

  @PostMapping("/products")
  ProductEvent newProduct(@RequestBody ProductEvent newProduct) {
    repository.save(newProduct);
    return newProduct;
  }
}