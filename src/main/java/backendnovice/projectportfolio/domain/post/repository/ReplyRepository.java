package backendnovice.projectportfolio.domain.post.repository;

import backendnovice.projectportfolio.domain.post.domain.ReplyEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReplyRepository extends JpaRepository<ReplyEntity, Long> {
    
}