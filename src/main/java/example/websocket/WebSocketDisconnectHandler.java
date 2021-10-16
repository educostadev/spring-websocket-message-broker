package example.websocket;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationListener;
import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.web.socket.messaging.SessionDisconnectEvent;

import java.util.Optional;

@Slf4j
public class WebSocketDisconnectHandler<S> implements ApplicationListener<SessionDisconnectEvent> {

    public WebSocketDisconnectHandler(SimpMessageSendingOperations messagingTemplate) {
        super();
    }

    @Override
    public void onApplicationEvent(SessionDisconnectEvent event) {
        Optional.ofNullable(event.getUser()).ifPresent(user ->
                log.info("USer {} disconnected from session id {}", user.getName(), event.getSessionId())
        );
    }
}