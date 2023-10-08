package com.example.member_find_site.Service;

import com.example.member_find_site.dto.PJBoardDTO;
import com.example.member_find_site.entity.PJBoardEntity;
import com.example.member_find_site.repository.MemberRepository;
import com.example.member_find_site.repository.PJBoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class PJBoardService {
    private final PJBoardRepository pjBoardRepository;

    public void write(PJBoardDTO pjBoardDTO, MultipartFile file) throws Exception {
        //파일작업
        String projectPath = System.getProperty("user.dir")+"\\src\\main\\resources\\static\\images";

        UUID uuid = UUID.randomUUID();

        String fileName = uuid + "_" + file.getOriginalFilename();

        File saveFile = new File(projectPath, fileName);

        file.transferTo(saveFile);

        pjBoardDTO.setThumbnailImgName(fileName);
        pjBoardDTO.setThumbnailImgPath("../static/images/"+fileName);

        //end 파일작업

        //writerId 받아오기 우선 4로 함.
        int x=4;
        Long xLong=Long.valueOf(x);
        pjBoardDTO.setWriterId(xLong);

        //DTO->Entity 변환작업
        PJBoardEntity pjBoardEntity = PJBoardEntity.toPJBoardEntity(pjBoardDTO);
        pjBoardRepository.save(pjBoardEntity);
    }


    public List<PJBoardDTO> findAll() {
        List<PJBoardEntity> pjBoardEntityList = pjBoardRepository.findAll();
        List<PJBoardDTO> pjBoardDTOList = new ArrayList<>();
        for (PJBoardEntity pjBoardEntity: pjBoardEntityList) {
            pjBoardDTOList.add(PJBoardDTO.toPJBoardDTO(pjBoardEntity));
            /*PJBoardDTO pjBoardDTO = PJBoardDTO.toPJBoardDTO(pjBoardEntity);
            pjBoardDTOList.add(pjBoardDTO);*/
        }

        return pjBoardDTOList;
    }
}
