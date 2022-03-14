package com.springboot.restfulblog.service;

import com.springboot.restfulblog.payload.CommentDto;

public interface CommentService {

    CommentDto createComment(long postId, CommentDto commentDto);

}
