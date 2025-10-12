package service.post;

import ir.project.weblog.customeException.RuleException;
import ir.project.weblog.dto.post.PostDto;
import ir.project.weblog.model.Post;
import ir.project.weblog.repository.PostRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class PostServiceImpl implements PostService {
    private final PostRepository postRepository;

    public PostServiceImpl(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    @Override
    public void save(Post post) {
        post.setCreatedAt(LocalDateTime.now());
     postRepository.save(post);
    }

    @Override
    public void update(int id, Post updatePost) {
    Post post = postRepository.findById(id)
            .orElseThrow(()-> new RuleException("post.is.not.found"));
    post.setTitle(updatePost.getTitle());
    post.setContent(updatePost.getContent());
        post.setImage(updatePost.getImage());
        post.setCategory(updatePost.getCategory());
    post.setStatus(updatePost.getStatus());
    post.setUpdatedAt(LocalDateTime.now());
    postRepository.save(post);

    }

    @Override
    public void delete(int id) {
        Post post = postRepository.findById(id)
                .orElseThrow(()-> new RuleException("post.is.not.found"));
        post.setDisableDate(LocalDateTime.now());
        postRepository.save(post);
    }

    @Override
    public List<Post> findAll() {
        return postRepository.findByDisableDateIsNull();
    }

    @Override
    public Post findById(int id) {
       return postRepository.findById(id)
               .orElseThrow(()-> new RuleException("post.is.not.found"));
    }

    @Override
    public List<PostDto> findByCategoryId(int categoryId) {
        return
                postRepository.findByCategoryId(categoryId).stream()
                        .map(PostDto::ConvertToDto).toList();
    }

}
