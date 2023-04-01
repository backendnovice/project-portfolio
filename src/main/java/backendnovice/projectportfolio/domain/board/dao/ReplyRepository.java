package backendnovice.projectportfolio.domain.board.dao;

import backendnovice.projectportfolio.domain.board.domain.Reply;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReplyRepository extends JpaRepository<Reply, Long> {
    
}