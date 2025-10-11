package ir.project.weblog.dto.post;

import ir.project.weblog.model.Post;
import ir.project.weblog.model.Status;

import java.time.LocalDateTime;

public class PostDto {
    private final int id;
    private final String title;
    private final String content;
    private final String author;
    private final Status status;
    private final String categoryName;
    private final int categoryId;
    private final LocalDateTime createdAt;
    private final LocalDateTime updatedAt;
    private final LocalDateTime desableDate;

    public PostDto(int id, String title, String content, String author, Status status,
                   String categoryName, int categoryId, LocalDateTime createdAt,
                   LocalDateTime updatedAt, LocalDateTime desableDate) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.author = author;
        this.status = status;
        this.categoryName = categoryName;
        this.categoryId = categoryId;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.desableDate = desableDate;
    }


    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    public String getAuthor() {
        return author;
    }

    public Status getStatus() {
        return status;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public LocalDateTime getDesableDate() {
        return desableDate;
    }

    public static PostDto ConvertToDto(Post post) {
        return new PostDto(
                post.getId(),
                post.getTitle(),
                post.getContent(),
                post.getAuthor(),
                post.getStatus(),
                post.getCategory().getName(),
                post.getCategory().getId(),
                post.getCreatedAt(),
                post.getUpdatedAt(),
                post.getDisableDate()
        );

    }
}
