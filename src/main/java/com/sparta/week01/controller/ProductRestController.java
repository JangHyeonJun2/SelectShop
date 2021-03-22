package com.sparta.week01.controller;

import com.sparta.week01.domain.Product;
import com.sparta.week01.domain.ProductRepository;
import com.sparta.week01.models.ProductMypriceRequestDto;
import com.sparta.week01.models.ProductRequestDto;
import com.sparta.week01.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//@RequiredArgsConstructor // final로 선언된 멤버 변수를 자동으로 생성합니다.
@RestController // JSON으로 데이터를 주고받음을 선언합니다.
public class ProductRestController {

    private final ProductRepository productRepository;
    private final ProductService productService;

    public ProductRestController(ProductRepository productRepository, ProductService productService) {
        this.productRepository = productRepository;
        this.productService = productService;
    }



    // 등록된 전체 상품 목록 조회
    @GetMapping("/api/products")
    public List<Product> getProducts() {
        return productRepository.findAll();
    }

    @PostMapping("/api/products")
    public Product createProducts(@RequestBody ProductRequestDto requestDto) {
        Product product = new Product(requestDto);
        return productRepository.save(product);
    }

    @PutMapping("/api/products/{targetId}")
    public void updateLprice(@PathVariable Long targetId, @RequestBody ProductMypriceRequestDto productMypriceRequestDto) {
        productService.update(targetId,productMypriceRequestDto);
    }

}
