package com.example.member_find_site.dto;

import com.example.member_find_site.entity.PJBoardEntity;
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

    public static PJBoardDTO toPJBoardDTO(PJBoardEntity pjBoardEntity) {
        PJBoardDTO pjBoardDTO = new PJBoardDTO();
        pjBoardDTO.setId(pjBoardEntity.getId());
        pjBoardDTO.setWriterId(pjBoardEntity.getWriterId());
        pjBoardDTO.setTitle(pjBoardEntity.getTitle());
        pjBoardDTO.setContent(pjBoardEntity.getContent());
        pjBoardDTO.setThumbnailImgPath(pjBoardEntity.getThumbnailImgPath());

        return pjBoardDTO;
    }
}
