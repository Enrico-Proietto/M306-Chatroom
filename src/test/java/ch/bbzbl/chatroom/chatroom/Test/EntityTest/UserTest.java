package ch.bbzbl.chatroom.chatroom.Test.EntityTest;

import ch.bbzbl.chatroom.chatroom.model.user.Users;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
/*@ExtendWith(MockitoExtension.class)*/
public class UserTest {

	private final Users testUser = new Users();

	@BeforeEach
	void setUp() {
		testUser.setId(1000L);
		testUser.setFirstname("Max");
		testUser.setLastname("Mustermann");
		testUser.setEmail("maxmustermann@gmail.com");
		testUser.setPhoneNumber(41795236485L);
		testUser.setPassword("Password.5");
	}

	@Test
	void initAndGetterTest() {
		assertEquals(1000L, testUser.getId());
		assertEquals("Max", testUser.getFirstname());
		assertEquals("Mustermann", testUser.getLastname());
		assertEquals("maxmustermann@gmail.com", testUser.getEmail());
		assertEquals(41795236485L, testUser.getPhoneNumber());
		assertEquals("Password.5", testUser.getPassword());
	}

	@Test
	void setterTest() {
		testUser.setId(1102L);
		testUser.setFirstname("Hans");
		testUser.setLastname("Müller");
		testUser.setEmail("hansmueller@gmail.com");
		testUser.setPhoneNumber(41798421975L);
		testUser.setPassword("PasSwORd.1");

		assertEquals(1102L, testUser.getId());
		assertEquals("Hans", testUser.getFirstname());
		assertEquals("Müller", testUser.getLastname());
		assertEquals("hansmueller@gmail.com", testUser.getEmail());
		assertEquals(41798421975L, testUser.getPhoneNumber());
		assertEquals("PasSwORd.1", testUser.getPassword());
	}

	@Test
	void testIllegalEmail() {
		assertThrows(IllegalArgumentException.class, () -> testUser.setEmail("newEmail.ch"));
	}
}
