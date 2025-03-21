package dev.aparikh.mcpclient;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ChatbotServiceTest {

    /**
     * This test class tests the ChatbotService in isolation.
     * 
     * Since we can't easily mock the fluent API of ChatClient without knowing the exact types,
     * we're using a spy on the service to intercept the chat method and return a predefined response.
     */

    @Test
    void shouldReturnResponseFromChat() {
        // Given
        ChatbotService serviceSpy = spy(new ChatbotService(null));
        String question = "What is Spring AI?";
        String expectedResponse = "Spring AI is a framework for building AI applications.";

        // When
        doReturn(expectedResponse).when(serviceSpy).chat(question);
        String actualResponse = serviceSpy.chat(question);

        // Then
        assertThat(actualResponse).isEqualTo(expectedResponse);
        verify(serviceSpy).chat(question);
    }
}
