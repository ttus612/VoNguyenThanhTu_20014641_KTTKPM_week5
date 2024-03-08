package com.example.service1_authen.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "teachers")
public class Teacher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;
    @Column(name = "name")
    private String name;
    @Column(name = "maGV")
    private String maGV;
    @Column(name = "role")
    private boolean role;

    @OneToOne
    @JoinColumn(name = "user_id")  // Chỉ định khóa ngoại trỏ đến bảng users
    private User user;
}
