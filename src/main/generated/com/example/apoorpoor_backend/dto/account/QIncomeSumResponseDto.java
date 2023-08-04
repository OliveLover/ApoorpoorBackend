package com.example.apoorpoor_backend.dto.account;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.ConstructorExpression;
import javax.annotation.processing.Generated;

/**
 * com.example.apoorpoor_backend.dto.account.QIncomeSumResponseDto is a Querydsl Projection type for IncomeSumResponseDto
 */
@Generated("com.querydsl.codegen.DefaultProjectionSerializer")
public class QIncomeSumResponseDto extends ConstructorExpression<IncomeSumResponseDto> {

    private static final long serialVersionUID = 2127143825L;

    public QIncomeSumResponseDto(com.querydsl.core.types.Expression<String> month, com.querydsl.core.types.Expression<Long> income_sum) {
        super(IncomeSumResponseDto.class, new Class<?>[]{String.class, long.class}, month, income_sum);
    }

}

