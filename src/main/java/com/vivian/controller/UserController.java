package com.vivian.controller;


import com.vivian.constants.HeadParams;
import com.vivian.sql.model.MyUser;
import com.vivian.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;

/**
 * 用户登陆controller
 */
@Controller
@RequestMapping("/user")
@Scope("prototype")
public class UserController extends BaseController {
    private static Logger logger = Logger.getLogger(UserController.class.getName());

    @Resource
    IUserService iUserService;

    /**
     * 用户注册模块
     *
     * @param user
     * @return
     */
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public @ResponseBody
    String userRegister(@RequestBody MyUser user) {
        MyUser tempUser = user;
        String id = request.getHeader("uid");
        System.out.println("获取到userId" + id);
        if (tempUser != null) {
            if (tempUser.getUserName() != null) {
                if (iUserService.findUserByUserName(tempUser.getUserName()) != null) {
                    //查找到该用户
                    return onFailed(10085, "已存在该用户");
                }
            }
        }
        int result = iUserService.insertUser(tempUser);
        logger.debug("注册结果" + result);
        return onSuccess("注册成功");
    }

    /**
     * 查询用户姓名
     *
     * @return
     */
    @RequestMapping(value = "/searchUser", method = RequestMethod.POST)
    public @ResponseBody
    String searchUser(String username) {
        String id = request.getHeader("uid");
        System.out.println("获取到userId" + id);
        MyUser user = iUserService.findUserByUserName(username);
        if (user != null) {
            return onSuccess(user);
        } else {
            return onFailed(10086, "没有搜索到该用户");
        }
    }

    /**
     * 查询用户姓名
     *
     * @return
     */
    @RequestMapping(value = "/getUser-content", method = RequestMethod.POST)
    public @ResponseBody
    String getUserContent(String username) {
        String id = request.getHeader("uid");
        System.out.println("获取到userId" + id);
        MyUser user = iUserService.findUserByUserName(username);
        if (user != null) {
            return onSuccess(user);
        } else {
            return onFailed(10086, "没有搜索到该用户");
        }
    }


    /**
     * 用户登陆
     *
     * @param userName
     * @param passWord
     * @return
     */
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public @ResponseBody
    String userLogin(String userName, String passWord) {
        String id = request.getHeader("uid");
        System.out.println("获取到userId" + id);
        MyUser user = iUserService.findUserByUserName(userName);
        if (user != null) {
            if (passWord != null) {
                if (user.getPassWord().equals(passWord))
                    return onSuccess(user);
                else
                    return onFailed(10001, "密码错误");
            } else {
                return onFailed(100, "密码不可为空");
            }
        } else {
            return onFailed(100, "不存在该用户");
        }
    }

    @RequestMapping(value = "/update-icon", method = RequestMethod.POST)
    public @ResponseBody
    String updateUserIcon(String userIcon) {
        String header1 = request.getHeader(HeadParams.UID_STRING);
        int uid = Integer.parseInt(header1);
        MyUser userById = iUserService.findUserById(uid);
        if (userById != null) {
            userById.setUserIcon(userIcon);
            if (updateUser(userById) == true)
                return onSuccess(userById);
            else
                return onFailed(100, "更新失败,请稍后重试");
        } else {
            return onFailed(100, "未查询到该用户");
        }
    }


    public boolean updateUser(MyUser myUser) {
        int i = iUserService.updateUser(myUser);
//        if (i == 1)
        return true;
//        else
//            return false;
    }

}
