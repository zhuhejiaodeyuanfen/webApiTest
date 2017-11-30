package com.vivian;

import com.vivian.mapper.UserMapper;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;
import java.util.List;

public class DBHelpUtil {


    public SqlSession initSQL() {

        String resource = "conf.xml";
        InputStream is = WelcomeServlet.class.getClassLoader().getResourceAsStream(resource);
        SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(is);
//        sessionFactory.getConfiguration().addMapper(UserMapper.class);
        SqlSession session = sessionFactory.openSession();

        return session;
    }

    /**
     * 增加用户
     *
     * @param user
     */
    public boolean addAUser(User user) {


        return true;
    }

    /**
     * 删除用户
     *
     * @return
     */
    public int deleteUser(String username) {
        SqlSession sqlSession = initSQL();
//        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
//        int count = mapper.deleteUser(username);
        String statement = "com.vivian.mapping.userMapper.deleteUser1111111";//映射sql的标识字符串
        int count = sqlSession.delete(statement, "jack");
        System.out.println("count: " + count);
        // 请注意一定需要提交。
        sqlSession.commit();
        sqlSession.close();
        return count;
    }


    /**
     * 更新用户
     *
     * @param user
     * @return
     */
    public boolean updateUser(User user) {

        SqlSession sqlSession = initSQL();
        String statement = "com.vivian.mapping.userMapper.deleteUser1111111";//映射sql的标识字符串
        int count = sqlSession.delete(statement, "jack");
        System.out.println("count: " + count);
        // 请注意一定需要提交。
        sqlSession.commit();
        sqlSession.close();
        return true;
    }

    /**
     * 查询所有用户
     */
    public void selectAllUser() {

        List<User> userList = initSQL().selectList("com.vivian.mapping.userMapper.getAllUser");

    }

    /**
     * 查询单个用户
     */
    public void selectAUser() {

    }


}
