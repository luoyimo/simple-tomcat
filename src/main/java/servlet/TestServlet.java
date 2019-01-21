package servlet;

import request.HttpRequest;
import request.HttpResponse;

import java.io.IOException;

/**
 * @Author huqi
 * @Description:
 * @Date Create In 14:43 2018/5/29 0029
 */
public class TestServlet extends AbstractServlet {
    @Override
    public void doGet(HttpRequest myRequest, HttpResponse myResponse) {
        try {
            myResponse.write("get world...");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void doPost(HttpRequest myRequest, HttpResponse myResponse) {
        try {
            myResponse.write("post world...");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
