package com.ghailene.myblog.service;

import com.ghailene.myblog.dto.PostDto;
import com.ghailene.myblog.exception.PostNotFoundException;
import com.ghailene.myblog.model.Post;
import com.ghailene.myblog.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PostService {

    @Autowired
    AuthService authService;

    @Autowired
    PostRepository postRepository;

    /*  public void createPost(PostDto postDto) {
          Post post = new Post();
          post.setTitle(postDto.getTitle());
          post.setContent(postDto.getContent());
          User userName = authService.getCurrentUser().orElseThrow(() -> new IllegalArgumentException("No User Logged In"));
          post.setUserName(userName.getUsername());
          post.setCreatedOn(Instant.now());
          postRepository.save(post);
      }*/
    public void createPost(PostDto postDto) {
        Post post = mapFromDtoToPost(postDto);

        postRepository.save(post);
    }

    public List<PostDto> showAllPosts() {
        List<Post> posts = postRepository.findAll();
        return posts.stream().map(this::mapFromPostToDto).collect(Collectors.toList());
    }

    private PostDto mapFromPostToDto(Post post) {
        PostDto postDto = new PostDto();
        postDto.setId(post.getId());
        postDto.setTitle(post.getTitle());
        postDto.setContent(post.getContent());
        postDto.setUserName(post.getUserName());
        return postDto;

    }

    private Post mapFromDtoToPost(PostDto postDto) {
        Post post = new Post();
        post.setTitle(postDto.getTitle());
        post.setContent(postDto.getContent());
        User loggedInUser = authService.getCurrentUser().orElseThrow(() -> new IllegalArgumentException("User Not Found"));
        post.setCreatedOn(Instant.now());
        post.setUserName(loggedInUser.getUsername());
        post.setUpdatedOn(Instant.now());
        return post;

    }

    public PostDto readSinglePost(Long id) {
        Post post = postRepository.findById(id).orElseThrow(() -> new PostNotFoundException("For id" + id));
        return mapFromPostToDto(post);

    }
}
