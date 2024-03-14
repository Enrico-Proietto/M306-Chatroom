package ch.bbzbl.chatroom.chatroom.factory;

import ch.bbzbl.chatroom.chatroom.model.chat.Chat;
import ch.bbzbl.chatroom.chatroom.model.chat.ChatDTO;

import org.springframework.stereotype.Service;
@Service
public class ChatFactory {
    public ChatDTO createChatDTO(Chat chat) {
        ChatDTO chatDTO = new ChatDTO();

        chatDTO.setId(chat.getId());
        chatDTO.setName(chat.getName());
        chatDTO.setUser(chat.getUser());
        chatDTO.setCreationDate(chat.getCreationDate());


        return chatDTO;
    }
}
