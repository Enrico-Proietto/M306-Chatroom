package ch.bbzbl.chatroom.chatroom.factory;

import ch.bbzbl.chatroom.chatroom.model.user.Users;
import ch.bbzbl.chatroom.chatroom.model.user.UserDTO;
import org.springframework.stereotype.Service;

@Service
public class UserFactory {
    public UserDTO createUserDTO(Users user) {
        UserDTO userDTO = new UserDTO();

        userDTO.setId(user.getId());
        userDTO.setFirstname(user.getFirstname());
        userDTO.setLastname(user.getLastname());
        userDTO.setEmail(user.getEmail());
        userDTO.setPhoneNumber(user.getPhoneNumber());
        userDTO.setChat(user.getChat());

        return userDTO;
    }
}
