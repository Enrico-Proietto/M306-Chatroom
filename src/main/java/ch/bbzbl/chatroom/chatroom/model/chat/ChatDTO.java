package ch.bbzbl.chatroom.chatroom.model.chat;



import ch.bbzbl.chatroom.chatroom.model.user.Users;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ChatDTO {
    private Long id;
    private String name;
    private List<Users> user;
    private Date creationDate;
}
