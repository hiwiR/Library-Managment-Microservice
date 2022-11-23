package com.miu.data;

import com.miu.domain.Book;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookCommandRepository extends MongoRepository<Book,String> {

}
