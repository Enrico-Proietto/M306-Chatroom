package ch.bbzbl.chatroom.chatroom.model.user;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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
    private String email;
    private Long phoneNumber;
    private String password;

    public void setEmail(String newEmail) {
        if (!newEmail.contains("@")){
            throw new IllegalArgumentException("for a new Email an @ is required.");
        }
        else {
            this.email = newEmail;
        }
    }

}
