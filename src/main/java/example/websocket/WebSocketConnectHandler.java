package example.websocket;


import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationListener;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.web.socket.messaging.SessionConnectEvent;

import java.security.Principal;

import static java.util.Optional.ofNullable;

@Slf4j
public class WebSocketConnectHandler<S> implements ApplicationListener<SessionConnectEvent> {

    public WebSocketConnectHandler(SimpMessageSendingOperations messagingTemplate) {
        super();
    }

    @Override
    public void onApplicationEvent(SessionConnectEvent event) {
        ofNullable(readUser(event)).ifPresent(user -> log(event, user));
    }

    private void log(SessionConnectEvent event, Principal user) {
        String sessionId = readSessionId(event);
        log.info("User {} connected to session id {}", user.getName(), sessionId);
    }

    String readSessionId(SessionConnectEvent event) {
        return SimpMessageHeaderAccessor.getSessionId(event.getMessage().getHeaders());
    }

    Principal readUser(SessionConnectEvent event) {
        MessageHeaders headers = event.getMessage().getHeaders();
        return SimpMessageHeaderAccessor.getUser(headers);
    }

}
