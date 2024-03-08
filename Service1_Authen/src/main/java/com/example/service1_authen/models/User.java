package com.example.service1_authen.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;
    @Column(name = "username") // Change here
    private String username;
    @Column(name = "passWord")
    private String password;
    @Column(name = "role")
    private boolean role;

    // Thêm chú thích @OneToOne để liên kết với entity Teacher
    @OneToOne(mappedBy = "user")
    private Teacher teacher;

}
