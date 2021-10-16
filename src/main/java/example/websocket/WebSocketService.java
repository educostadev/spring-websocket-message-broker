package example.websocket;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.*;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class WebSocketService {

    private final SimpMessagingTemplate messagingTemplate;


    public void notifyUser(final String userId, final String message) {
        this.send(userId, message);
    }

    @SneakyThrows
    private void send(String userId, String message) {
        String json = (new ObjectMapper()).writeValueAsString(new WebSocketResponseMessage(message));
        messagingTemplate.convertAndSendToUser(userId, "/topic/messages", json);
    }

    @Getter
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor
    public static class WebSocketResponseMessage {

        private String content;

    }

}
