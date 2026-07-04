package com.example.CRUDAPI.posts;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class PostService {
  private final PostRepository postRepository;

  public PostService(PostRepository postRepository) {
    this.postRepository = postRepository;
  }

  public List<Post> getAllPosts() {
    return postRepository.findAll();
  }

  public Post getPostById(long id) {
    return postRepository.findById(id).orElse(null);
  }

  public Post createPost(Post post) {
    return postRepository.save(post);
  }

  public Post updatePost(long id, Post updatedPost) {
    Post existingPost = postRepository.findById(id).orElse(null);
    if (existingPost != null) {
      existingPost.setName(updatedPost.getName());
      existingPost.setDescription(updatedPost.getDescription());
      existingPost.setRace(updatedPost.getRace());
      existingPost.setUniverse(updatedPost.getUniverse());
      return postRepository.save(existingPost);
    }
    return null;
  }

  public boolean deletePost(long id) {
    if (postRepository.existsById(id)) {
      postRepository.deleteById(id);
      return true;
    }
    return false;
  }

  public List<Post> searchPosts(String keyword) {
    return postRepository.findByNameContainingIgnoreCaseOrRaceContainingIgnoreCase(keyword, keyword);
  }
}