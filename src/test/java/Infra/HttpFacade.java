package Infra;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;

public class HttpFacade {


    public static HttpResponse sendHttpRequest(HttpRequest request) throws IOException {
        URL url = new URL(request.getUrl() + (request.getParameters() != null ? "?" + request.getParameters() : ""));
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();

        try {
            connection.setRequestMethod(request.getMethod().toString());

            // Set additional headers if needed
            if(!request.getHeaders().isEmpty()){
                for(String header:request.getHeaders().keySet()){
                    connection.setRequestProperty(header,request.getHeaders().get(header));
                }
            }

            // Handle request body
            if (request.getBody() != null && !request.getBody().isEmpty()) {
                connection.setDoOutput(true);
                try (OutputStream os = connection.getOutputStream()) {
                    byte[] input = request.getBody().getBytes(StandardCharsets.UTF_8);
                    os.write(input, 0, input.length);
                }
            }

            // Get the response
            int responseCode = connection.getResponseCode();
            StringBuilder responsebody = new StringBuilder();

            try (BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()))) {
                String line;
                while ((line = in.readLine()) != null) {
                    responsebody.append(line);
                }
            }
            HttpResponse httpResponse=new HttpResponse<>(responseCode,null,responsebody.toString());

            // Handle the response code as needed
            if (responseCode >199&&responseCode<300){
                return httpResponse;
            } else {
                throw new IOException("HTTP request failed with response code: " + responseCode);
            }
        } finally {
            connection.disconnect();
        }
    }
}

