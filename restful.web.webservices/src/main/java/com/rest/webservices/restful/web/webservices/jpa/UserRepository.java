package com.rest.webservices.restful.web.webservices.jpa;

import com.rest.webservices.restful.web.webservices.user.module.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer>{
}
