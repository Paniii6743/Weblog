package ir.project.weblog.dto.post;

import ir.project.weblog.model.Category;
import ir.project.weblog.model.Post;
import ir.project.weblog.model.Status;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class PostSaveDto {

    private final String title;
    private final String author;
    private final String content;
    private final Status status;
    private final int categoryId;

    public PostSaveDto(String title, String author, String content, Status status, int categoryId) {

        this.title = title;
        this.author = author;
        this.content = content;
        this.status = status;
        this.categoryId = categoryId;
    }

    @NotBlank(message = "title.is.blank")
    public String getTitle() {
        return title;
    }

    @NotBlank(message = "author.is.blank")
    public String getAuthor() {return author; }

    @NotBlank(message = "content.is.blank")
    public String getContent() {
        return content;
    }

    @NotNull(message = "status.is.null")
    public Status getStatus() {
        return status;
    }

    @NotBlank(message = "categoryId.is.blank")
    public int getCategoryId() {
        return categoryId;
    }

    public Post convertToPost(Category category) {
        Post post = new Post();
        post.setTitle(title);
        post.setAuthor(author);
        post.setContent(content);
        post.setStatus(status);
        post.setCategory(category);
        return post;
    }
}
