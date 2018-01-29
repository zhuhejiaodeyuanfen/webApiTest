package com.vivian.dao;

import com.vivian.sql.model.MsgListBean;
import com.vivian.sql.model.MsgModel;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MessageDaoI {

    int insertMessage(MsgModel msgModel);

    int insertOffLineMessage(MsgModel msgModel);

    List<MsgListBean> getUserMsg(int msgToId);
}
