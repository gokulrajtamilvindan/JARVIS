package com.jarvis.ai;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/ai")
public class AiController {

    private final AiProvider aiProvider;

    public AiController(AiProvider aiProvider) {
        this.aiProvider = aiProvider;
    }

    @PostMapping("/generate")
    public String generate(@RequestBody String prompt) {
        return aiProvider.generate(prompt);
    }

}
