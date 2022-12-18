package org.example.entity;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "users")
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Long id;
    @Column(name = "username", nullable = false)
    private String userName;
    @Column(name = "password", nullable = false)
    private String password;
    @Column(name = "avatar")
    private byte[] avatar;
    @CreationTimestamp
    @Column(name = "created_date", nullable = false)
    private Date createdDate;
    @UpdateTimestamp
    @Column(name = "updated_date", nullable = false)
    private Date updatedDate;
    @Transient
    private String base64Image;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
