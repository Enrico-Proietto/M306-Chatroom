package ch.bbzbl.chatroom.chatroom.service;

import ch.bbzbl.chatroom.chatroom.model.user.User;
import ch.bbzbl.chatroom.chatroom.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService extends AbstractService<User> {
    private final UserRepository repository;
    protected UserService(UserRepository repository) {
        super(repository);
        this.repository = repository;
    }

    public User findByEmail(String email) {
        return repository.findByEmail(email);
    }

    public User findByPhoneNumber(int phoneNumber) {
        return repository.findByPhoneNumber(phoneNumber);
    }

}
