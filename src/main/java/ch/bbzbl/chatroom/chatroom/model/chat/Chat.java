package ch.bbzbl.chatroom.chatroom.model.chat;




import ch.bbzbl.chatroom.chatroom.model.user.Users;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;


@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor


public class Chat {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private String name;
    @ManyToMany
    @JoinColumn(name = "user_id")
    private Users user;
    private Date creationDate;
}