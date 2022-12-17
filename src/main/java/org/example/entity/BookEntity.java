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
    private String author;
    private byte[] avatar;
    private boolean isPublished;
    private Date publishedDate;
    @CreationTimestamp
    @Column(name = "created_date", nullable = false)
    private Date createdDate;
    @UpdateTimestamp
    @Column(name = "updated_date", nullable = false)
    private Date updatedDate;
    @Transient
    private String base64Image;

}
