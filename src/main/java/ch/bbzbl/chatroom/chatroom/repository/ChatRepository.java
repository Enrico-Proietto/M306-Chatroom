package ch.bbzbl.chatroom.chatroom.repository;

import ch.bbzbl.chatroom.chatroom.model.chat.Chat;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ChatRepository extends JpaRepository<Chat, Long> {
    Chat findChatById(Long id);
    Chat findByName(String name);

}