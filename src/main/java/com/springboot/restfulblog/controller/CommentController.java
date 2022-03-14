package com.springboot.restfulblog.controller;

import com.springboot.restfulblog.payload.CommentDto;
import com.springboot.restfulblog.service.CommentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/")
public class CommentController {

    private CommentService commentService;

    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    //========== CREATE ==========
    @PostMapping("/post/{postId}/comment")
    public ResponseEntity<CommentDto> createComment(
            @PathVariable(value = "postId") long postId,
            @RequestBody CommentDto commentDto)
    {
        return new ResponseEntity<>(commentService.createComment(postId, commentDto), HttpStatus.CREATED);
    }

    //========== READ ==========
    @GetMapping("/post/{postId}/comment")
    public List<CommentDto> getCommentsByPostId(
            @PathVariable(value = "postId") Long postId)
    {
        return commentService.getCommentsByPostId(postId);
    }

    @GetMapping("/post/{postId}/comment/{commentId}")
    public ResponseEntity<CommentDto> getCommentById(
            @PathVariable(value = "postId") Long postId,
            @PathVariable(value = "commentId") Long commentId)
    {
        CommentDto commentDto = commentService.getCommentById(postId, commentId);

        return new ResponseEntity<>(commentDto, HttpStatus.OK);
    }
}
