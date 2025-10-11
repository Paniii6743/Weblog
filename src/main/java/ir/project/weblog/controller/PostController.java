package ir.project.weblog.controller;

import ir.project.weblog.customeException.RuleException;
import ir.project.weblog.dto.SaveDto;
import ir.project.weblog.dto.post.PostDto;
import ir.project.weblog.dto.post.PostSaveDto;
import ir.project.weblog.model.Category;
import ir.project.weblog.model.Post;
import ir.project.weblog.repository.CategoryRepository;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import service.category.CategoryService;
import service.post.PostService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/posts")
@CrossOrigin(allowedHeaders = "*", origins = "*")
public class PostController {

    private final PostService postService;
    private final CategoryService categoryService;
    private final CategoryRepository categoryRepository;

    public PostController(PostService postService, CategoryService categoryService,
                          CategoryRepository categoryRepository) {
        this.postService = postService;
        this.categoryService = categoryService;
        this.categoryRepository = categoryRepository;
    }

     @PostMapping
     public ResponseEntity<SaveDto> save(@Valid @RequestBody PostSaveDto postSaveDto) {
         Category category = categoryRepository.findById(postSaveDto.getCategoryId())
                 .orElseThrow(() ->
                         new RuleException("category.not.found"));
         Post post = postSaveDto.convertToPost(category);
         postService.save(post);
         return ResponseEntity.ok(new SaveDto(post.getId()));
     }

     @PutMapping("/{id}")
     public ResponseEntity<SaveDto> update(@PathVariable int id,
                                           @Valid @RequestBody PostSaveDto postSaveDto) {
         Category category = categoryRepository.findById(postSaveDto.getCategoryId())
                 .orElseThrow(() ->
                         new RuleException("category.not.found"));


         Post updatedPost = postSaveDto.convertToPost(category);
         postService.update(id, updatedPost);
         return ResponseEntity.ok(new SaveDto(id));
     }

    @DeleteMapping("/{id}")
    public ResponseEntity<SaveDto> delete(@PathVariable int id) {
        postService.delete(id);
        return ResponseEntity.ok(new SaveDto(id));
    }


    @GetMapping("/{id}")
    public ResponseEntity<PostDto> findById(@PathVariable int id) {
        Post post = postService.findById(id);
        PostDto postDto = PostDto.ConvertToDto(post);
        return ResponseEntity.ok(postDto);
    }

    @GetMapping
    public ResponseEntity<List<PostDto>> findAll() {
        List<Post> posts = postService.findAll();
        List<PostDto> postDtos = posts.stream()
                .map(PostDto::ConvertToDto)
                .collect(Collectors.toList());
        return ResponseEntity.ok(postDtos);
    }
}
