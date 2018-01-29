package com.vivian.service.impl;

import com.vivian.dao.LiveDaoI;
import com.vivian.dao.MessageDaoI;
import com.vivian.service.IMessageService;
import com.vivian.sql.model.MsgListBean;
import com.vivian.sql.model.MsgModel;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class MessageServiceImpl implements IMessageService {

    @Resource
    public MessageDaoI messageDaoI;

    @Override
    public int insertMessage(MsgModel msgModel) {
        return messageDaoI.insertMessage(msgModel);
    }

    @Override
    public int insertOffLineMessage(MsgModel msgModel) {
        return messageDaoI.insertOffLineMessage(msgModel);
    }

    @Override
    public List<MsgListBean> getUserMsg(int msgToId) {
        return messageDaoI.getUserMsg(msgToId);
    }
}
