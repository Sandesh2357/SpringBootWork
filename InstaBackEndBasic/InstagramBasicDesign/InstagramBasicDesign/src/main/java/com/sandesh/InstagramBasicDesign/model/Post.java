package com.sandesh.InstagramBasicDesign.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;

import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer postId;
    @Column(nullable = false)
    private LocalDateTime createdDate;
    @Column(nullable = false)
    @NotEmpty
    private String postData;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(nullable = false,name = "fk_user_id")
    private User user;
}
