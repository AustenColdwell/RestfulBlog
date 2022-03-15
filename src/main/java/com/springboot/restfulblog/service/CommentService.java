package com.springboot.restfulblog.service;

import com.springboot.restfulblog.payload.CommentDto;

import java.util.List;

public interface CommentService {

    CommentDto createComment(long postId, CommentDto commentDto);

    List<CommentDto> getCommentsByPostId(long postId);

    CommentDto getCommentById(long postId, long commentId);

    CommentDto updateComment(Long postId, long commentId, CommentDto commentRequest);

}
