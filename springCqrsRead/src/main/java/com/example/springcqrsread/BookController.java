package com.example.springcqrsread;

import com.mongodb.client.*;
import org.bson.Document;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class BookController {

    @GetMapping("/cqrs/book")
    public ResponseEntity<List> getBooks(){
        MongoClient mongoClient = MongoClients.create("mongodb://localhost:27017");
        //컬렉션 연결
        MongoDatabase mongoDatabase = mongoClient.getDatabase("springcqrs");
        MongoCollection<Document> mongo_books = mongoDatabase.getCollection("books");

        List<Document> list = new ArrayList<Document>();
        try{
            try(MongoCursor<Document> cur = mongo_books.find().iterator()){
                while (cur.hasNext()){
                    Document doc = cur.next();
                    list.add(doc);
                }
            }
        }catch(Exception e){
            System.out.println(e.getMessage());
        }finally{
            mongoClient.close();
        }
        return ResponseEntity.status(HttpStatus.OK).body(list);
    }
}
