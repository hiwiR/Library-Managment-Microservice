package com.miu.service;

import com.miu.service.dto.ReviewDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class Reviews {

    private List<ReviewDto> reviews;
}
