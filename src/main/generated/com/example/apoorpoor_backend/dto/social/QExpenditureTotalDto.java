package com.example.apoorpoor_backend.dto.social;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.ConstructorExpression;
import javax.annotation.processing.Generated;

/**
 * com.example.apoorpoor_backend.dto.social.QExpenditureTotalDto is a Querydsl Projection type for ExpenditureTotalDto
 */
@Generated("com.querydsl.codegen.DefaultProjectionSerializer")
public class QExpenditureTotalDto extends ConstructorExpression<ExpenditureTotalDto> {

    private static final long serialVersionUID = 126967085L;

    public QExpenditureTotalDto(com.querydsl.core.types.Expression<String> date, com.querydsl.core.types.Expression<Long> expSum, com.querydsl.core.types.Expression<Long> beggarId) {
        super(ExpenditureTotalDto.class, new Class<?>[]{String.class, long.class, long.class}, date, expSum, beggarId);
    }

}

