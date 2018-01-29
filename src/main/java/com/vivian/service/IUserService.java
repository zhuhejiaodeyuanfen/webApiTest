package com.vivian.service;

import com.vivian.sql.model.MyUser;

public interface IUserService {
    void addUser(MyUser user);

    int updateUser(MyUser user);

    MyUser findUserByUserName(String userName);

    MyUser findUserById(int id);

//    void deleteUserByUserName(String userName);

//    void loginSuccess(User user);

    int insertUser(MyUser myUser);
}
