package com.example.member_find_site.dto;
import lombok.Getter;
import javax.persistence.*;

@Entity
@Getter
@Table(name = "user")
public class User extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //인덱스 1씩 증가
    private Long id;

    @Column(length = 50, nullable = false)
    private String name;

    @Column(length = 50, nullable = false, unique = true)
    private String email;

    @Column(length = 100, nullable = false)
    private String password;

    @Column
    private String profilePicturePath;

    @Column(length = 8, nullable = false, unique = true)
    private String nickName;
}
