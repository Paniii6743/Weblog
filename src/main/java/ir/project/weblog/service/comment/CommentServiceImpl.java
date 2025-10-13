package ir.project.weblog.service.comment;

import ir.project.weblog.dto.comment.CommentDto;
import ir.project.weblog.dto.comment.CommentSaveDto;
import ir.project.weblog.model.Comment;
import ir.project.weblog.model.Post;
import ir.project.weblog.repository.CommentRepository;
import ir.project.weblog.repository.PostRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
@Service
public class CommentServiceImpl implements CommentService {
    private final CommentRepository commentRepository;
    private final PostRepository postRepository;

    public CommentServiceImpl(CommentRepository commentRepository,
                              PostRepository postRepository) {
        this.commentRepository = commentRepository;
        this.postRepository = postRepository;
    }


    @Override
    public CommentDto save(CommentSaveDto dto) {
        Post post = postRepository.findById(dto.getPostId())
                .orElseThrow(() -> new RuntimeException("post.is.not.found"));
        Comment comment = dto.ConvertToEntity(post);
        Comment saved = commentRepository.save(comment);
        return CommentDto.ConvertToDto(saved);
    }

    @Override
    public void approveComment(int id) {
        Comment comment = (Comment) commentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("comment.is.npt.found"));
        comment.setApproved(true);
        commentRepository.save(comment);
    }

    @Override
    public List<CommentDto> getApprovedCommentsByPostId(int postId) {
        return commentRepository.findByPostIdAndApprovedTrue(postId)
                .stream()
                .map(CommentDto::ConvertToDto)
                .collect(Collectors.toList());
    }

    @Override
    public void deleteById(int id) {
    commentRepository.deleteById(Long.valueOf(id));
    }

    @Override
    public List<CommentDto> findAll() {
        return commentRepository.findAll()
                .stream()
                .map(CommentDto::ConvertToDto)
                .toList();
    }
}
