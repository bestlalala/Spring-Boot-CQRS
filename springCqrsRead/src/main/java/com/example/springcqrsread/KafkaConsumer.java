package com.example.springcqrsread;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import org.json.JSONObject;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumer {

    @KafkaListener(topics = "cqrs-topic", groupId = "youaresoft")
    public void consume(String message) throws Exception{
        //JSON 문자열을 객체로 변환
        JSONObject messageObj = new JSONObject(message);
        //MongoDB에 삽입
        MongoClient mongoClient = MongoClients.create("mongodb://localhost:27017");
        //컬렉션 연결
        MongoDatabase mongoDatabase = mongoClient.getDatabase("springcqrs");
        MongoCollection<Document> mongo_books = mongoDatabase.getCollection("books");

        //받은 데이터를 가지고 Document를 만들어서 MongoDB에 삽입
        Document mongoBook = new Document();

        mongoBook.append("bid", messageObj.getLong("bid"));
        mongoBook.append("title", messageObj.getString("title"));
        mongoBook.append("author", messageObj.getString("author"));
        mongoBook.append("category", messageObj.getString("category"));
        mongoBook.append("pages", messageObj.getInt("pages"));
        mongoBook.append("price", messageObj.getInt("price"));
        mongoBook.append("published_date", messageObj.getString("published_date"));
        mongoBook.append("description", messageObj.getString("description"));

        mongo_books.insertOne(mongoBook);

        mongoClient.close();

    }
}

