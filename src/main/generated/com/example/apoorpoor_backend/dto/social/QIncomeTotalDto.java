package com.example.apoorpoor_backend.dto.social;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.ConstructorExpression;
import javax.annotation.processing.Generated;

/**
 * com.example.apoorpoor_backend.dto.social.QIncomeTotalDto is a Querydsl Projection type for IncomeTotalDto
 */
@Generated("com.querydsl.codegen.DefaultProjectionSerializer")
public class QIncomeTotalDto extends ConstructorExpression<IncomeTotalDto> {

    private static final long serialVersionUID = -1130080687L;

    public QIncomeTotalDto(com.querydsl.core.types.Expression<String> date, com.querydsl.core.types.Expression<Long> incSum, com.querydsl.core.types.Expression<Long> beggarId) {
        super(IncomeTotalDto.class, new Class<?>[]{String.class, long.class, long.class}, date, incSum, beggarId);
    }

}

