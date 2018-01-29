package com.vivian.controller;

import com.vivian.service.IMessageService;
import com.vivian.service.IUserService;
import com.vivian.sql.model.HomeBoardDetailModel;
import com.vivian.sql.model.MsgListBean;
import com.vivian.sql.model.MyUser;
import com.vivian.sql.model.UserMessageList;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/msg")
@Scope("prototype")
public class MsgController extends BaseController {

    @Resource
    IMessageService iMessageService;
    @Resource
    IUserService iUserService;

    @RequestMapping(value = "/getMsgList", method = RequestMethod.POST)
    public @ResponseBody
    String insertHomeTopic() {

        String id = request.getHeader("uid");
        int idGet = Integer.parseInt(id);
        List<UserMessageList> userMessageLists = new ArrayList<>();
        List<MsgListBean> userMsg = iMessageService.getUserMsg(idGet);
        if (userMsg != null && userMsg.size() > 0) {

            for (int i = 0; i < userMsg.size(); i++) {
                MsgListBean msgListBean = userMsg.get(i);
                UserMessageList userMessageList = new UserMessageList();
                userMessageList.setMsgListId(msgListBean.getMsgListId());
                MyUser userById = iUserService.findUserById(msgListBean.getMsgFromId());
                if (userById != null) {
                    userMessageList.setMsgUserIcon(userById.getUserIcon());
                    userMessageList.setMsgUserName(userById.getUserName());
                } else {
                    userMessageList.setMsgUserName("已注销");
                }
                userMessageList.setMsgCount(msgListBean.getMsgCount());
                userMessageLists.add(userMessageList);
            }
            return onSuccess(userMessageLists);

        } else {


            return onFailed(100, "无数据");
        }
    }
}
