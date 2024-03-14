package ch.bbzbl.chatroom.chatroom.model.user;

import ch.bbzbl.chatroom.chatroom.model.chat.Chat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {
    private Long id;
    private String firstname;
    private String lastname;
    private String email;
    private Long phoneNumber;
    private List<Chat> chat;
}
