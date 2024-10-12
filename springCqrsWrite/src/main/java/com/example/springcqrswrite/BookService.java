package com.example.springcqrswrite;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;

@Service
@RequiredArgsConstructor
//django 에서는 views.py 파일의 역할
public class BookService {
    private final BookRepository bookRepository;

    //데이터 저장
    //파라미터를 받아서 엔티티를 생성하고 repository를 이용해서 삽입
    public void saveBook(BookDTO bookDTO){
        try {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
            //ParseException 처리를 강제합니다.
            Date published_date = simpleDateFormat.parse(bookDTO.getPublished_date());
            //빌더 패턴을 이용한 Entity 생성
            Book book = Book.builder().
                    title(bookDTO.getTitle()).
                    author(bookDTO.getAuthor()).
                    category(bookDTO.getCategory()).
                    pages(bookDTO.getPages()).
                    price(bookDTO.getPrice()).
                    published_Date(published_date).
                    description(bookDTO.getDescription()).
                    build();
            //데이터베이스에 데이터 삽입
            bookRepository.save(book);
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }

    }
}

