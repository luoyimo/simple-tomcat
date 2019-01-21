import request.HttpRequest;
import request.HttpResponse;
import servlet.AbstractServlet;
import servlet.TestServlet;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author huqi
 * @Description:
 * @Date Create In 14:23 2018/5/29 0029
 */
public class Starter {

    private int port = 8080;
    private Map<String, String> urlServletMap = new HashMap<String, String>();

    public Starter(int port) {
        this.port = port;
    }

    public void start() {
        //初始化url与对应处理的servlet的关系
        initServletMapping();
        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(port);
            System.out.println("MyTomcat is start...");
            while (true) {
                Socket socket = serverSocket.accept();
                InputStream inputStream = socket.getInputStream();
                OutputStream outputStream = socket.getOutputStream();
                HttpRequest myRequest = new HttpRequest(inputStream);
                HttpResponse myResponse = new HttpResponse(outputStream);
                dispatch(myRequest, myResponse);
                socket.close();
            }
        } catch (Exception e) {
            // TODO: handle exception
        }
    }

    public static void main(String[] args) throws ClassNotFoundException {
        new Starter(8080).start();
    }

    public void initServletMapping() {
        urlServletMap.put("/test", "servlet.TestServlet");
    }

    public void dispatch(HttpRequest myRequest, HttpResponse myResponse) {
        String clazz = urlServletMap.get(myRequest.getUrl());
        try {
            Class<AbstractServlet> myServletClass = (Class<AbstractServlet>) Class.forName(clazz);
            AbstractServlet myServlet = myServletClass.newInstance();
            myServlet.service(myRequest, myResponse);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
