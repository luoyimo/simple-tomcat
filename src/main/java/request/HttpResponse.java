package request;

import java.io.IOException;
import java.io.OutputStream;

/**
 * @Author huqi
 * @Description:
 * @Date Create In 14:33 2018/5/29 0029
 */
public class HttpResponse {

    private OutputStream outputStream;

    public HttpResponse(OutputStream outputStream) {
        this.outputStream = outputStream;
    }
    public void write(String content)throws IOException {
        StringBuffer httpResponse = new StringBuffer();
        httpResponse.append("HTTP/1.1 200 OK\n")
                .append("Content-Type: text/html\n")
                .append("\r\n")
                .append("<html><body>")
                .append(content)
                .append("</body></html>");
        outputStream.write(httpResponse.toString().getBytes());
        outputStream.close();
    }
}
