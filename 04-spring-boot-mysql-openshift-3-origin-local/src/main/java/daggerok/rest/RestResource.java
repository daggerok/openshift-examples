package daggerok.rest;

import daggerok.data.Message;
import daggerok.data.MessageRestRepository;
import daggerok.props.AppProps;
import daggerok.props.DbProps;
import lombok.RequiredArgsConstructor;
import lombok.val;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import java.time.LocalDateTime;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Stream;

@RestController
@RequiredArgsConstructor
public class RestResource {

  final DbProps dbProps;
  final AppProps appProps;
  final MessageRestRepository repo;

  @PostConstruct
  public void init() {

    val id = new AtomicLong();

    Stream.of("one", "1", "2", "two")
          .map(s -> new Message("" + id.incrementAndGet(), s))
          .forEach(repo::save);
  }

  @GetMapping("/message")
  public Map<String, String> getMessage() {
    return Collections.singletonMap("message", appProps.getMessage());
  }

  @GetMapping("/config")
  public Map<String, Object> getMysqlConfig() {
    return Collections.singletonMap("mysql.config", dbProps);
  }

  @GetMapping("/")
  public Map<String, Object> get() {
    return Collections.singletonMap("data", LocalDateTime.now());
  }
}
