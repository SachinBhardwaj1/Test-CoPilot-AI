package com.ai.junit;

import okhttp3.*;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;

public class OpenAIAgent {
    private static final String API_KEY = System.getenv("OPENAI_API_KEY");
    private static final String ENDPOINT = "https://api.openai.com/v1/chat/completions";
    private static final MediaType JSON = MediaType.get("application/json");

    public static String generateTest(String method, String className) throws IOException {
        if (API_KEY == null || API_KEY.isEmpty()) {
            throw new IllegalStateException("❌ OPENAI_API_KEY environment variable is not set.");
        }

        // Prompt to send to GPT
        String prompt = "Write a JUnit 5 test class for the following method in class " + className + ":\n\n" + method;

        // Use org.json to construct JSON safely
        JSONObject message = new JSONObject()
                .put("role", "user")
                .put("content", prompt);
        JSONArray messages = new JSONArray().put(message);
        JSONObject requestBody = new JSONObject()
                .put("model", "gpt-3.5-turbo")
                .put("messages", messages);

        // Build request
        Request request = new Request.Builder()
            .url(ENDPOINT)
            .post(RequestBody.create(requestBody.toString(), JSON))
            .addHeader("Authorization", "Bearer " + API_KEY)
            .build();

        // Execute and return result
        OkHttpClient client = new OkHttpClient();
        try (Response response = client.newCall(request).execute()) {
            if (!response.isSuccessful()) {
                throw new IOException("❌ API Error: " + response.code() + " - " + response.body().string());
            }
            return response.body().string();
        }
    }
}
