package com.miu.integration;

import com.miu.service.dto.BookDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookCommandEvent {

    private String action;
    private BookDto bookDto;
}
