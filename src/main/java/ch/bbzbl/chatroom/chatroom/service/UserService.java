package ch.bbzbl.chatroom.chatroom.service;

import ch.bbzbl.chatroom.chatroom.model.user.Users;
import ch.bbzbl.chatroom.chatroom.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService extends AbstractService<Users> {
    private final UserRepository repository;
    protected UserService(UserRepository repository) {
        super(repository);
        this.repository = repository;
    }

    public Users findByEmail(String email) {
        return repository.findByEmail(email);
    }


}
