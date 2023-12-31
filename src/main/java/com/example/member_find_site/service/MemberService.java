package com.example.member_find_site.Service;

import com.example.member_find_site.dto.MemberDTO;
import com.example.member_find_site.entity.MemberEntity;
import com.example.member_find_site.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MemberService {
    private final MemberRepository memberRepository;
    public void save(MemberDTO memberDTO) {
        //repository의 save메서드 호출(조건, entity객체를 넘겨줘야 함)
        //1. DTO -< Entity 변환작업
        MemberEntity memberEntity = MemberEntity.toMemberEntity(memberDTO);
        //2. repository의 save 메서드 호출
        memberRepository.save(memberEntity);

    }

    public MemberDTO login(MemberDTO memberDTO) {
        /*
            1. 회원이 입력한 이메일로 DB에서 조회를 함
            2.DB에서 조회한 비밀번호와 사용자가 입력한 비밀번호가 일치하는지 판단
         */
        Optional<MemberEntity> byMemberEmail = memberRepository.findByEmail(memberDTO.getMemberEmail());
        if (byMemberEmail.isPresent()) {
            // 조회 결과가 있음(해당 이메일을 가진 회원 정보가 있다)
            // get() => Optional로 감싸진 객체를 가져오기
            MemberEntity memberEntity = byMemberEmail.get();
            if (memberEntity.getPassword().equals(memberDTO.getMemberPassword())) {
                // 비밀번호 일치
                // entity -> dto 변환 후 리턴
                MemberDTO dto = MemberDTO.toMemberDTO(memberEntity);
                return dto;
            } else{
                // 비밀번호 불일치(로그인실패)
                return null;
            }
        } else {
            //조회 결과가 없다.(해당 이메일을 가진 회원이 없다)
            return null;
        }
    }
}
