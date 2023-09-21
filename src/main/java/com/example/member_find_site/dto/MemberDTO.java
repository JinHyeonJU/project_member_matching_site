package com.example.member_find_site.dto;

import com.example.member_find_site.entity.MemberEntity;
import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class MemberDTO {
    private Long id;
    private String memberName;
    private String memberEmail;
    private String memberPassword;
    private String memberNickname;
    private String role;

    public static MemberDTO toMemberDTO(MemberEntity memberEntity){
        MemberDTO memberDTO = new MemberDTO();
        memberDTO.setId(memberEntity.getId());
        memberDTO.setMemberName(memberEntity.getName());
        memberDTO.setMemberEmail(memberEntity.getEmail());
        memberDTO.setMemberPassword(memberEntity.getPassword());
        memberDTO.setMemberNickname(memberEntity.getNickName());
        memberDTO.setRole(memberEntity.getRole());
        return memberDTO;
    }
}
