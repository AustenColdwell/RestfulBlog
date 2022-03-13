package com.springboot.restfulblog.service;

import com.springboot.restfulblog.payload.PostDto;

import java.util.List;

public interface PostService {
    PostDto createPost(PostDto postDto);
    List<PostDto> getAllPosts();
}
