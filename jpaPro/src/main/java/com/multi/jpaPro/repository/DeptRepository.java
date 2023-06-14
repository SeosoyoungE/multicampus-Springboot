package com.multi.jpaPro.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.multi.jpaPro.domain.Dept;

public interface DeptRepository extends JpaRepository<Dept, String> {

}
