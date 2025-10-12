package ir.project.weblog.dto.comment;

import ir.project.weblog.model.Comment;
import ir.project.weblog.model.Post;
import jakarta.validation.constraints.NotBlank;

public class CommentSaveDto {

 private final int postId;
 private final String content;
 private final String authorName;
 private final String authorEmail;

    public CommentSaveDto(int postId, String content, String authorName, String authorEmail) {
        this.postId = postId;
        this.content = content;
        this.authorName = authorName;
        this.authorEmail = authorEmail;
    }

    public int getPostId() {
        return postId;
    }

    @NotBlank(message = "content.is.blank")
    public String getContent() {
        return content;
    }

    @NotBlank(message = "authorName.is.blank")
    public String getAuthorName() {
        return authorName;
    }

    @NotBlank(message = "authorEmail.is.blank")
    public String getAuthorEmail() {
        return authorEmail;
    }

    public Comment ConvertToEntity(Post post) {
     Comment comment = new Comment();
     comment.setContent(this.content);
     comment.setAuthorName(this.authorName);
     comment.setAuthorEmail(this.authorEmail);
     comment.setApproved(false);
        comment.setPost(post);
     return comment;


    }
}
