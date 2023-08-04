package com.example.apoorpoor_backend.model;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QSocial is a Querydsl query type for Social
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QSocial extends EntityPathBase<Social> {

    private static final long serialVersionUID = -988732809L;

    public static final QSocial social = new QSocial("social");

    public final NumberPath<Long> age_abb = createNumber("age_abb", Long.class);

    public final StringPath date = createString("date");

    public final NumberPath<Double> exp_avg = createNumber("exp_avg", Double.class);

    public final NumberPath<Long> exp_count = createNumber("exp_count", Long.class);

    public final NumberPath<Long> exp_sum = createNumber("exp_sum", Long.class);

    public final StringPath gender = createString("gender");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final NumberPath<Double> inc_avg = createNumber("inc_avg", Double.class);

    public final NumberPath<Long> inc_count = createNumber("inc_count", Long.class);

    public final NumberPath<Long> inc_sum = createNumber("inc_sum", Long.class);

    public QSocial(String variable) {
        super(Social.class, forVariable(variable));
    }

    public QSocial(Path<? extends Social> path) {
        super(path.getType(), path.getMetadata());
    }

    public QSocial(PathMetadata metadata) {
        super(Social.class, metadata);
    }

}

