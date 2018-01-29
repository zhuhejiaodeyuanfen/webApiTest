package com.vivian.service;

import com.vivian.sql.model.MsgListBean;
import com.vivian.sql.model.MsgModel;

import java.util.List;

public interface IMessageService {

    int insertMessage(MsgModel msgModel);

    int insertOffLineMessage(MsgModel msgModel);

    List<MsgListBean> getUserMsg(int msgToId);
}
