package com.example.member_find_site.repository;

import com.example.member_find_site.entity.MemberEntity;
import com.example.member_find_site.entity.PJBoardEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PJBoardRepository extends JpaRepository<PJBoardEntity, Long> {

}
