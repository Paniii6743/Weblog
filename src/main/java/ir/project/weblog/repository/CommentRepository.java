package ir.project.weblog.repository;

import ir.project.weblog.model.Comment;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CommentRepository extends JpaRepository<Comment, Long> {

    List<Comment> findByPostIdAndApprovedTrue(long postId);

    Optional<Object> findById(int id);

    List<Comment> id(int id);
}
