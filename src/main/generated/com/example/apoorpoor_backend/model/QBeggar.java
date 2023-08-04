package com.example.apoorpoor_backend.model;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QBeggar is a Querydsl query type for Beggar
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QBeggar extends EntityPathBase<Beggar> {

    private static final long serialVersionUID = -1484546338L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QBeggar beggar = new QBeggar("beggar");

    public final QTimestamped _super = new QTimestamped(this);

    public final EnumPath<com.example.apoorpoor_backend.model.enumType.ItemListEnum> acc = createEnum("acc", com.example.apoorpoor_backend.model.enumType.ItemListEnum.class);

    public final EnumPath<com.example.apoorpoor_backend.model.enumType.ItemListEnum> bottom = createEnum("bottom", com.example.apoorpoor_backend.model.enumType.ItemListEnum.class);

    public final StringPath challengeTitle = createString("challengeTitle");

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createdAt = _super.createdAt;

    public final EnumPath<com.example.apoorpoor_backend.model.enumType.ItemListEnum> custom = createEnum("custom", com.example.apoorpoor_backend.model.enumType.ItemListEnum.class);

    public final StringPath description = createString("description");

    public final NumberPath<Long> exp = createNumber("exp", Long.class);

    public final ListPath<GetBadge, QGetBadge> getBadgeList = this.<GetBadge, QGetBadge>createList("getBadgeList", GetBadge.class, QGetBadge.class, PathInits.DIRECT2);

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final NumberPath<Long> level = createNumber("level", Long.class);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> modifiedAt = _super.modifiedAt;

    public final StringPath nickname = createString("nickname");

    public final NumberPath<Long> point = createNumber("point", Long.class);

    public final EnumPath<com.example.apoorpoor_backend.model.enumType.ItemListEnum> shoes = createEnum("shoes", com.example.apoorpoor_backend.model.enumType.ItemListEnum.class);

    public final NumberPath<Long> successCount = createNumber("successCount", Long.class);

    public final EnumPath<com.example.apoorpoor_backend.model.enumType.ItemListEnum> top = createEnum("top", com.example.apoorpoor_backend.model.enumType.ItemListEnum.class);

    public final QUser user;

    public QBeggar(String variable) {
        this(Beggar.class, forVariable(variable), INITS);
    }

    public QBeggar(Path<? extends Beggar> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QBeggar(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QBeggar(PathMetadata metadata, PathInits inits) {
        this(Beggar.class, metadata, inits);
    }

    public QBeggar(Class<? extends Beggar> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.user = inits.isInitialized("user") ? new QUser(forProperty("user"), inits.get("user")) : null;
    }

}

