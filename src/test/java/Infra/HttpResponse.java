package Infra;


import java.util.Map;


public class HttpResponse<T> {

    private int status;
    private Map<String, String> responseHeaders;
    private T data;

    public HttpResponse(int status, Map<String, String> responseHeaders,
                        T data) {
        this.status = status;
        this.responseHeaders = responseHeaders;
        this.data = data;
    }



    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Map<String, String> getResponseHeaders() {
        return responseHeaders;
    }

    public void setResponseHeaders(Map<String, String> responseHeaders) {
        this.responseHeaders = responseHeaders;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
