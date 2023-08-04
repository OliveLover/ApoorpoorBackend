package com.example.apoorpoor_backend.dto.account;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.ConstructorExpression;
import javax.annotation.processing.Generated;

/**
 * com.example.apoorpoor_backend.dto.account.QMonthSumResponseDto is a Querydsl Projection type for MonthSumResponseDto
 */
@Generated("com.querydsl.codegen.DefaultProjectionSerializer")
public class QMonthSumResponseDto extends ConstructorExpression<MonthSumResponseDto> {

    private static final long serialVersionUID = 2083639198L;

    public QMonthSumResponseDto(com.querydsl.core.types.Expression<String> month, com.querydsl.core.types.Expression<com.example.apoorpoor_backend.model.enumType.ExpenditureType> expenditureType, com.querydsl.core.types.Expression<Long> month_sum) {
        super(MonthSumResponseDto.class, new Class<?>[]{String.class, com.example.apoorpoor_backend.model.enumType.ExpenditureType.class, long.class}, month, expenditureType, month_sum);
    }

    public QMonthSumResponseDto(com.querydsl.core.types.Expression<String> month, com.querydsl.core.types.Expression<Long> month_sum) {
        super(MonthSumResponseDto.class, new Class<?>[]{String.class, long.class}, month, month_sum);
    }

}

