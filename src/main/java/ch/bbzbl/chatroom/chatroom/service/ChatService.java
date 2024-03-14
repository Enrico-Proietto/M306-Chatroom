package ch.bbzbl.chatroom.chatroom.service;

import ch.bbzbl.chatroom.chatroom.model.chat.Chat;


import ch.bbzbl.chatroom.chatroom.repository.ChatRepository;


import org.springframework.stereotype.Service;

@Service

public class ChatService extends AbstractService<Chat>{
    private final ChatRepository repository;

    protected ChatService(ChatRepository repository) {
        super(repository);
        this.repository = repository;
    }

    public Chat findByName(String name) {

        return repository.findByName(name);
    }
}
