package ir.project.weblog.dto.comment;

import ir.project.weblog.model.Comment;

public class CommentDto {
    private final int id;
    private final int postId;
    private final String content;
    private final String authorName;
    private final String authorEmail;
    private final boolean approved;

    public CommentDto(int id, int postId, String content, String authorName,
                      String authorEmail, boolean approved) {
        this.id = id;
        this.postId = postId;
        this.content = content;
        this.authorName = authorName;
        this.authorEmail = authorEmail;
        this.approved = approved;
    }

    public int getId() {
        return id;
    }

    public int getPostId() {
        return postId;
    }

    public String getContent() {
        return content;
    }

    public String getAuthorName() {
        return authorName;
    }

    public String getAuthorEmail() {
        return authorEmail;
    }

    public boolean isApproved() {
        return approved;
    }

    public static CommentDto ConvertToDto(Comment comment) {
        return new CommentDto(
                comment.getId(),
                comment.getPost().getId(),
                comment.getContent(),
                comment.getAuthorName(),
                comment.getAuthorEmail(),
                comment.isApproved()

        );
    }
}
