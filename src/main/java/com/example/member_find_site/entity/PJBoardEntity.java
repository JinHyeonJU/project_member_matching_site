package com.example.member_find_site.entity;

import com.example.member_find_site.dto.MemberDTO;
import com.example.member_find_site.dto.PJBoardDTO;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name = "pj_board")
public class PJBoardEntity extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //인덱스 1씩 증가
    private Long id;

    @Column(nullable = false)
    private Long writerId;

    @Column(length = 20, nullable = false)
    private String title;

    @Column(length = 1000, nullable = false)
    private String content;

    @Column(length = 100)
    private String thumbnailImgName;

    @Column(length = 100)
    private String thumbnailImgPath;

    public static PJBoardEntity toPJBoardEntity(PJBoardDTO pjBoardDTO){
        PJBoardEntity pjBoardEntity = new PJBoardEntity();
        pjBoardEntity.setWriterId(pjBoardDTO.getWriterId());
        pjBoardEntity.setTitle(pjBoardDTO.getTitle());
        pjBoardEntity.setContent(pjBoardDTO.getContent());
        pjBoardEntity.setThumbnailImgName(pjBoardDTO.getThumbnailImgName());
        pjBoardEntity.setThumbnailImgPath(pjBoardDTO.getThumbnailImgPath());
        return pjBoardEntity;
    }
}
