package com.example.springcqrswrite;


import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class BookController {
    private final BookService bookService;

    @PostMapping("/cqrs/book")
    public String saveBook(@RequestBody BookDTO bookDTO) {
        bookService.saveBook(bookDTO);
        return "성공";
    }
}
