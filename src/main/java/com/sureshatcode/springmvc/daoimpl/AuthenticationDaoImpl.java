package com.sureshatcode.springmvc.daoimpl;

import java.io.Serializable;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sureshatcode.springmvc.appconfig.AppDataException;
import com.sureshatcode.springmvc.dao.AuthenticationDao;
import com.sureshatcode.springmvc.model.User;
import com.sureshatcode.springmvc.repository.AuthenticationRepository;

/**
 * 
 * @author Suresh Palanisamy
 *
 */
@Repository
public class AuthenticationDaoImpl implements AuthenticationDao, Serializable {

	private static final long serialVersionUID = 1L;

	private static final Logger logTracker = LoggerFactory.getLogger(AuthenticationDaoImpl.class);

	@Autowired
	private AuthenticationRepository authenticationRepository;

	public User registerNewUser(User user) throws AppDataException {
		try {
			logTracker.debug("Signup was called in data layer");
			this.authenticationRepository.save(user);
			return user;
		} catch (Exception e) {
			throw new AppDataException(e.getMessage());
		}
	}
}