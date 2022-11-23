package com.miu.service;

import com.miu.domain.Book;
import com.miu.domain.BookQuery;
import com.miu.service.dto.BookQueryDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Books {

    private List<BookQueryDto> books;
}
