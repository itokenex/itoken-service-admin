package com.funtl.itoken.service.admin.controller;


import com.funtl.itoken.service.admin.domain.Comment;
import com.funtl.itoken.service.admin.service.CommentService;
import com.funtl.itoken.service.admin.mapper.CommentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class CommentController {

    @Autowired
    CommentService userService;

    @Autowired
    CommentMapper commentMapper;
    @RequestMapping("/comment")
    public String getComment(Model model){
        List<Comment> allComment = userService.getAllComment();
        for (Comment comment : allComment) {
            System.out.println(comment);
        }
        /*List<Comment> allComment = commentMapper.selectAll();
        for (Comment comment : allComment) {
            System.out.println(comment);
        }*/
        model.addAttribute("message","什么");
        System.out.println("1111111111111");
        return "comment";
    }
}
