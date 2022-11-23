package com.miu.service;

import com.miu.domain.Borrowing;
import com.miu.service.dto.BorrowingDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class Borrowings {

    private List<BorrowingDto> borrowingDto;
}

