package com.springboot.restfulblog.repos;

import com.springboot.restfulblog.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment, Long> {
}
