package com.springboot.restfulblog.service;

import com.springboot.restfulblog.payload.PostDto;

public interface PostService {
    PostDto createPost(PostDto postDto);
}
