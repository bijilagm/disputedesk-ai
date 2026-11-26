package com.bijila.disputedesk;

import org.junit.jupiter.api.Test;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;

@SpringBootTest
class DisputedeskApplicationTests {

	@MockitoBean
	ChatClient chatClient;

	@Test
	void contextLoads() {
	}

}
