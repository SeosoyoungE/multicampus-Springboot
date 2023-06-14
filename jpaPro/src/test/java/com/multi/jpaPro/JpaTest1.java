package com.multi.jpaPro;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Optional;
import java.util.function.Supplier;

import org.assertj.core.util.Lists;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.transaction.annotation.Transactional;

import com.multi.jpaPro.domain.Member;
import com.multi.jpaPro.repository.MemberRepository;

@SpringBootTest
class JpaTest1 {
	@Autowired
	MemberRepository repository;
	
	@Test
	@Disabled
	void insert() {
		repository.save(new Member("jpatest1","1234","제이피에이"));
	}
	@Test
	@Disabled
	void find_test() {
	 	//List<Member> list =repository.findAll();
	 	//sprint(list);
	 	System.out.println("============================");
	 	print(repository.findAll(Sort.by(Direction.ASC,"id")));
	 	
	 	print(repository.findAllById(Lists.newArrayList("9871kim","djdiwjs","282djdid")));
	 	
	}
	
	@Test
	@Disabled
	void insertall() {
		Member member1=new Member("jimin","1234","박지민");
		Member member2=new Member("suga","1234","민윤기");
		Member member3=new Member("rm","1234","김남준");
		
		repository.saveAll(Lists.newArrayList(member1,member2,member3));
	}
	@Test
	@Transactional
	@Disabled
	void read_test() {
		Member member = repository.getOne("jimin");
		System.out.println(member);
	}
	@Test
	@Disabled
	void read_test2() {
		//Optional내부에서 갖고있는 value값을 저장해서 nullpointexcetion이 발생하지 않게 처리
		Optional<Member> member= repository.findById("suga");
		System.out.println(member);
		
		long count=repository.count();
		System.out.println("레코드갯수: "+count);
		
		boolean state= repository.existsById("rm");
		System.out.println("rm이 존재? "+state);
	}
	
	@Test
	@Disabled
	void pageTest() {
		Page<Member> list=repository.findAll(PageRequest.of(0, 5));
		System.out.println("memberlist: "+list);
		System.out.println("전체레코드수: "+list.getTotalElements());
		System.out.println("전체페이지수: "+list.getTotalPages());
		System.out.println("현재 조회한 레코드수: "+list.getNumberOfElements());
		System.out.println("정렬: "+list.getSort());
		System.out.println("한페이지의 사이즈: "+list.getSize());
		print(list.getContent()); //Array리스트에 담아서 리턴
	}
	
	@Test
	@Disabled
	void update_test() {
		repository.save(new Member("jin","1234","김석진"));
//		Supplier<RuntimeException> obj = new Supplier<RuntimeException>() {
//
//			@Override
//			public RuntimeException get() {
//				// TODO Auto-generated method stub
//				return null;
//			}
//			
//		};
		//Optional로 wrapping되어있는 Member객체를 직접꺼내기 위해 이객체가 없는 경우 널을 발생ㅇ시키겠다고 명시
		Member member=repository.findById("jin").orElseThrow(() -> new RuntimeException());
		System.out.println(member);
		
		//save - 새로만들어지면 insert/ 있으면 호출 / setter를 쓰면 자동으로 update
		member.setSsn("7711111022666");
		repository.save(member);
	}
	@Test
	@Disabled
	void delete_test() {
//		repository.deleteAll();
//		repository.deleteById("jpatest1");
//		repository.deleteAllById(Lists.newArrayList("rm","jin"));
		
		//아이디를 in연산자로 추가
		repository.deleteAllByIdInBatch(Lists.newArrayList("jimin","suga"));
	}
	
	@Test
	void mtmethod() throws ParseException
	{
		//print(repository.findByPosition("과장"));
		//print(repository.findByPositionLike("과장"));
		//print(repository.findByPositionStartingWith("과장"));
		//print(repository.findByPositionEndingWith("과장"));
		//print(repository.findByPositionContaining("과장"));
		//Member member=repository.findByIdAndPass("bts", "1234");
		//System.out.println(member);
		print(repository.findByStartdayGreaterThanEqual(new SimpleDateFormat("yyyy-MM-dd").parse("2010-10-01")));
	}
	void print(List<Member> list){
		for(Member member:list) {
			System.out.println(member);
		}
	}
}

