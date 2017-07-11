package com.example.task04;

import static org.junit.Assert.assertEquals;
import java.time.LocalDate;
import org.junit.Test;
import com.example.user.User;
import com.example.user.UserDao;
import com.example.user.UserDto;

public class StoreUserServiceTest {

	@Test
	public void testSaveUser() {
		// given
		MyUserDao userDao = new MyUserDao();
		StoreUserService storeUser = new StoreUserService(userDao);
		UserDto userDto = new UserDto();
		userDto.setBirthday("2010-01-11");
		userDto.setName("John");

		// when
		storeUser.saveUser(userDto);

		// then
		User actualUser = userDao.getUser();
		assertEquals("John", actualUser.getName());
		assertEquals(LocalDate.of(2010, 01, 11), actualUser.getBirthday());
	}


@Test
public void testStoreUser() {
	// given
	MyUserDao userDao = new MyUserDao();
	StoreUserService service = new StoreUserService(userDao);


	// when
	service.storingUser("John", LocalDate.of(2010, 07, 13));

	// then
	User actualUser = userDao.getUser();
	assertEquals("John", actualUser.getName());
	assertEquals(LocalDate.of(2010, 07, 13), actualUser.getBirthday());
}	
}	
class MyUserDao extends UserDao {
	private User user;

	@Override
	public void save(User user) {
		this.user = user;
	}

	public User getUser() {
		return user;
	}
}
