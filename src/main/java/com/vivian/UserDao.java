package com.vivian;

public interface UserDao {
    //保存用户信息
    void save(User user);

    //登录接口
    User login(String username, String password);

    //根据用户名查询用户方法接口
    boolean findByName(String username);
}
