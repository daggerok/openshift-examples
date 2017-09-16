package daggerok.data;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;
import lombok.experimental.Accessors;
import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.Column;
import javax.persistence.Entity;

@Data
@Entity
@NoArgsConstructor
@Accessors(chain = true)
@RequiredArgsConstructor
@EqualsAndHashCode(callSuper = true)
@JsonIgnoreProperties(ignoreUnknown = true)
public class Message extends Audit {

  private static final long serialVersionUID = 5251173318476126589L;

  @NonNull
  @NotBlank
  @Column(nullable = false)
  String subject, body;
}
