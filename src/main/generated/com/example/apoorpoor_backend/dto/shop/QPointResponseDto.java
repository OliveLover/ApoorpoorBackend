package com.example.apoorpoor_backend.dto.shop;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.ConstructorExpression;
import javax.annotation.processing.Generated;

/**
 * com.example.apoorpoor_backend.dto.shop.QPointResponseDto is a Querydsl Projection type for PointResponseDto
 */
@Generated("com.querydsl.codegen.DefaultProjectionSerializer")
public class QPointResponseDto extends ConstructorExpression<PointResponseDto> {

    private static final long serialVersionUID = 730431250L;

    public QPointResponseDto(com.querydsl.core.types.Expression<Long> point_id, com.querydsl.core.types.Expression<String> pointDescription, com.querydsl.core.types.Expression<Long> earnedPoint, com.querydsl.core.types.Expression<Long> usedPoints, com.querydsl.core.types.Expression<Long> beggar_id, com.querydsl.core.types.Expression<java.time.LocalDateTime> createdAt) {
        super(PointResponseDto.class, new Class<?>[]{long.class, String.class, long.class, long.class, long.class, java.time.LocalDateTime.class}, point_id, pointDescription, earnedPoint, usedPoints, beggar_id, createdAt);
    }

}

