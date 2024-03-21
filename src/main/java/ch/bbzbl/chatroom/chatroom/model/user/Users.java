package ch.bbzbl.chatroom.chatroom.model.user;
import ch.bbzbl.chatroom.chatroom.model.chat.Chat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String firstname;
    private String lastname;
    @JsonIgnore
    private String email;
    @JsonIgnore
    private Long phoneNumber;
    @JsonIgnore
    private String password;
    @JsonIgnore
    @ManyToMany
    private List<Chat> chat;

    public void setEmail(String newEmail) {
        if (!newEmail.contains("@")){
            throw new IllegalArgumentException("for a new Email an @ is required.");
        }
        else {
            this.email = newEmail;
        }
    }

}
