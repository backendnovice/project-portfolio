package backendnovice.projectportfolio.domain.board.dao;

import backendnovice.projectportfolio.domain.board.domain.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {

}