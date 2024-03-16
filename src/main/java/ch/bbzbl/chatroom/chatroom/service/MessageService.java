package ch.bbzbl.chatroom.chatroom.service;

import ch.bbzbl.chatroom.chatroom.model.message.Message;
import ch.bbzbl.chatroom.chatroom.model.user.Users;
import ch.bbzbl.chatroom.chatroom.repository.MessageRepository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class MessageService extends RepositoryService<Message> {

	private final MessageRepository repository;
	protected MessageService(MessageRepository repository) {
		super(repository);
		this.repository = repository;
	}

	public Message findMessageById(Long id) {
		return repository.findMessageById(id);
	}

	public List<Message> findMessageByUser(Users users) {
		return repository.findMessageByAuthor(users);
	}

	public List<Message> findMessageByChatId(Long chatId) {
		return repository.findMessageByChatId(chatId);
	}
}
