package com.example.apoorpoor_backend.dto.social;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.ConstructorExpression;
import javax.annotation.processing.Generated;

/**
 * com.example.apoorpoor_backend.dto.social.QExpenditureAvgDto is a Querydsl Projection type for ExpenditureAvgDto
 */
@Generated("com.querydsl.codegen.DefaultProjectionSerializer")
public class QExpenditureAvgDto extends ConstructorExpression<ExpenditureAvgDto> {

    private static final long serialVersionUID = -1467379873L;

    public QExpenditureAvgDto(com.querydsl.core.types.Expression<Long> age_abb, com.querydsl.core.types.Expression<String> date, com.querydsl.core.types.Expression<Long> exp_count, com.querydsl.core.types.Expression<Long> exp_sum, com.querydsl.core.types.Expression<Double> exp_avg, com.querydsl.core.types.Expression<String> gender) {
        super(ExpenditureAvgDto.class, new Class<?>[]{long.class, String.class, long.class, long.class, double.class, String.class}, age_abb, date, exp_count, exp_sum, exp_avg, gender);
    }

}

