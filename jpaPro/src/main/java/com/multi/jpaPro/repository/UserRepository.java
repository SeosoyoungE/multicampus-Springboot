package com.multi.jpaPro.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.multi.jpaPro.domain.User;

public interface UserRepository extends JpaRepository<User,String> {

}
