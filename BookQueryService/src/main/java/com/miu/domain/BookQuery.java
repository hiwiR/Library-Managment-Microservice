package com.miu.domain;

import com.miu.service.dto.ReviewDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document
public class BookQuery {

    @Id
    private String isbn;
    private String title;
    private String description;
    private String authorName;
    private List<Review> reviews;

}
