package com.funtl.itoken.service.admin.service;

import com.funtl.itoken.service.admin.domain.Comment;
import com.funtl.itoken.service.admin.mapper.CommentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentService {
    @Autowired
    private CommentMapper commentMapper;

    public List<Comment> getAllComment(){
        List<Comment> lists = commentMapper.selectAll();
        return lists;
    }




}
