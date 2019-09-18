package com.proadvisor.controller;

import com.proadvisor.model.dto.CommentDto;
import com.proadvisor.model.entity.common.Comment;
import com.proadvisor.model.entity.common.User;
import com.proadvisor.service.CommentService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.validation.Valid;

@RestController
public class CommentController {
    
    @Autowired
    private CommentService commentService;
    
    @PostMapping("/items/{itemId}/comments")
    public void addNewComment(@PathVariable long itemId,
                              @Valid CommentDto commentDto,
                              @AuthenticationPrincipal User user) {
        Comment comment = new Comment();
        BeanUtils.copyProperties(commentDto, comment);
        comment.setUser(user);
        commentService.addNewComment(itemId, comment);
    }
}
