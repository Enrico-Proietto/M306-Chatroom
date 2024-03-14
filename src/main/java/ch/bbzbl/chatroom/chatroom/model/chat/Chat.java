package ch.bbzbl.chatroom.chatroom.model.chat;




import ch.bbzbl.chatroom.chatroom.model.user.Users;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.List;


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
    private Date creationDate;

    @ManyToOne
    private Users creator;
    @ManyToMany
    private List<Users> user;

}