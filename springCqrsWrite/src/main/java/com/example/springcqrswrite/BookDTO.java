package com.example.springcqrswrite;

import lombok.Data;

@Data
public class BookDTO {
    private String title;
    private String author;
    private String category;
    private int pages;
    private int price;
    private String published_date;
    private String description;
}
