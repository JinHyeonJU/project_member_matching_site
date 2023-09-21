package com.example.member_find_site.entity;
import com.example.member_find_site.dto.MemberDTO;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name = "user")
public class MemberEntity extends BaseTimeEntity {

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

    @Column(length = 10, nullable = false)
    private String role;

    public static MemberEntity toMemberEntity(MemberDTO memberDTO){
        MemberEntity memberEntity = new MemberEntity();
        memberEntity.setName(memberDTO.getMemberName());
        memberEntity.setEmail(memberDTO.getMemberEmail());
        memberEntity.setPassword(memberDTO.getMemberPassword());
        memberEntity.setNickName(memberDTO.getMemberNickname());
        memberEntity.setRole(memberDTO.getRole());
        return memberEntity;
    }
}
