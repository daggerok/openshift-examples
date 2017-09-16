package daggerok.data;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@RepositoryRestResource
public interface MessageRestRepository extends JpaRepository<Message, Long> {

  Optional<Message> findFirstBySubject(@Param("subject") final String subject);
  Optional<Message> findFirstByBody(@Param("body") final String body);
  Optional<Message> findFirstById(@Param("id") final Long id);

  List<Message> findAllBySubjectContainsIgnoreCase(@Param("subject") final String subject);
  List<Message> findAllByBodyContainsIgnoreCase(@Param("body") final String body);

  List<Message> findAllByOrderByCreatedAtAsc();
  List<Message> findAllByOrderByCreatedDateDesc();
  List<Message> findAllByOrderByModifiedAtDesc();
}
