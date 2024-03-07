package ch.bbzbl.chatroom.chatroom.repository;

import ch.bbzbl.chatroom.chatroom.model.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findByEmail(String email);
    User findByPhoneNumber(String phoneNumber);
    User findByFirstname(String firstname);
    User findByLastname(String lastname);
    User findByEmailAndPassword(String email, String password);
    User findByPhoneNumberAndPassword(String phoneNumber, String password);
    User findByFirstnameAndPassword(String firstname, String password);
    User findByLastnameAndPassword(String lastname, String password);
    User findByEmailAndPhoneNumber(String email, String phoneNumber);
    User findByEmailAndFirstname(String email, String firstname);
    User findByEmailAndLastname(String email, String lastname);
    User findByPhoneNumberAndFirstname(String phoneNumber, String firstname);
    User findByPhoneNumberAndLastname(String phoneNumber, String lastname);
    User findByFirstnameAndLastname(String firstname, String lastname);
    User findByEmailAndPhoneNumberAndPassword(String email, String phoneNumber, String password);
    User findByEmailAndFirstnameAndPassword(String email, String firstname, String password);
    User findByEmailAndLastnameAndPassword(String email, String lastname, String password);
    User findByPhoneNumberAndFirstnameAndPassword(String phoneNumber, String firstname, String password);
    User findByPhoneNumberAndLastnameAndPassword(String phoneNumber, String lastname, String password);
    User findByFirstnameAndLastnameAndPassword(String firstname, String lastname, String password);
    User findByEmailAndPhoneNumberAndFirstname(String email, String phoneNumber, String firstname);
    User findByEmailAndPhoneNumberAndLastname(String email, String phoneNumber, String lastname);
    User findByEmailAndFirstnameAndLastname(String email, String firstname, String lastname);
    User findByPhoneNumberAndFirstnameAndLastname(String phoneNumber, String firstname, String lastname);
    User findByEmailAndPhoneNumberAndFirstnameAndPassword(String email, String phoneNumber, String firstname, String password);
    User findByEmailAndPhoneNumberAndLastnameAndPassword(String email, String phoneNumber, String lastname, String password);
    User findByEmailAndFirstnameAndLastnameAndPassword(String email, String firstname, String lastname, String password);
    User findByPhoneNumberAndFirstnameAndLastnameAndPassword(String phoneNumber, String firstname, String lastname, String password);
    User findByEmailAndPhoneNumberAndFirstnameAndLastname(String email, String phoneNumber, String firstname, String lastname);
    User findByEmailAndPhoneNumberAndFirstnameAndLastnameAndPassword(String email, String phoneNumber, String firstname, String lastname, String password);
    User findByEmailAndPasswordAndPhoneNumberAndFirstname(String email, String password, String phoneNumber, String firstname);
    User findByEmailAndPasswordAndPhoneNumberAndLastname(String email, String password, String phoneNumber, String lastname);
}
