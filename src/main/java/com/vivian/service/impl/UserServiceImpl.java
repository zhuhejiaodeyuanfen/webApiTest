package com.vivian.service.impl;

import com.vivian.dao.UserDaoI;
import com.vivian.sql.model.MyUser;
import com.vivian.service.IUserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;


@Service
public class UserServiceImpl implements IUserService {


    @Resource
    public UserDaoI userMapper;


    @Override
    public void addUser(MyUser user) {
        if (user != null)
            userMapper.addUser(user);
    }

    @Override
    public int updateUser(MyUser user) {
        return userMapper.updateUser(user);
    }


    @Override
    public MyUser findUserByUserName(String userName) {
        if (userName == null) {
            return null;
        }
        return userMapper.findUserByUserName(userName);
    }

    @Override
    public MyUser findUserById(int id) {
        return userMapper.findUserById(id);
    }

    @Override
    public int insertUser(MyUser myUser) {
        return userMapper.insertUser(myUser);
    }
//
//    @Override
//    public void deleteUserByUserName(String userName) {
//
//    }
//
//    @Override
//    public void loginSuccess(User user) {
//
//    }
}
