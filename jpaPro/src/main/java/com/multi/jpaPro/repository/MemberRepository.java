package com.multi.jpaPro.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.multi.jpaPro.domain.Member;

public interface MemberRepository extends JpaRepository<Member, String>{
	List<Member> findByPosition(String position);
	List<Member> findByPositionLike(String position);
	List<Member> findByPositionStartingWith(String position);
	List<Member> findByPositionEndingWith(String position);
	List<Member> findByPositionContaining(String position);
	Member findByIdAndPass(String id,String pass);
	List<Member> findByStartdayGreaterThanEqual(Date startday);
}
