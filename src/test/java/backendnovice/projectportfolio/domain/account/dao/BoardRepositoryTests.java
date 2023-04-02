package backendnovice.projectportfolio.domain.account.dao;

import backendnovice.projectportfolio.domain.account.domain.Account;
import backendnovice.projectportfolio.domain.board.dao.PostRepository;
import backendnovice.projectportfolio.domain.board.dao.ReplyRepository;
import backendnovice.projectportfolio.domain.board.domain.Post;
import backendnovice.projectportfolio.domain.board.domain.Reply;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
public class BoardRepositoryTests {
    
    private final AccountRepository accountRepository;
    private final PostRepository postRepository;
    private final ReplyRepository replyRepository;
    
    @Autowired
    public BoardRepositoryTests(AccountRepository accountRepository, PostRepository postRepository, ReplyRepository replyRepository) {
        this.accountRepository = accountRepository;
        this.postRepository = postRepository;
        this.replyRepository = replyRepository;
    }
    
    @Test
    public void insertPostTests() {
        Post post = Post.builder()
                .title("Test Title")
                .content("Test Content")
                .author("Test Author")
                .build();
        
        postRepository.save(post);
    }
    
    @Test
    public void insertPostWithAccount() {
        Account account = accountRepository.findByUsername("test").get();
    
        Post post = Post.builder()
                .title("Test Title")
                .content("Test Content")
                .author(account.getUsername())
                .account(account)
                .build();
    
        postRepository.save(post);
    }
    
    @Test
    public void modifyPostTests() {
        Post post = postRepository.findById(1L).get();
        
        post.setTitle("Test Title Modified");
        post.setContent("Test Content Modified");
        
        postRepository.save(post);
    }
    
    @Test
    @Transactional
    public void deletePostTests() {
        postRepository.deleteById(2L);
    }
    
    @Test
    public void insertReplyTests() {
        Reply reply = Reply.builder()
                .content("Test Reply Content")
                .author("Test Author")
                .build();
        
        replyRepository.save(reply);
    }
    
    @Test
    public void insertReplyTestsWithAccountAndPost() {
        Account account = accountRepository.findByUsername("test").get();
        
        Post post = postRepository.findById(2L).get();
        
        Reply reply = Reply.builder()
                .content("Test Reply Content")
                .author(account.getUsername())
                .account(account)
                .post(post)
                .build();
        
        replyRepository.save(reply);
    }
    
    @Test
    public void modifyReplyTests() {
        Reply reply = replyRepository.findById(1L).get();
        
        reply.setContent("Test Reply Content Modified");
        
        replyRepository.save(reply);
    }
}
