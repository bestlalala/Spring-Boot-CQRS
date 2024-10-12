package com.example.springcqrswrite;

import org.springframework.data.jpa.repository.JpaRepository;

//Book 테이블에 CRUD 작업을 수행할 수 있는 인스턴스를 만들어서 사용할 수 있도록 해주는 인터페이스
public interface BookRepository extends JpaRepository<Book, Long> {
}
