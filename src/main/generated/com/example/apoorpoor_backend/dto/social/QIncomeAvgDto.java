package com.example.apoorpoor_backend.dto.social;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.ConstructorExpression;
import javax.annotation.processing.Generated;

/**
 * com.example.apoorpoor_backend.dto.social.QIncomeAvgDto is a Querydsl Projection type for IncomeAvgDto
 */
@Generated("com.querydsl.codegen.DefaultProjectionSerializer")
public class QIncomeAvgDto extends ConstructorExpression<IncomeAvgDto> {

    private static final long serialVersionUID = 59801987L;

    public QIncomeAvgDto(com.querydsl.core.types.Expression<Long> age_abb, com.querydsl.core.types.Expression<String> date, com.querydsl.core.types.Expression<Long> inc_count, com.querydsl.core.types.Expression<Long> inc_sum, com.querydsl.core.types.Expression<Double> inc_avg, com.querydsl.core.types.Expression<String> gender) {
        super(IncomeAvgDto.class, new Class<?>[]{long.class, String.class, long.class, long.class, double.class, String.class}, age_abb, date, inc_count, inc_sum, inc_avg, gender);
    }

}

