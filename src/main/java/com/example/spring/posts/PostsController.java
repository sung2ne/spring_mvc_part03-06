package com.example.spring.posts;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class PostsController {
    
    @Autowired
    PostsService postsService;

    // 게시글 등록 (화면, GET)
    @RequestMapping(value = "/posts/create", method = RequestMethod.GET)
    public String create() {
        return "posts/create";
    }

    // 게시글 등록 (처리, POST)
    @RequestMapping(value = "/posts/create", method = RequestMethod.POST)
    public String createPost(PostsVo postsVo, RedirectAttributes redirectAttributes) {
        boolean created = postsService.create(postsVo);

        if (created) {
            redirectAttributes.addFlashAttribute("successMessage", "게시글이 등록되었습니다.");
            return "redirect:/posts/";
        }
        
        redirectAttributes.addFlashAttribute("errorMessage", "게시글 등록에 실패했습니다.");
        return "redirect:/posts/create";
    }
}
