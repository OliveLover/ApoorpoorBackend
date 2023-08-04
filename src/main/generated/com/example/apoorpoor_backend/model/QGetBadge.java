package com.example.apoorpoor_backend.model;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QGetBadge is a Querydsl query type for GetBadge
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QGetBadge extends EntityPathBase<GetBadge> {

    private static final long serialVersionUID = -257772937L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QGetBadge getBadge = new QGetBadge("getBadge");

    public final QTimestamped _super = new QTimestamped(this);

    public final QBadge badge;

    public final QBeggar beggar;

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createdAt = _super.createdAt;

    public final NumberPath<Long> id = createNumber("id", Long.class);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> modifiedAt = _super.modifiedAt;

    public QGetBadge(String variable) {
        this(GetBadge.class, forVariable(variable), INITS);
    }

    public QGetBadge(Path<? extends GetBadge> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QGetBadge(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QGetBadge(PathMetadata metadata, PathInits inits) {
        this(GetBadge.class, metadata, inits);
    }

    public QGetBadge(Class<? extends GetBadge> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.badge = inits.isInitialized("badge") ? new QBadge(forProperty("badge")) : null;
        this.beggar = inits.isInitialized("beggar") ? new QBeggar(forProperty("beggar"), inits.get("beggar")) : null;
    }

}

