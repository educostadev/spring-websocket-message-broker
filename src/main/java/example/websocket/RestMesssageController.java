package example.websocket;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class RestMesssageController {

    @Autowired
    WebSocketService service;

    @PostMapping(path = "/v1/{toUser}")
    void sendMessage(@RequestBody String message, @PathVariable String toUser) {
        log.info("Rest send message {} to user {}", message, toUser);
        service.notifyUser(toUser, message);
    }
}
