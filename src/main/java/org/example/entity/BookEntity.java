package org.example.entity;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "book")
public class BookEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    @Column(name = "name", nullable = false)
    private String name;
    @Column(name = "description", nullable = false)
    private String description;
    @Column(name = "author", nullable = false)
    private String author;
    @Column(name = "avatar", nullable = false)
    private byte[] avatar;
    @Column(name = "is_published", nullable = false)
    private boolean isPublished;
    @Column(name = "published_date", nullable = false)
    private Date publishedDate;
    @CreationTimestamp
    @Column(name = "created_date", nullable = false)
    private Date createdDate;
    @UpdateTimestamp
    @Column(name = "updated_date", nullable = false)
    private Date updatedDate;
    @Transient
    private String base64Image;
    @ManyToOne
    @JoinColumn(name = "category_id")
    private CategoryEntity category;

    public CategoryEntity getCategory() {
        return category;
    }

    public void setCategory(CategoryEntity category) {
        this.category = category;
    }

}
