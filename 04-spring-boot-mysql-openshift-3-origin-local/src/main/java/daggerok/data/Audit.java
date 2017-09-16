package daggerok.data;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AccessLevel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Setter;
import lombok.experimental.Accessors;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;

import static com.fasterxml.jackson.databind.util.StdDateFormat.DATE_FORMAT_STR_ISO8601;
import static javax.persistence.GenerationType.IDENTITY;
import static org.springframework.format.annotation.DateTimeFormat.ISO.DATE;
import static org.springframework.format.annotation.DateTimeFormat.ISO.DATE_TIME;

@Data
@MappedSuperclass
@Accessors(chain = true)
@EqualsAndHashCode(exclude = "id")
@JsonIgnoreProperties(ignoreUnknown = true)
@EntityListeners(AuditingEntityListener.class)
public class Audit implements Serializable {

  private static final long serialVersionUID = 3120233726836391183L;

  @Id
  @GeneratedValue(strategy = IDENTITY)
  Long id;

  @CreatedDate
  @DateTimeFormat(iso = DATE)
  @Column(nullable = false, columnDefinition = "date")
  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd", timezone = "UTC")
  LocalDate createdDate;

  @LastModifiedDate
  @DateTimeFormat(iso = DATE_TIME)
  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = DATE_FORMAT_STR_ISO8601, timezone = "UTC")
  @Column(nullable = false, columnDefinition = "timestamp")
  ZonedDateTime modifiedAt;

  @CreatedBy
  @JsonIgnore
  String createdBy;

  @JsonIgnore
  @LastModifiedBy
  String lastModifiedBy;

  @Column(nullable = false)
  @Setter(AccessLevel.PRIVATE)
  @DateTimeFormat(iso = DATE_TIME)
  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", timezone = "UTC")
  ZonedDateTime createdAt = ZonedDateTime.now();
}
