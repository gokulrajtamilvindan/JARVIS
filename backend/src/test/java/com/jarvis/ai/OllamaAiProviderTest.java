package com.jarvis.ai;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;

class OllamaAiProviderTest {

    @Test
    void shouldGenerateResponseFromOllama() {
        OllamaAiProvider provider = new OllamaAiProvider(
                "http://localhost:11434",
                "llama3.2:3b"
        );

        String response = provider.generate("Reply with exactly: Jarvis integration test successful.");

        assertFalse(response.isBlank());
    }

}
