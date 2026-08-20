package com.jarvis.agent;

import com.jarvis.ai.AiProvider;

public class Agent {

    private final AiProvider aiProvider;

    public Agent(AiProvider aiProvider) {
        this.aiProvider = aiProvider;
    }

    public String process(String request) {
        return aiProvider.generate(request);
    }

}
