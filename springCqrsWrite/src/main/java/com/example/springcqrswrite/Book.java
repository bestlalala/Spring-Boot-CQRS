package com.example.springcqrswrite;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;


//이 클래스가 데이터베이스 와 연동되는 클래스라는 것을 명시
@Entity
//테이블 이름
@Table(name="book")
//인스턴스 출력할 때 사용할 메서드
@ToString
//접근자 메서드
@Getter
//생성자를 이용해서 값을 대입하지 않고 .을 이용해서 메서드를 연속적으로 호출해서 값 설정
@Builder
//모든 속성을 대입받아서 생성하는 생성자
@AllArgsConstructor
//매개변수 없는 생성자를 생성
@NoArgsConstructor
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long bid;
    @Column(length = 50, nullable = false)
    private String title;
    @Column(length = 50, nullable = false)
    private String author;
    @Column(length = 50, nullable = false)
    private String category;
    @Column
    private int pages;
    @Column
    private int price;
    @Column
    private Date published_Date;
    @Column(length = 50, nullable = false)
    private String description;


}
