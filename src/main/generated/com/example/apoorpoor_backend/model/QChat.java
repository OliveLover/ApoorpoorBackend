package com.example.apoorpoor_backend.model;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QChat is a Querydsl query type for Chat
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QChat extends EntityPathBase<Chat> {

    private static final long serialVersionUID = -1967990558L;

    public static final QChat chat = new QChat("chat");

    public final NumberPath<Long> beggar_id = createNumber("beggar_id", Long.class);

    public final StringPath chatId = createString("chatId");

    public final StringPath date = createString("date");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath image = createString("image");

    public final NumberPath<Long> level = createNumber("level", Long.class);

    public final StringPath message = createString("message");

    public final StringPath sender = createString("sender");

    public final EnumPath<com.example.apoorpoor_backend.model.enumType.MessageType> type = createEnum("type", com.example.apoorpoor_backend.model.enumType.MessageType.class);

    public final NumberPath<Long> userId = createNumber("userId", Long.class);

    public QChat(String variable) {
        super(Chat.class, forVariable(variable));
    }

    public QChat(Path<? extends Chat> path) {
        super(path.getType(), path.getMetadata());
    }

    public QChat(PathMetadata metadata) {
        super(Chat.class, metadata);
    }

}

