package service.post;

import ir.project.weblog.model.Post;

import java.util.List;

public interface PostService {

    void save(Post post);

    void update(int id, Post updatePost);

    void delete(int id);

    List<Post> findAll();

    Post findById(int id);


}
