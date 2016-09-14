package com.sureshatcode.springmvc.serviceimpl;

import java.io.Serializable;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sureshatcode.springmvc.appconfig.AppDataException;
import com.sureshatcode.springmvc.appconfig.AppServiceException;
import com.sureshatcode.springmvc.dao.AuthenticationDao;
import com.sureshatcode.springmvc.model.User;
import com.sureshatcode.springmvc.service.AuthenticationService;

/**
 * 
 * @author Suresh Palanisamy
 *
 */
@Service
public class AuthenticationServiceImpl implements AuthenticationService, Serializable {

	private static final long serialVersionUID = 1L;

	private static final Logger logTracker = LoggerFactory.getLogger(AuthenticationServiceImpl.class);

	@Autowired
	private AuthenticationDao authenticationDao;

	/**
	 * @param user
	 * @return user
	 */
	public User doRegisterNewUser(User user) throws AppServiceException {
		try {
			logTracker.debug("Signup was called in service layer");
			this.authenticationDao.registerNewUser(user);
			return user;
		} catch (AppDataException e) {
			throw new AppServiceException(e.getMessage());
		}
	}
}