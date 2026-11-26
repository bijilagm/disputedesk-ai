package com.bijila.disputedesk.service.impl;

import com.bijila.disputedesk.dto.DisputeExtraction;
import com.bijila.disputedesk.dto.DisputeRequest;
import com.bijila.disputedesk.service.DisputeService;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.prompt.PromptTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

@Service
public class DisputeServiceImpl implements DisputeService {

    private final ChatClient chatClient;
    private final Resource promptResource;

    public DisputeServiceImpl(ChatClient chatClient,
                              @Value("classpath:/prompts/extract-v1.st") Resource promptResource) {
        this.chatClient = chatClient;
        this.promptResource = promptResource;
    }

    @Override
    public DisputeExtraction analyze(DisputeRequest request) {
        PromptTemplate promptTemplate = new PromptTemplate(promptResource);
        var prompt = promptTemplate.create(java.util.Map.of("complaint", request.text()));

        return chatClient.prompt(prompt).call().entity(DisputeExtraction.class);
    }
}
