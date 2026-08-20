package com.jarvis.agent;

import com.jarvis.ai.AiProvider;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class AgentTest {

    @Test
    void shouldProcessRequest() {

        AiProvider aiProvider = prompt -> "test response";

        Agent agent = new Agent(aiProvider);

        String response = agent.process("Hello");

        assertEquals("test response", response);
    }

}
