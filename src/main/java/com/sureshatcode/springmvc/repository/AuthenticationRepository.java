package com.sureshatcode.springmvc.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sureshatcode.springmvc.model.User;

/**
 * 
 * @author Suresh Palanisamy
 *
 */
public interface AuthenticationRepository extends JpaRepository<User, Long> {

}
