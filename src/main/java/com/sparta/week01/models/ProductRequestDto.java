package com.sparta.week01.models;


import lombok.Getter;

@Getter
public class ProductRequestDto {
    // title, link, image, lprice
    private String title;
    private String link;
    private String image;
    private int lprice;
}
