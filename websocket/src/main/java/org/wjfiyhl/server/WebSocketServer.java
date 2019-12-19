package org.wjfiyhl.server;

import org.springframework.stereotype.Component;

import javax.websocket.*;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author: WJF
 * @date: 2019/12/19
 */

@Component
/**
 * 使用@ServerEndpoint注解声明了一个WebSocket的dpoint。
 */
@ServerEndpoint(value = "/webSocketServer/{userId}")
public class WebSocketServer {

    private Session session;

    private static ConcurrentMap<String, Session> sessionPool;

    private static ConcurrentMap<String, String> sessionIds;

    private static AtomicInteger onlineCount = new AtomicInteger();

    private static CopyOnWriteArraySet<WebSocketServer> webSocketSet = new CopyOnWriteArraySet<>();


    /**
     * 使用@OnOpen注解：
     * 在客户端初次连接的时候触发，会为客户端创建一个webSocketSession，并不是httpSession，
     * sessionPool存储userId和session的键值对，sessionIds储存sessionId和userId建立关系。
     * @param session
     * @param userId
     */
    @OnOpen
    public void onOpen(Session session, @PathParam("userId") String userId) {
        this.session = session;
        sessionPool.put(userId,session);
        sessionIds.put(session.getId(),userId);
        onlineCount.incrementAndGet(); // 在线人数+1
        webSocketSet.add(this);
    }


    /**
     * 使用@OnMessage注解：
     * 在客户端向服务端发送消息的时候触发此方法，接收客户端发送到服务端的消息。
     * 参数不能为空，message就是客户端发送的消息数据。
     * @param message
     */
    @OnMessage
    public void onMessage(String message) {
        System.out.println("当前发送人的sessionId为：" + session.getId() + "，发送的消息为：" + message);
    }


    /**
     * 使用@OnClose注解：
     * 在客户端和服务端断开连接的时候触发，可以做一些相应的操作。
     * 此处我们移除了客户端和服务端的联系。
     */
    @OnClose
    public void onClose() {
        sessionPool.remove(sessionIds.get(session.getId()));
        sessionIds.remove(session.getId());
        onlineCount.decrementAndGet(); // 在线人数-1
        webSocketSet.remove(this);
    }


    /**
     * 使用@OnError注解：
     * 在出现错误的时候触发。
     */
    @OnError
    public void onError(Session session, Throwable error) {
        error.printStackTrace();
    }


    /**
     * 调用当前用户对应的session获取基本的远程连接给客户端发送消息。
     * @param userId
     * @param message
     * @throws IOException
     */
    public void sendMessage(String userId, String message) {
        Session session = sessionPool.get(userId);
        try {
            session.getBasicRemote().sendText(message);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    /**
     * 获取在线用户个数，有多少个session，就有多少用户。
     * @return Integer
     */
    public static Integer getOnlineNum() {
        return onlineCount.get();
    }


    /**
     * 获取所有的在线用户。
     * @return String
     */
    public static String getOnlineUsers() {
        StringBuffer buffer = new StringBuffer();
        for (String sessionId : sessionIds.keySet()) {
            buffer.append(sessionIds.get(sessionId));
        }
        return buffer.toString();
    }


    /**
     * 向所有在线用户发送消息。
     */
    public void sendAll(String message) {
        for (String userId : sessionPool.keySet()) {
            this.sendMessage(userId,message);
        }
    }

}
