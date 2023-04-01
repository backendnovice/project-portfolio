package backendnovice.projectportfolio.domain.board.controller;

import backendnovice.projectportfolio.domain.board.application.PostService;
import backendnovice.projectportfolio.domain.board.domain.Post;
import backendnovice.projectportfolio.domain.board.dto.PostDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Optional;

@Controller
@RequestMapping("/board")
public class BoardController {
    private final PostService postService;
    
    @Autowired
    public BoardController(PostService postService) {
        this.postService = postService;
    }
    
    @GetMapping("/list")
    public String getListPost() {
        return "/board/list";
    }
    
    @GetMapping("/read")
    public String getReadPost(@ModelAttribute PostDTO postDTO, Model model, RedirectAttributes redirectAttributes) {
        PostDTO result = postService.readPostProcess(postDTO);
        
        if(result.getId() != null) {
            model.addAttribute("post", result);
            return "redirect:/board/read";
        }else {
            redirectAttributes.addFlashAttribute("message", "게시글이 존재하지 않습니다.");
            return "redirect:/board/list";
        }
    }
    
    @GetMapping("/write")
    public String getWritePost() {
        return "/board/write";
    }
    
    @PostMapping("/write")
    public String postWritePost(@ModelAttribute PostDTO postDTO, RedirectAttributes redirectAttributes) {
        postService.writePostProcess(postDTO);
        
        redirectAttributes.addFlashAttribute("message", "게시글이 등록되었습니다.");
        
        return "redirect:/board/list";
    }
    
    
    
}
