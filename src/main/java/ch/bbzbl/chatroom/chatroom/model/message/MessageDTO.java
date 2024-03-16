package ch.bbzbl.chatroom.chatroom.model.message;

import ch.bbzbl.chatroom.chatroom.model.chat.Chat;
import ch.bbzbl.chatroom.chatroom.model.user.Users;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class MessageDTO {
    private Long id;
    private String text;
    private Date writtenAt;
    private Users author;
    private Chat chat;
}
