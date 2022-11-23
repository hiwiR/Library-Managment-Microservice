package com.miu.data;

import com.miu.domain.Borrowing;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BorrowingRepository extends MongoRepository<Borrowing,Integer> {

    List<Borrowing> findAllByCustomernumber(int customerNumber);

    List<Borrowing> findAllByIsbn(String isbn);
}
