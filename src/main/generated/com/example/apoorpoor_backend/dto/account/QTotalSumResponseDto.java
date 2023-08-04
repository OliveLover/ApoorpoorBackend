package com.example.apoorpoor_backend.dto.account;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.ConstructorExpression;
import javax.annotation.processing.Generated;

/**
 * com.example.apoorpoor_backend.dto.account.QTotalSumResponseDto is a Querydsl Projection type for TotalSumResponseDto
 */
@Generated("com.querydsl.codegen.DefaultProjectionSerializer")
public class QTotalSumResponseDto extends ConstructorExpression<TotalSumResponseDto> {

    private static final long serialVersionUID = -1452285598L;

    public QTotalSumResponseDto(com.querydsl.core.types.Expression<com.example.apoorpoor_backend.model.enumType.ExpenditureType> expenditureType, com.querydsl.core.types.Expression<Long> total_sum) {
        super(TotalSumResponseDto.class, new Class<?>[]{com.example.apoorpoor_backend.model.enumType.ExpenditureType.class, long.class}, expenditureType, total_sum);
    }

}

