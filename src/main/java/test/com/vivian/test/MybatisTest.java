package test.com.vivian.test;

import com.vivian.sql.model.HomeBoardDetailModel;
import com.vivian.sql.model.LivePhotoDetailModel;
import com.vivian.sql.model.MyUser;
import com.vivian.tools.JsonTools;
import org.apache.log4j.Logger;

import java.sql.Timestamp;

public class MybatisTest {
    private static Logger logger = Logger.getLogger(MybatisTest.class.getName());


    public static void main(String[] args) {





        System.out.println(HttpConnectUtil.httpRequest("http://localhost:8080/wq", "GET", ""));




        System.out.println(HttpConnectUtil.httpRequest("http://localhost:8080/wq/user/searchUser", "POST", "username=mytest"));



        MyUser myUser = new MyUser();
        myUser.setUserName("测试姓名1");
        myUser.setPassWord("123456");
        myUser.setUserPhone("15000619639");
        myUser.setUserEmail("522029704@qq.com");
        myUser.setUserSex("男");
        System.out.println("测试注册接口");
        System.out.println(HttpClientUtil.doPost("http://localhost:8080/wq/user/register",JsonTools.getJsonString(myUser)));

        System.out.println("测试登陆接口1");
        System.out.println(HttpConnectUtil.httpRequest("http://localhost:8080/wq/user/login","POST","userName=测试姓名1&&passWord=123456"));
        System.out.println("测试登陆接口2");
        System.out.println(HttpConnectUtil.httpRequest("http://localhost:8080/wq/user/login","POST","userName=测试姓名2&&passWord=123456"));
        System.out.println("测试登陆接口3");
        System.out.println(HttpConnectUtil.httpRequest("http://localhost:8080/wq/user/login","POST","userName=测试姓名1&&passWord=126"));


        System.out.println(HttpConnectUtil.httpRequest("http://localhost:8080/wq/live/getAllLive","POST",""));


        System.out.println(HttpConnectUtil.httpRequest("http://localhost:8080/wq/live/queryLive","POST","id=1"));

        LivePhotoDetailModel livePhotoDetailModel=new LivePhotoDetailModel();
        livePhotoDetailModel.setPostAdmin("苏苏苏苏晓墨");
        livePhotoDetailModel.setPostBackColor("#DDF0ED");
        livePhotoDetailModel.setPostCreateTime(new Timestamp(System.currentTimeMillis()));
        livePhotoDetailModel.setPostContent("争取过,无果,推荐你听正趣果上果");
        livePhotoDetailModel.setPostParentId("1");
        livePhotoDetailModel.setPostSonId("1");
        livePhotoDetailModel.setPostTitle("none sense");

        System.out.println(HttpClientUtil.doPost("http://localhost:8080/wq/live/addLivePost",JsonTools.getJsonString(livePhotoDetailModel)));

        System.out.println(HttpConnectUtil.httpRequest("http://localhost:8080/wq/home/getHomeLive","POST",""));

        System.out.println(HttpConnectUtil.httpRequest("http://localhost:8080/wq/comment/getComment","POST","postId=1"));


        HomeBoardDetailModel homeBoardDetailModel=new HomeBoardDetailModel();
        homeBoardDetailModel.setPostContent("");

        homeBoardDetailModel.setPostTitle("测试标题");
        homeBoardDetailModel.setPostParentId("1");
        homeBoardDetailModel.setPostAdmin("测试同学1");
        homeBoardDetailModel.setPostCreateTime(new Timestamp(System.currentTimeMillis()));


        System.out.println(HttpClientUtil.doPost("http://localhost:8080/wq/home/addHotTopic",JsonTools.getJsonString(homeBoardDetailModel)));
        logger.debug("this is Debug message");

        System.out.println(HttpConnectUtil.httpRequest("http://localhost:8080/wq/user/update-icon","POST","userIcon=changeIcon"));
    }
}
