package com.example.member_find_site.dto;

import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class PJBoardDTO {
    private Long id;
    private Long writerId;
    private String writerNickname;
    private String title;
    private String content;
    private String writerRole;
    private String thumbnailImgName;
    private String thumbnailImgPath;
}
