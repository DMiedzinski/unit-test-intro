package com.example.task04;

import com.example.user.User;
import com.example.user.UserDao;
import com.example.user.UserDto;

import java.time.LocalDate;

public class StoreUserService {

    private UserDao userDao;

    public StoreUserService(UserDao userDao) {
        this.userDao = userDao;
    }

    public void saveUser(UserDto userDto) {
        LocalDate date = LocalDate.parse(userDto.getBirthday());
        User user = new User(userDto.getName(), date);
        userDao.save(user);
    }
    
    public void storingUser(String name, LocalDate birthday){
    	User user = new User(name, birthday);
    	userDao.save(user);
    }

}
