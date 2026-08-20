package com.jarvis.ai;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient;

import java.util.Map;

@Component
public class OllamaAiProvider implements AiProvider{

    private final String baseUrl;
    private final String model;
    private final RestClient restClient;

    public OllamaAiProvider(
            @Value("${jarvis.ai.ollama.base-url}") String baseUrl,
            @Value("${jarvis.ai.ollama.model}") String model) {
        this.baseUrl = baseUrl;
        this.model = model;
        this.restClient = RestClient.builder()
                .baseUrl(baseUrl)
                .build();
    }

    @Override
    public String generate(String prompt) {
        Map<String, Object> request = Map.of(
                "model", model,
                "prompt", prompt,
                "stream", false
        );

        Map<String, Object> response = restClient.post()
                .uri("/api/generate")
                .body(request)
                .retrieve()
                .body(Map.class);

        return (String) response.get("response");
    }
}
