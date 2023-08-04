package com.example.apoorpoor_backend.dto.account;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.ConstructorExpression;
import javax.annotation.processing.Generated;

/**
 * com.example.apoorpoor_backend.dto.account.QAccountTotalResponseDto is a Querydsl Projection type for AccountTotalResponseDto
 */
@Generated("com.querydsl.codegen.DefaultProjectionSerializer")
public class QAccountTotalResponseDto extends ConstructorExpression<AccountTotalResponseDto> {

    private static final long serialVersionUID = -971692750L;

    public QAccountTotalResponseDto(com.querydsl.core.types.Expression<String> day, com.querydsl.core.types.Expression<Long> expenditure_sum, com.querydsl.core.types.Expression<Long> income_sum) {
        super(AccountTotalResponseDto.class, new Class<?>[]{String.class, long.class, long.class}, day, expenditure_sum, income_sum);
    }

}

