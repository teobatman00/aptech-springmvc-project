package org.example.request.book;

import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.NotNull;
import java.util.Date;

public class BookCreateRequest {
    @NotNull
    private String name;
    @NotNull
    private String description;
    @NotNull
    private String author;
    @NotNull
    private MultipartFile avatar;
    @NotNull
    private boolean isPublished;
    @NotNull
    private Date publishedDate;

    private Long categoryId;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public MultipartFile getAvatar() {
        return avatar;
    }

    public void setAvatar(@NotNull MultipartFile avatar) {
        this.avatar = avatar;
    }

    public boolean isPublished() {
        return isPublished;
    }

    public void setPublished(boolean published) {
        isPublished = published;
    }

    public Date getPublishedDate() {
        return publishedDate;
    }

    public void setPublishedDate(Date publishedDate) {
        this.publishedDate = publishedDate;
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }
}
