package com.example.task02;

import static org.junit.Assert.assertEquals;

import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.example.date.DateProvider;
import com.example.user.User;
import com.example.user.UserDao;

public class UserServiceTest {
	
	long startTime;
	
	@Before
	public void beforeClass(){
		startTime = System.currentTimeMillis();
		System.out.println(startTime);
	}
	
	
    @Test
    public void shouldCalculateAvgAgeFor3Person() {
        // given
        UserDao userDao = new TestUserDao();
        DateProvider dateProvider = new TestDateProvider();
        UserService userService = new UserService(userDao, dateProvider);

        // when
        double result = userService.calculateAvgAgeOfUsers();

        // then
        assertEquals(5, result, 0.01);
    }
    
    @After 
    public void afterTest(){
    	long endTime = System.currentTimeMillis();
    	long testTime = endTime - startTime;
    	System.out.println(endTime);
    	System.out.println("Test took: " + testTime + " ms.");
    }
}

class TestUserDao extends UserDao {
    @Override
    public Set<User> getAllUsers() {
        Set<User> users = new HashSet<>();
        users.add(new User("John", LocalDate.of(2007, 1, 6)));
        users.add(new User("Max", LocalDate.of(2017, 1, 6)));
        return users;
    }
}

class TestDateProvider implements DateProvider {
    @Override
    public LocalDate now() {
        return LocalDate.of(2017, 5, 1);
    }
}