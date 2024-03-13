package ch.bbzbl.chatroom.chatroom.repository;

import ch.bbzbl.chatroom.chatroom.model.user.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<Users, Long> {
    Users findUserById(Long id);
    Users findByEmail(String email);
    Users findByEmailAndPassword(String email, String password);
}
