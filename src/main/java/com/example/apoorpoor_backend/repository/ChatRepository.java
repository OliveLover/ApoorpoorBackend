package com.example.apoorpoor_backend.repository;

import com.example.apoorpoor_backend.entity.Chat;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ChatRepository extends JpaRepository<Chat, Long> {

    List<Chat> findAllByRoom_IdOrderByCreatedDateAsc(Long RoomId);
}
