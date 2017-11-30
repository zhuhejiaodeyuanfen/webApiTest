package com.vivian;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDaoImpl implements UserDao {

    //保存
    public void save(User user) {
        Connection connection = null;
        PreparedStatement ps = null;
        try {
            //连接数据库
            connection = DBUtils.getConnection();
            //SQL语句
            ps = connection.prepareStatement("insert INTO (username,password,email) VALUES (?,?,?)");
            //给用户属性动态设置
            ps.setString(1, user.getUsername());
            ps.setString(2, user.getPassWord());
            ps.setString(3, user.getEmail());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            //关闭数据库连接
            DBUtils.closeConnection(ps, connection);
        }

    }

    public User login(String username, String password) {
        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            connection = DBUtils.getConnection();
            ps = connection.prepareStatement("SELECT  * FROM  apiUser  WHERE  username=? AND password=?");
            ps.setString(1, username);
            ps.setString(2, password);
            rs = ps.executeQuery();
            if (rs.next()) {
                User user = new User();
                user.setId(rs.getInt("id"));
                user.setUsername(rs.getString("username"));
                user.setPassWord(rs.getString("password"));
                user.setEmail(rs.getString("email"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtils.closeConnection(rs, ps, connection);
        }
        return null;
    }

    public boolean findByName(String username) {
        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            connection = DBUtils.getConnection();
            ps = connection.prepareStatement("SELECT  * FROM  apiUser  WHERE  username=?");
            ps.setString(1, username);
            rs = ps.executeQuery();
            if (rs.next()) {
                System.out.println("当然有数据啊");
//                String uName = rs.getString("username");
//                String uPass = rs.getString("password");
//                String uEmail = rs.getString("email");

            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            {
                DBUtils.closeConnection(rs, ps, connection);
            }
        }
        return false;
    }

    public List<User> getUserList() {
        List<User> userList = new ArrayList<User>();
        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            connection = DBUtils.getConnection();
            ps = connection.prepareStatement("SELECT  * FROM  apiUser");
            rs = ps.executeQuery();
            while (rs.next()) {
                System.out.println("当然有数据啊");
                String uName = rs.getString("username");
                String uPass = rs.getString("password");
                String uEmail = rs.getString("email");
                User user = new User();
                user.setUsername(uName);
                user.setPassWord(uPass);
                user.setEmail(uEmail);
                userList.add(user);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            {
                DBUtils.closeConnection(rs, ps, connection);
            }
        }
        return userList;

    }
}
