package com.example.apoorpoor_backend.dto.social;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.ConstructorExpression;
import javax.annotation.processing.Generated;

/**
 * com.example.apoorpoor_backend.dto.social.QExpenditurePercentDto is a Querydsl Projection type for ExpenditurePercentDto
 */
@Generated("com.querydsl.codegen.DefaultProjectionSerializer")
public class QExpenditurePercentDto extends ConstructorExpression<ExpenditurePercentDto> {

    private static final long serialVersionUID = 1564746764L;

    public QExpenditurePercentDto(com.querydsl.core.types.Expression<Long> age_abb, com.querydsl.core.types.Expression<String> date, com.querydsl.core.types.Expression<Long> exp_sum, com.querydsl.core.types.Expression<String> gender, com.querydsl.core.types.Expression<Long> user_id, com.querydsl.core.types.Expression<Long> my_rank) {
        super(ExpenditurePercentDto.class, new Class<?>[]{long.class, String.class, long.class, String.class, long.class, long.class}, age_abb, date, exp_sum, gender, user_id, my_rank);
    }

}

