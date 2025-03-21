package dev.aparikh.mcpclient;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.model.ChatModel;
import org.springframework.ai.mcp.SyncMcpToolCallbackProvider;
import org.springframework.ai.tool.ToolCallback;

import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ChatbotConfigurationTest {

    /**
     * This test verifies that the ChatbotConfiguration correctly creates a ChatClient.
     * 
     * Note: This test is simplified and doesn't test the full functionality of the ChatClient.
     * In a real-world scenario, we would want to test that the ChatClient is configured correctly
     * with the expected tools and settings.
     */
    @Test
    void shouldCreateChatClient() {
        // Given
        ChatModel chatModel = mock(ChatModel.class);
        SyncMcpToolCallbackProvider toolCallbackProvider = mock(SyncMcpToolCallbackProvider.class);

        // Mock the toolCallbackProvider to return a non-null array of tool callbacks
        when(toolCallbackProvider.getToolCallbacks()).thenReturn(new ToolCallback[0]);

        ChatbotConfiguration configuration = new ChatbotConfiguration();

        // When
        ChatClient chatClient = configuration.chatClient(chatModel, toolCallbackProvider);

        // Then
        assertThat(chatClient).isNotNull();
    }
}
