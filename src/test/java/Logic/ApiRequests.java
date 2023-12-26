package Logic;

import Infra.HttpRequest;
import Infra.HttpResponse;
import Infra.Method;
import Infra.PropertiesWrapper;

import java.io.IOException;

import static Infra.HttpFacade.sendHttpRequest;


public class ApiRequests {
        private String baseUrl;
        private PropertiesWrapper propertiesWrapper;

        public ApiRequests(){
            propertiesWrapper = new PropertiesWrapper();
            baseUrl = propertiesWrapper.getProperties("BaseURL");
        }

        public int removeAllItemsFromCart(){
            HttpRequest postRequest = new HttpRequest(Method.PUT, "https://www-api.rami-levy.co.il/api/v2/site/cart/delete", null, null);
            postRequest.setHeader("Ecomtoken",propertiesWrapper.getProperties("token"));
            postRequest.setHeader("Host","www.rami-levy.co.il");
            postRequest.setHeader("Content-Length","154");
            postRequest.setHeader("Content-Type", "application/json");

            HttpResponse response = null;
            try {
                response = sendHttpRequest(postRequest);
            } catch (IOException e) {
                System.out.println(e);
            }
            return response.getStatus();
        }

        public HttpResponse addToCart(String itemId){
                String requestBody = String.format("""
            {
                "store": 331,
                "isClub": 0,
                "supplyAt": "2023-12-24T18:55:50.956Z",
                "items": {
                    "%s": "1.00"
                },
                "meta": null
            }
            """, itemId);

            HttpRequest postRequest = new HttpRequest(Method.POST, baseUrl+"api/v2/cart", null, requestBody);
            postRequest.setHeader("Ecomtoken",propertiesWrapper.getProperties("token"));
            postRequest.setHeader("Host","www.rami-levy.co.il");
            postRequest.setHeader("Content-Length","154");
            postRequest.setHeader("Content-Type", "application/json");

            HttpResponse response = null;
            try {
                response = sendHttpRequest(postRequest);
            } catch (IOException e) {
                System.out.println(e);
            }
            return response;
        }

}
