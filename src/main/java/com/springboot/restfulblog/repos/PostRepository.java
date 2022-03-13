package com.springboot.restfulblog.repos;

import com.springboot.restfulblog.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;

// No need to add @repository annotation because Jpa already implements it.
public interface PostRepository extends JpaRepository<Post, Long> {

}
