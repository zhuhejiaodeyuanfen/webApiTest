package com.vivian.service.impl;

import com.vivian.User;
import com.vivian.UserDao;
import com.vivian.UserDaoImpl;
import com.vivian.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service("userService")
public class UserServiceImpl implements IUserService {
//    @Autowired
    private UserDaoImpl userDao;

    public User getUserById(int userId) {
        userDao = new UserDaoImpl();
        return userDao.getUserList().get(0);
    }
}
