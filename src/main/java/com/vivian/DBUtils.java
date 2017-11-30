package com.vivian;

import java.sql.*;

public class DBUtils {
    //数据库的连接设置
    static String url = "jdbc:mysql://localhost:3306/apiTest";
    static String user = "root";
    static String password = "123456";


    /**
     * 建立连接
     *
     * @return
     * @throws SQLException
     */
    public static Connection getConnection() {
        Connection conn = null;
        try {

            Class.forName("com.mysql.jdbc.Driver");  //注册数据库驱动
            conn = DriverManager.getConnection(url, user, password);
        } catch (Exception e) {
            e.printStackTrace();

        }

        return conn;
    }


    /***
     * 数据库关闭操作
     * @param ps
     * @param conn
     */
    public static void closeConnection(PreparedStatement ps, Connection conn) {
        if (ps != null) {
            try {
                ps.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 数据库关闭操作
     *
     * @param rs
     * @param ps
     * @param conn
     */
    public static void closeConnection(ResultSet rs, PreparedStatement ps, Connection conn) {
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        closeConnection(ps, conn);
    }


}
