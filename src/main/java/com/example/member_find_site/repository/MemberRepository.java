package com.example.member_find_site.repository;

import com.example.member_find_site.entity.MemberEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MemberRepository extends JpaRepository<MemberEntity, Long> {
    // 이메일로 회원 정보 조회(select * from member_table where member_email=?)
    // Optional => 재발방지
    // 리포지토리에서 주고받는 객체는 전부 entity
    Optional<MemberEntity> findByEmail(String memberEmail);
}
