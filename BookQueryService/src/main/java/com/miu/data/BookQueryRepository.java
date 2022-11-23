package com.miu.data;

import com.miu.domain.BookQuery;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookQueryRepository extends MongoRepository<BookQuery,String> {
}
