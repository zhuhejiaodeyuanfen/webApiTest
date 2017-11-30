package com.vivian;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class WelcomeServlet extends IHttpServlet {
    private static final long serialVersionUID = 1L;
    private List<User> list;

    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        response.setContentType("text/plain");
        response.setCharacterEncoding("utf-8");
        PrintWriter out = response.getWriter();
        out.write(onSuccess(prepareData()));
        out.flush();
        out.close();

    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {

        doPost(request, response);
    }

    private List<User> prepareData() {

        list = new ArrayList<User>();

//        list.addAll(new UserDaoImpl().getUserList());
        //mybatis的配置文件
        String resource = "conf.xml";
        //使用类加载器加载mybatis的配置文件（它也加载关联的映射文件）
        InputStream is = WelcomeServlet.class.getClassLoader().getResourceAsStream(resource);
        //构建sqlSession的工厂
        SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(is);
        //使用MyBatis提供的Resources类加载mybatis的配置文件（它也加载关联的映射文件）
        //Reader reader = Resources.getResourceAsReader(resource);
        //构建sqlSession的工厂
        //SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(reader);
        //创建能执行映射文件中sql的sqlSession
        SqlSession session = sessionFactory.openSession();
        /**
         * 映射sql的标识字符串，
         * me.gacl.mapping.userMapper是userMapper.xml文件中mapper标签的namespace属性的值，
         * getUser是select标签的id属性值，通过select标签的id属性值就可以找到要执行的SQL
         */
        String statement = "com.vivian.mapping.userMapper.getAllUser";//映射sql的标识字符串
        //执行查询返回一个唯一user对象的sql
//        User user = session.selectOne(statement, 1);
//        System.out.println(user);
//        list.add(user);
        List<User> userList = session.selectList(statement);
        list.addAll(userList);
        DBHelpUtil dbHelpUtil = new DBHelpUtil();
        int jack = dbHelpUtil.deleteUser("jack");
        System.out.println("删除结果:" + jack);
        return list;
    }


}