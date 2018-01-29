package com.vivian.dao;

import com.vivian.sql.model.MyUser;
import org.springframework.stereotype.Repository;


@Repository
public interface UserDaoI {


    MyUser findUserByUserName(String username);

//    User findtUserByUserId(int id);

    void addUser(MyUser user);

//    void deleteUserByUserName(String username);


    int updateUser(MyUser user);

    int insertUser(MyUser myUser);

    MyUser findUserById(int id);
}
