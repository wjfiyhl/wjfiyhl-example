package org.wjfiyhl.utils;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author: WJF
 * @date: 2019/12/25
 */

public class SocketUtils {

    public static void sendServer(Socket client, String message, boolean isShutdownOutput) throws IOException {
        OutputStream os = client.getOutputStream();
        byte[] messageBytes = message.getBytes("UTF-8");
        InputStream is = new ByteArrayInputStream(messageBytes);
        int len;
        byte[] bytes = new byte[1024];
        while ((len = is.read(bytes)) != -1) {
            os.write(bytes,0,len);
        }
        if (isShutdownOutput) {
            client.shutdownOutput();
        }
    }


    public static String clientAccept(Socket client) throws IOException {
        InputStream is = client.getInputStream();
        String message = "";
        int len;
        byte[] bytes = new byte[1024];
        while ((len = is.read(bytes)) != -1) {
            message = new String(bytes,0,len);
        }
        return message;
    }


    public static void sendClient(ServerSocket server, String message) throws IOException {
        Socket client = server.accept();
        sendServer(client,message,false);
    }


    public static String serverAccept(ServerSocket server) throws IOException {
        Socket client = server.accept();
        return clientAccept(client);
    }


    public static void close(Object obj) throws IOException {
        if (obj instanceof ServerSocket) {
            ServerSocket server = (ServerSocket) obj;
            server.close();
        } else if (obj instanceof Socket) {
            Socket client = (Socket) obj;
            client.close();
        }
    }
}
