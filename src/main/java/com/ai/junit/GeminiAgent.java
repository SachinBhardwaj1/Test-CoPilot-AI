package com.ai.junit;

import okhttp3.*;
import java.io.IOException;

public class GeminiAgent {
    private static final String API_KEY = System.getenv("GEMINI_API_KEY");
    private static final String ENDPOINT = "https://generativelanguage.googleapis.com/v1beta/models/gemini-pro:generateContent?key=";

    public static String generateTest(String method, String className) throws IOException {
        String prompt = "Write a JUnit 5 test class for the following Java method from class \"" + className + "\":\n\n" + method;

        String requestBody = "{\n" +
                "  \"contents\": [\n" +
                "    {\n" +
                "      \"parts\": [\n" +
                "        {\n" +
                "          \"text\": \"" + escapeJson(prompt) + "\"\n" +
                "        }\n" +
                "      ]\n" +
                "    }\n" +
                "  ]\n" +
                "}";

        if (API_KEY == null || API_KEY.isEmpty()) {
            throw new IllegalStateException("❌ GEMINI_API_KEY environment variable not set.");
        }

        Request request = new Request.Builder()
                .url(ENDPOINT + API_KEY)
                .post(RequestBody.create(requestBody, MediaType.get("application/json")))
                .build();

        OkHttpClient client = new OkHttpClient();
        try (Response response = client.newCall(request).execute()) {
            if (!response.isSuccessful()) {
                throw new IOException("❌ API Error: " + response.code() + " - " + response.body().string());
            }
            return response.body().string();
        }
    }

    private static String escapeJson(String input) {
        return input.replace("\"", "\\\"").replace("\n", "\\n");
    }
}
