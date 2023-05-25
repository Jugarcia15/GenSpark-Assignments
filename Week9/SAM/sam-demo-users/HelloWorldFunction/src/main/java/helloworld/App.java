package helloworld;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.stream.Collectors;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.amazonaws.services.lambda.runtime.events.APIGatewayProxyRequestEvent;
import com.amazonaws.services.lambda.runtime.events.APIGatewayProxyResponseEvent;
import com.google.gson.Gson;

/**
 * Handler for requests to Lambda function.
 */
public class App implements RequestHandler<APIGatewayProxyRequestEvent, APIGatewayProxyResponseEvent> {
// original code
//    public APIGatewayProxyResponseEvent handleRequest(final APIGatewayProxyRequestEvent input, final Context context) {
//        String requestBody = input.getBody();
//        Gson gson = new Gson();
//
//        Map<String, String> userDetails = gson.fromJson(requestBody, Map.class);
//        userDetails.put("userId", UUID.randomUUID().toString());
//
//        Map returnValue = new HashMap();
//        returnValue.put("Name", userDetails.get("Name"));
//        returnValue.put("userId", userDetails.get("userId"));
//
//        APIGatewayProxyResponseEvent response = new APIGatewayProxyResponseEvent();
//        response.withStatusCode(200);
//        response.withBody(gson.toJson(returnValue, Map.class));
//
//        Map responseHeader = new HashMap<>();
//        responseHeader.put("Content-Type", "application/json");
//
//        response.withHeaders(responseHeader);
//        return response;
//    }
    public APIGatewayProxyResponseEvent handleRequest(final APIGatewayProxyRequestEvent input, final Context context){
        String httpMethod = input.getHttpMethod();
        Gson gson = new Gson();
        switch(httpMethod){
            case"GET":
                return handleGetRequest(input);
            case"POST":
                return handlePostRequest(input);
            case"PUT":
                return handlePutRequest(input);
            default:
                return new APIGatewayProxyResponseEvent()
                        .withStatusCode(400)
                        .withBody("Invalid HTTP method");
        }
    }
    private APIGatewayProxyResponseEvent handleGetRequest(APIGatewayProxyRequestEvent input){
        // Implement logic for GET method here
        String userId = UUID.randomUUID().toString();

        // Construct the response body
        Map<String, String> returnValue = new HashMap<>();
        returnValue.put("userId", userId);

        // Create an instance of APIGatewayProxyResponseEvent
        APIGatewayProxyResponseEvent response = new APIGatewayProxyResponseEvent();
        response.withStatusCode(200);
        response.withBody(new Gson().toJson(returnValue));

        // Set the response headers
        Map<String, String> responseHeaders = new HashMap<>();
        responseHeaders.put("Content-Type", "application/json");
        response.withHeaders(responseHeaders);

        // Return the response
        return response;
    }
    private APIGatewayProxyResponseEvent handlePostRequest(APIGatewayProxyRequestEvent input){
        String requestBody = input.getBody();
        Gson gson = new Gson();

        Map<String, String> userDetails = gson.fromJson(requestBody, Map.class);
        userDetails.put("userId", UUID.randomUUID().toString());

        Map returnValue = new HashMap();
        returnValue.put("Name", userDetails.get("Name"));
        returnValue.put("userId", userDetails.get("userId"));

        APIGatewayProxyResponseEvent response = new APIGatewayProxyResponseEvent();
        response.withStatusCode(200);
        response.withBody(gson.toJson(returnValue, Map.class));

        Map responseHeader = new HashMap<>();
        responseHeader.put("Content-Type", "application/json");

        response.withHeaders(responseHeader);
        return response;
    }
    private APIGatewayProxyResponseEvent handlePutRequest(APIGatewayProxyRequestEvent input){
        // Implement logic for PUT method here
        String requestBody = input.getBody();
        Gson gson = new Gson();

        Map<String, String> userDetails = gson.fromJson(requestBody, Map.class);
        //userDetails.put("userId", UUID.randomUUID().toString());

        APIGatewayProxyResponseEvent response = new APIGatewayProxyResponseEvent();
        Map<String, String> responseBody = new HashMap<>();
        responseBody.put("message" , "PUT request received");
        response.setStatusCode(200);
        response.setBody(gson.toJson(responseBody));

        Map<String, String> responseHeaders = new HashMap<>();
        responseHeaders.put("Content-Type", "application/json");
        response.withHeaders(responseHeaders);

        return response;
    }

}
