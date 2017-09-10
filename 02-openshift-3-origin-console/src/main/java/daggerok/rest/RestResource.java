package daggerok.rest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.Map;

@RestController
public class RestResource {

  @Value("${app.message}") String message;

  @GetMapping("/message")
  public Map<String, String> getMessage() {
    return Collections.singletonMap("message", message);
  }

  @GetMapping("/")
  public Map<String, Object> get() {
    return Collections.singletonMap("data", LocalDateTime.now());
  }
}
