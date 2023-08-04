package com.example.apoorpoor_backend.dto.ledgerhistory;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.ConstructorExpression;
import javax.annotation.processing.Generated;

/**
 * com.example.apoorpoor_backend.dto.ledgerhistory.QLedgerHistoryResponseDto is a Querydsl Projection type for LedgerHistoryResponseDto
 */
@Generated("com.querydsl.codegen.DefaultProjectionSerializer")
public class QLedgerHistoryResponseDto extends ConstructorExpression<LedgerHistoryResponseDto> {

    private static final long serialVersionUID = 1673878602L;

    public QLedgerHistoryResponseDto(com.querydsl.core.types.Expression<Long> id, com.querydsl.core.types.Expression<String> title, com.querydsl.core.types.Expression<com.example.apoorpoor_backend.model.enumType.AccountType> accountType, com.querydsl.core.types.Expression<com.example.apoorpoor_backend.model.enumType.IncomeType> incomeType, com.querydsl.core.types.Expression<com.example.apoorpoor_backend.model.enumType.ExpenditureType> expenditureType, com.querydsl.core.types.Expression<com.example.apoorpoor_backend.model.enumType.PaymentMethod> paymentMethod, com.querydsl.core.types.Expression<Long> income, com.querydsl.core.types.Expression<Long> expenditure, com.querydsl.core.types.Expression<String> date) {
        super(LedgerHistoryResponseDto.class, new Class<?>[]{long.class, String.class, com.example.apoorpoor_backend.model.enumType.AccountType.class, com.example.apoorpoor_backend.model.enumType.IncomeType.class, com.example.apoorpoor_backend.model.enumType.ExpenditureType.class, com.example.apoorpoor_backend.model.enumType.PaymentMethod.class, long.class, long.class, String.class}, id, title, accountType, incomeType, expenditureType, paymentMethod, income, expenditure, date);
    }

}

