package ir.project.weblog.repository;

import ir.project.weblog.model.Category;
import ir.project.weblog.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostRepository extends JpaRepository<Post, Integer> {
List<Post> findByCategory(Category category);
List<Post> findByDisableDateIsNull();
}
