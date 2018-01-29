package com.vivian.websocket;

import com.vivian.constants.SocketParams;
import com.vivian.service.IMessageService;
import com.vivian.service.IUserService;
import com.vivian.sql.model.MsgModel;
import com.vivian.sql.model.SocketModel;
import com.vivian.sql.model.UserSocketBean;
import com.vivian.tools.JsonTools;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.socket.*;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.ArrayList;

@Controller
public class WebSocketHandler implements org.springframework.web.socket.WebSocketHandler {

    private static final Logger logger = Logger.getLogger(WebSocketHandler.class);

    private static final ArrayList<WebSocketSession> users = new ArrayList<>();
    private static final ArrayList<UserSocketBean> userSocketBeans = new ArrayList<>();
    private static final ArrayList<Integer> idOnlineList = new ArrayList<>();

    @Resource
    IMessageService iMessageService;

    // 初次链接成功执行
    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
        logger.debug("链接成功......");
        session.sendMessage(new TextMessage("ServerConnect"));
    }

    // 接受消息处理消息
    @Override
    public void handleMessage(WebSocketSession webSocketSession, WebSocketMessage<?> webSocketMessage) throws Exception {
        String payload = (String) webSocketMessage.getPayload();
        SocketModel bean = JsonTools.getBean(payload, SocketModel.class);
        switch (bean.getSocketType()) {
            case SocketParams.SERVER_CONNECT:
                //连接字符串
                UserSocketBean userSocketBean = JsonTools.getBean(bean.getData().toString(), UserSocketBean.class);
                userSocketBeans.add(userSocketBean);
                idOnlineList.add(userSocketBean.getUserId());
                break;
            case SocketParams.SEND_MESSAGE:
                //发送消息类型,需要判断用户是否在线
                MsgModel msgModel = JsonTools.getBean(bean.getData().toString(), MsgModel.class);
                if (idOnlineList.contains(msgModel.getMsgToId())) {
                    //当前用户在线
                    logger.debug("当前用户在线");
                    //直接调用socket发送
                } else {
                    logger.debug("当前用户不在线,需缓存到离线表");
                    iMessageService.insertOffLineMessage(msgModel);
                }

                break;
        }
        logger.debug("收到用户发送的消息" + payload);
    }

    @Override
    public void handleTransportError(WebSocketSession webSocketSession, Throwable throwable) throws Exception {
        if (webSocketSession.isOpen()) {
            webSocketSession.close();
        }
        logger.debug("链接出错，关闭链接......");
//        users.remove(webSocketSession);
    }

    @Override
    public void afterConnectionClosed(WebSocketSession webSocketSession, CloseStatus closeStatus) throws Exception {
        logger.debug("链接关闭......" + closeStatus.toString());
//        users.remove(webSocketSession);
    }

    @Override
    public boolean supportsPartialMessages() {
        return false;
    }

    /**
     * 给所有在线用户发送消息
     *
     * @param message
     */
    public void sendMessageToUsers(TextMessage message) {
        for (WebSocketSession user : users) {
            try {
                if (user.isOpen()) {
                    user.sendMessage(message);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 给某个用户发送消息
     *
     * @param userName
     * @param message
     */
    public void sendMessageToUser(String userName, TextMessage message) {
        for (WebSocketSession user : users) {
            if (user.getAttributes().get("WEBSOCKET_USERNAME").equals(userName)) {
                try {
                    if (user.isOpen()) {
                        user.sendMessage(message);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;
            }
        }
    }
}
