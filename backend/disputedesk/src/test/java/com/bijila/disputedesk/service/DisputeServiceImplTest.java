package com.bijila.disputedesk.service;

import com.bijila.disputedesk.dto.DisputeExtraction;
import com.bijila.disputedesk.dto.DisputeRequest;
import com.bijila.disputedesk.enums.DisputeCategory;
import com.bijila.disputedesk.enums.Urgency;
import com.bijila.disputedesk.service.impl.DisputeServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.core.io.ByteArrayResource;

import java.math.BigDecimal;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class DisputeServiceImplTest {

    @Test
    void analyzeMapsChatClientEntity() {
        ChatClient chatClient = mock(ChatClient.class);
        ChatClient.ChatClientRequestSpec requestSpec = mock(ChatClient.ChatClientRequestSpec.class);
        ChatClient.CallResponseSpec responseSpec = mock(ChatClient.CallResponseSpec.class);
        DisputeExtraction expected = new DisputeExtraction(
                "Amazon", new BigDecimal("89.99"), LocalDate.of(2026, 11, 3),
                DisputeCategory.DUPLICATE_CHARGE, Urgency.MEDIUM);

        when(chatClient.prompt(any(Prompt.class))).thenReturn(requestSpec);
        when(requestSpec.call()).thenReturn(responseSpec);
        when(responseSpec.entity(DisputeExtraction.class)).thenReturn(expected);

        DisputeServiceImpl service = new DisputeServiceImpl(chatClient,
                new ByteArrayResource("{complaint}".getBytes()));

        DisputeExtraction result = service.analyze(new DisputeRequest("C001", "Amazon charged twice"));

        assertEquals(expected, result);
    }
}
