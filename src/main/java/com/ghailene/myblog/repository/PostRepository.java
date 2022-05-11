package com.ghailene.myblog.repository;

import com.ghailene.myblog.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Long> {


}
