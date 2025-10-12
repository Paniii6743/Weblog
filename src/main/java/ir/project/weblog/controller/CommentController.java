package ir.project.weblog.controller;

import ir.project.weblog.dto.comment.CommentDto;
import ir.project.weblog.dto.comment.CommentSaveDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import service.comment.CommentService;

import java.util.List;

@RestController
@RequestMapping("/comments")
@CrossOrigin(allowedHeaders = "*", origins = "*")
public class CommentController {
private final CommentService commentService;

    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }


    @PostMapping
    public ResponseEntity<CommentDto> saveComment(@RequestBody CommentSaveDto commentSaveDto) {
        CommentDto saved = commentService.save(commentSaveDto);
        return ResponseEntity.ok(saved);
    }

    @PutMapping("/admin/comments/{id}/approve")
    public ResponseEntity<Void> approveComment(@PathVariable int id) {
        commentService.approveComment(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/posts/{postId}")
    public ResponseEntity<List<CommentDto>> getApprovedComments(@PathVariable int postId) {
        List<CommentDto> comments = commentService.getApprovedCommentsByPostId(postId);
        return ResponseEntity.ok(comments);
    }


    @DeleteMapping("/admin/comments/{id}")
    public ResponseEntity<Void> deleteComment(@PathVariable int id) {
        commentService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/allComments")
    public ResponseEntity<List<CommentDto>> getAllComments() {
        return ResponseEntity.ok(commentService.findAll());
    }
}
