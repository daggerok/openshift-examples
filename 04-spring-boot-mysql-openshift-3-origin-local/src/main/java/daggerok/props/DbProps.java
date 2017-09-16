package daggerok.props;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@Component
@ConfigurationProperties(prefix = "mysql")
public class DbProps {

  String user, password, database;
  Server server;

  @Data
  public static class Server {
    String host;
    Integer port;
  }
}
