package com.project1.repository;

import com.project1.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface MemberRepository extends JpaRepository<Member,String> {

    @Query("select (count(m) > 0) from Member m where m.email = :email")
    boolean emailExist(String email);
}
