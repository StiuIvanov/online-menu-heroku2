package com.example.demo.model.entity;


import javax.persistence.*;

@Entity
@Table(name = "users")
public class UserEntity extends BaseEntity {

    private String username;
    private String firstName;
    private String lastName;
    private String password;
    private String email;
    private String role;
//    private PictureEntity pictureEntity;

    public UserEntity() {
    }

    @Column(unique = true,nullable = false)
    public String getUsername() {
        return username;
    }

    public UserEntity setUsername(String username) {
        this.username = username;
        return this;
    }

    @Column(nullable = false)
    public String getFirstName() {
        return firstName;
    }

    public UserEntity setFirstName(String fullName) {
        this.firstName = fullName;
        return this;
    }

    @Column(nullable = false)
    public String getPassword() {
        return password;
    }

    public UserEntity setPassword(String password) {
        this.password = password;
        return this;
    }

    @Column(unique = true, nullable = false)
    public String getEmail() {
        return email;
    }

    public UserEntity setEmail(String email) {
        this.email = email;
        return this;
    }

    @Column(nullable = false)
    public String getLastName() {
        return lastName;
    }

    public UserEntity setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    @Column
    public String getRole() {
        return role;
    }

    public UserEntity setRole(String role) {
        this.role = role;
        return this;
    }

//    @OneToOne
//    public PictureEntity getPictureEntity() {
//        return pictureEntity;
//    }
//
//    public UserEntity setPictureEntity(PictureEntity pictureEntity) {
//        this.pictureEntity = pictureEntity;
//        return this;
//    }
}
