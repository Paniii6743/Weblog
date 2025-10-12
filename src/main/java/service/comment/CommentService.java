package service.comment;

import ir.project.weblog.dto.comment.CommentDto;
import ir.project.weblog.dto.comment.CommentSaveDto;

import java.util.List;

public interface CommentService {

    CommentDto save(CommentSaveDto commentSaveDto);
    void approveComment(int id);
    List<CommentDto> getApprovedCommentsByPostId(int postId);
    void deleteById(int id);
    List<CommentDto> findAll();
}
