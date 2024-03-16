package ch.bbzbl.chatroom.chatroom.repository;

import ch.bbzbl.chatroom.chatroom.model.message.Message;
import ch.bbzbl.chatroom.chatroom.model.user.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface MessageRepository extends JpaRepository<Message, Long> {
	Message findMessageById(Long id);
	List<Message> findMessageByAuthor(Users users);
	List<Message> findMessageByChatId(Long chatId);
}
