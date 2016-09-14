package com.sureshatcode.springmvc.service;

import com.sureshatcode.springmvc.appconfig.AppServiceException;
import com.sureshatcode.springmvc.model.User;

/**
 * 
 * @author Suresh Palanisamy
 *
 */
public interface AuthenticationService {

	public User doRegisterNewUser(User user) throws AppServiceException;
}