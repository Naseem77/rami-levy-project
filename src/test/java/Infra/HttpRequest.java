package Infra;


import java.util.HashMap;
import java.util.Map;

public class HttpRequest {

        private Method method;
        private String url;
        private String parameters;
        private String body;
        private Map<String, String> headers;

        public HttpRequest(Method method, String url, String parameters, String body) {
            this.method = method;
            this.url = url;
            this.parameters = parameters;
            this.body = body;
            this.headers=new HashMap<>();
        }

        public Method getMethod() {
            return method;
        }

        public String getUrl() {
            return url;
        }

        public String getParameters() {
            return parameters;
        }

        public String getBody() {
            return body;
        }


        public Map<String, String> getHeaders() {
            return headers;
        }

        public void setHeader(String key,String value) {
            this.headers.put(key, value);
        }

}