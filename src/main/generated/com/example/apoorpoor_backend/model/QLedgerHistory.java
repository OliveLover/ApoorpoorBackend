package com.example.apoorpoor_backend.model;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QLedgerHistory is a Querydsl query type for LedgerHistory
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QLedgerHistory extends EntityPathBase<LedgerHistory> {

    private static final long serialVersionUID = -66196319L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QLedgerHistory ledgerHistory = new QLedgerHistory("ledgerHistory");

    public final QTimestamped _super = new QTimestamped(this);

    public final QAccount account;

    public final EnumPath<com.example.apoorpoor_backend.model.enumType.AccountType> accountType = createEnum("accountType", com.example.apoorpoor_backend.model.enumType.AccountType.class);

    public final NumberPath<Long> challengeId = createNumber("challengeId", Long.class);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createdAt = _super.createdAt;

    public final DatePath<java.time.LocalDate> date = createDate("date", java.time.LocalDate.class);

    public final NumberPath<Long> expenditure = createNumber("expenditure", Long.class);

    public final EnumPath<com.example.apoorpoor_backend.model.enumType.ExpenditureType> expenditureType = createEnum("expenditureType", com.example.apoorpoor_backend.model.enumType.ExpenditureType.class);

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final NumberPath<Long> income = createNumber("income", Long.class);

    public final EnumPath<com.example.apoorpoor_backend.model.enumType.IncomeType> incomeType = createEnum("incomeType", com.example.apoorpoor_backend.model.enumType.IncomeType.class);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> modifiedAt = _super.modifiedAt;

    public final EnumPath<com.example.apoorpoor_backend.model.enumType.PaymentMethod> paymentMethod = createEnum("paymentMethod", com.example.apoorpoor_backend.model.enumType.PaymentMethod.class);

    public final StringPath title = createString("title");

    public QLedgerHistory(String variable) {
        this(LedgerHistory.class, forVariable(variable), INITS);
    }

    public QLedgerHistory(Path<? extends LedgerHistory> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QLedgerHistory(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QLedgerHistory(PathMetadata metadata, PathInits inits) {
        this(LedgerHistory.class, metadata, inits);
    }

    public QLedgerHistory(Class<? extends LedgerHistory> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.account = inits.isInitialized("account") ? new QAccount(forProperty("account"), inits.get("account")) : null;
    }

}

