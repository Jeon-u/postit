package com.alpaca.postit.post;

import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/post")
public class PostController {
    private final PostRepository postRepository;

    @Autowired
    public PostController(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    // save post
    @PostMapping
    public Post put(@RequestParam String title, @RequestParam String content) {
        return postRepository.save(new Post(title, content));
    }

    // findAll
    @Operation(summary = "list 조회", description = "list 조회")
    @GetMapping
    public Iterable<Post> list(){
        return postRepository.findAll();
    }

    @PostMapping("/receive")
    public String content(@RequestBody Post post) {
        System.out.println("post " + post);
        return post.getContent();
    }
}