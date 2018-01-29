package com.vivian.controller;

import com.vivian.service.ICommentService;
import com.vivian.service.IHomeService;
import com.vivian.service.IUserService;
import com.vivian.sql.model.CommentModel;
import com.vivian.sql.model.CommentModelOri;
import com.vivian.sql.model.HomeBoardDetailModel;
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

@Controller
@RequestMapping("/comment")
@Scope("prototype")
public class CommentController extends BaseController {
    @Resource
    ICommentService iCommentService;
    @Resource
    IUserService iUserService;
    @Resource
    IHomeService iHomeService;

    @RequestMapping(value = "/getComment", method = RequestMethod.POST)
    public @ResponseBody
    String getHomeList(int postId, int page) {

        int currIndex = (page - 1) * 20;
        int pageSize = 20;

        List<CommentModelOri> commentList = iCommentService.getCommentList(postId, currIndex, pageSize);
        List<CommentModel> commentModels = new ArrayList<CommentModel>();
        if (commentList != null && commentList.size() > 0) {
            for (int i = 0; i < commentList.size(); i++) {
                CommentModelOri commentModelOri = commentList.get(i);
                CommentModel commentModel = new CommentModel();
                commentModel.setUserComment(commentModelOri.getCommentContent());
                commentModel.setCommentId(commentModelOri.getCommentId());
                commentModel.setCommentTime(commentModelOri.getCommentTime());
                MyUser userById = iUserService.findUserById(commentModelOri.getCommentUserId());
                if (userById != null) {
                    commentModel.setUserName(userById.getUserName());
                    commentModel.setUserIcon(userById.getUserIcon());
                }
                commentModel.setSysCurrentTime(new Timestamp(System.currentTimeMillis()));
                commentModels.add(commentModel);

            }
            return onSuccess(commentModels);
        } else {
            return onFailed(100, "查找失败");
        }

    }

    /**
     * 用户新增评论
     *
     * @param commentModelOri
     * @return
     */

    @RequestMapping(value = "/addComment", method = RequestMethod.POST)
    @ResponseBody
    public String addComment(@RequestBody CommentModelOri commentModelOri) {
        int i = iCommentService.insertHomeComment(commentModelOri);
        if (i > 0) {
            HomeBoardDetailModel topicById = iHomeService.findTopicById(commentModelOri.getCommentPostId());
            if (topicById != null) {
                //查找该话题成功
                topicById.setPostCommentCount(topicById.getPostCommentCount() + 1);
                iHomeService.updateHomeComment(topicById);
                return onSuccess("添加成功");
            } else {
                return onFailed(100, "添加失败,请重试");
            }
        } else
            return onFailed(100, "添加失败,请重试");

    }
}
