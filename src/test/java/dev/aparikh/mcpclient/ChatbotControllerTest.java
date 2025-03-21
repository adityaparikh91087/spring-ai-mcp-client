package dev.aparikh.mcpclient;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(MockitoExtension.class)
class ChatbotControllerTest {

    @Mock
    private ChatbotService chatbotService;

    @InjectMocks
    private ChatbotController chatbotController;

    private final ObjectMapper objectMapper = new ObjectMapper();

    @Test
    void shouldReturnChatResponse() throws Exception {
        // Given
        String question = "What is Spring AI?";
        String answer = "Spring AI is a framework for building AI applications.";
        when(chatbotService.chat(question)).thenReturn(answer);

        // When/Then
        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(chatbotController).build();
        mockMvc.perform(post("/chat")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(new ChatbotController.ChatRequest(question))))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.answer").value(answer));
    }

    @Test
    void shouldHandleEmptyQuestion() throws Exception {
        // Given
        String emptyQuestion = "";
        String answer = "I'm not sure what you're asking. Could you please provide more details?";
        when(chatbotService.chat(emptyQuestion)).thenReturn(answer);

        // When/Then
        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(chatbotController).build();
        mockMvc.perform(post("/chat")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(new ChatbotController.ChatRequest(emptyQuestion))))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.answer").value(answer));
    }
}
