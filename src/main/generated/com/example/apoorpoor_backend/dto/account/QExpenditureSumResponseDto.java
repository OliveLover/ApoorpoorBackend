package com.example.apoorpoor_backend.dto.account;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.ConstructorExpression;
import javax.annotation.processing.Generated;

/**
 * com.example.apoorpoor_backend.dto.account.QExpenditureSumResponseDto is a Querydsl Projection type for ExpenditureSumResponseDto
 */
@Generated("com.querydsl.codegen.DefaultProjectionSerializer")
public class QExpenditureSumResponseDto extends ConstructorExpression<ExpenditureSumResponseDto> {

    private static final long serialVersionUID = 781013021L;

    public QExpenditureSumResponseDto(com.querydsl.core.types.Expression<String> month, com.querydsl.core.types.Expression<Long> expenditure_sum) {
        super(ExpenditureSumResponseDto.class, new Class<?>[]{String.class, long.class}, month, expenditure_sum);
    }

}

