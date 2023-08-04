package com.example.apoorpoor_backend.model;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QBalance is a Querydsl query type for Balance
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QBalance extends EntityPathBase<Balance> {

    private static final long serialVersionUID = 1113638162L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QBalance balance = new QBalance("balance");

    public final QAccount account;

    public final NumberPath<Long> expenditureTotal = createNumber("expenditureTotal", Long.class);

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final NumberPath<Long> incomeTotal = createNumber("incomeTotal", Long.class);

    public QBalance(String variable) {
        this(Balance.class, forVariable(variable), INITS);
    }

    public QBalance(Path<? extends Balance> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QBalance(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QBalance(PathMetadata metadata, PathInits inits) {
        this(Balance.class, metadata, inits);
    }

    public QBalance(Class<? extends Balance> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.account = inits.isInitialized("account") ? new QAccount(forProperty("account"), inits.get("account")) : null;
    }

}

