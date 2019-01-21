package servlet;

import request.HttpRequest;
import request.HttpResponse;

/**
 * @Author huqi
 * @Description:
 * @Date Create In 14:24 2018/5/29 0029
 */
public abstract class AbstractServlet {

    public abstract void doGet(HttpRequest myRequest, HttpResponse myResponse);

    public abstract void doPost(HttpRequest myRequest, HttpResponse myResponse);

    public void service(HttpRequest myRequest, HttpResponse myResponse) {
        if ("GET".equalsIgnoreCase(myRequest.getMethod())) {
            doGet(myRequest, myResponse);
        } else if ("POST".equalsIgnoreCase(myRequest.getMethod())) {
            doPost(myRequest, myResponse);
        }
    }


}
