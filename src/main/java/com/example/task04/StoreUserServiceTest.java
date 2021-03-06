package com.example.task04;

import static org.junit.Assert.assertEquals;

import java.time.LocalDate;

import org.junit.Test;
import org.mockito.BDDMockito;
import org.mockito.Mockito;

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
	public void testStoreUserMockito() {
		// given
		MyUserDao userDao = Mockito.mock(MyUserDao.class);
		StoreUserService storeUser = new StoreUserService(userDao);

		// when
		storeUser.storingUser("John", LocalDate.of(2017, 1, 1));

		// then
		BDDMockito.verify(userDao).save(new User("John", LocalDate.of(2017, 1, 1)));
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


@Test
public void testSaveUserMockito() {
	// given
	MyUserDao userDao = Mockito.mock(MyUserDao.class);

	// when
	userDao.save(new User("John", LocalDate.of(2010, 1, 1)));
	
	// then
	BDDMockito.then(userDao).should().save(new User("John", LocalDate.of(2010, 1, 1)));
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
