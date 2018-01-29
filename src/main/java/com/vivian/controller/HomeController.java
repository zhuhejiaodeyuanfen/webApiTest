package com.vivian.controller;

import com.vivian.service.IHomeService;
import com.vivian.service.ILiveService;
import com.vivian.service.IUserService;
import com.vivian.sql.model.HomeBoardDetailModel;
import com.vivian.sql.model.HomeTopicModel;
import com.vivian.sql.model.LiveBoardModel;
import com.vivian.sql.model.MyUser;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

/**
 * 主页controller
 */

@Controller
@RequestMapping("/home")
@Scope("prototype")
public class HomeController extends BaseController {
    @Resource
    IHomeService iHomeService;
    @Resource
    IUserService iUserService;

    /**
     * 查找最新的热门话题,需要结合user表查找相关用户信息
     *
     * @return
     */
    @RequestMapping(value = "/getHomeLive", method = RequestMethod.POST)
    public @ResponseBody
    String getHomeList() {
        List<HomeBoardDetailModel> allLiveBoard = iHomeService.getHomeView();
        List<HomeTopicModel> homeTopicModels = new ArrayList<HomeTopicModel>();
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());

        if (allLiveBoard != null && allLiveBoard.size() > 0) {

            for (int i = 0; i < allLiveBoard.size(); i++) {
                HomeBoardDetailModel homeBoardDetailModel = allLiveBoard.get(i);
                HomeTopicModel homeTopicModel = new HomeTopicModel();
                homeTopicModel.setHomePostId(homeBoardDetailModel.getHomePostId());
                int getId = Integer.parseInt(homeBoardDetailModel.getPostAdmin());
                MyUser userById = iUserService.findUserById(getId);
                if (userById != null) {
                    //可以查找到该用户
                    homeTopicModel.setPostAdmin(userById.getUserName());
                    homeTopicModel.setPostAdminIcon(userById.getUserIcon());
                } else {
                    homeTopicModel.setPostAdmin("已注销");
                }
                homeTopicModel.setPostTitle(homeBoardDetailModel.getPostTitle());
                homeTopicModel.setPostContent(homeBoardDetailModel.getPostContent());
                homeTopicModel.setPostCommentCount(homeBoardDetailModel.getPostCommentCount());
                homeTopicModel.setPostCreateTime(homeBoardDetailModel.getPostCreateTime());
                homeTopicModel.setSysCurrentTime(timestamp);
                homeTopicModels.add(homeTopicModel);
            }
            return onSuccess(homeTopicModels);
        } else {
            return onFailed(100, "查找失败");
        }

    }


    @RequestMapping(value = "/addHotTopic", method = RequestMethod.POST)
    public @ResponseBody
    String insertHomeTopic(@RequestBody HomeBoardDetailModel homeBoardDetailModel) {
        int i = iHomeService.insertHome(homeBoardDetailModel);

        return onSuccess("插入成功");
    }
}
