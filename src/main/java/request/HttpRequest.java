package request;

import java.io.IOException;
import java.io.InputStream;
import java.lang.annotation.Annotation;

/**
 * @Author huqi
 * @Description:
 * @Date Create In 14:28 2018/5/29 0029
 */
public class HttpRequest {

    private String url;

    private String method;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }



    public HttpRequest(InputStream in) throws IOException {


        /*
		    GET /girl HTTP/1.1
			Accept: text/html, application/xhtml+xml, image/jxr, *
			Accept-Language: zh-CN
			User-Agent: Mozilla/5.0 (Windows NT 10.0; WOW64; Trident/7.0; rv:11.0) like Gecko
			Accept-Encoding: gzip, deflate
			Host: localhost:8080
			Connection: Keep-Alive
		*/
        String httpRequest="";
        byte[] httpRequestBytes = new byte[1024];
        int leng = 0;
        if((leng=in.read(httpRequestBytes))>0){
            httpRequest = new String(httpRequestBytes,0,leng);
        }
        //获取第一行
        String httpHead = httpRequest.split("\n")[0];
        //以空格分开
        url = httpHead.split("\\s")[1];
        //以空格分开
        method = httpHead.split("\\s")[0];
        System.out.println(this);
    }

    @Override
    public String toString() {
        return "HttpRequest{" +
                "url='" + url + '\'' +
                ", method='" + method + '\'' +
                '}';
    }
}
