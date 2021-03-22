package com.sparta.week01.service;

import com.sparta.week01.domain.Product;
import com.sparta.week01.domain.ProductRepository;
import com.sparta.week01.models.ItemDto;
import com.sparta.week01.models.ProductMypriceRequestDto;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ProductService {
    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Transactional
    public void update(Long id, ProductMypriceRequestDto mypriceRequestDto) {
        Product product = productRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("아이디가 없습니다.")
        );

        product.update(mypriceRequestDto);
    }
    @Transactional
    public void updateBySearch(Long id, ItemDto itemDto) {
        Product findProduct = productRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("해당 아이디가 없습니다."));
        findProduct.updateByItemDto(itemDto);
    }


}
