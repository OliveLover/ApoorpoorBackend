package com.example.apoorpoor_backend.model;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QBadge is a Querydsl query type for Badge
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QBadge extends EntityPathBase<Badge> {

    private static final long serialVersionUID = -879294631L;

    public static final QBadge badge = new QBadge("badge");

    public final QTimestamped _super = new QTimestamped(this);

    public final StringPath badgeImage = createString("badgeImage");

    public final NumberPath<Long> badgeNum = createNumber("badgeNum", Long.class);

    public final StringPath badgeTitle = createString("badgeTitle");

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createdAt = _super.createdAt;

    public final ListPath<GetBadge, QGetBadge> getBadgeList = this.<GetBadge, QGetBadge>createList("getBadgeList", GetBadge.class, QGetBadge.class, PathInits.DIRECT2);

    public final NumberPath<Long> id = createNumber("id", Long.class);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> modifiedAt = _super.modifiedAt;

    public QBadge(String variable) {
        super(Badge.class, forVariable(variable));
    }

    public QBadge(Path<? extends Badge> path) {
        super(path.getType(), path.getMetadata());
    }

    public QBadge(PathMetadata metadata) {
        super(Badge.class, metadata);
    }

}

