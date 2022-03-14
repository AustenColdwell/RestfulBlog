package com.springboot.restfulblog.service.impl;

import com.springboot.restfulblog.entity.Comment;
import com.springboot.restfulblog.entity.Post;
import com.springboot.restfulblog.exception.ResourceNotFoundException;
import com.springboot.restfulblog.payload.CommentDto;
import com.springboot.restfulblog.repos.CommentRepository;
import com.springboot.restfulblog.repos.PostRepository;
import com.springboot.restfulblog.service.CommentService;
import org.springframework.stereotype.Service;

@Service
public class CommentServiceImpl implements CommentService {

    private CommentRepository commentRepository;
    private PostRepository postRepository;

    public CommentServiceImpl(CommentRepository commentRepository, PostRepository postRepository) {
        this.commentRepository = commentRepository;
        this.postRepository = postRepository;
    }

    @Override
    public CommentDto createComment(long postId, CommentDto commentDto) {

        Comment comment = mapToEntity(commentDto);

        //Retrieve post entity by id
        Post post = postRepository.findById(postId).orElseThrow(() -> new ResourceNotFoundException("post", "id", postId));

        //Set post to comment entity
        comment.setPost(post);

        //Save comment entity to the database
        Comment newComment = commentRepository.save(comment);

        return mapToDto(newComment);

    }

    private CommentDto mapToDto(Comment comment){

        CommentDto commentDto = new CommentDto();

        commentDto.setId(comment.getId());
        commentDto.setName(comment.getName());
        commentDto.setEmail(comment.getEmail());
        commentDto.setBody(comment.getMessageBody());

        return commentDto;

    }

    private Comment mapToEntity(CommentDto commentDto){

        Comment comment = new Comment();

        comment.setId(commentDto.getId());
        comment.setName(commentDto.getName());
        comment.setEmail(commentDto.getEmail());
        comment.setMessageBody(commentDto.getBody());

        return comment;

    }
}
