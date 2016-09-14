package com.sureshatcode.springmvc.dao;

import com.sureshatcode.springmvc.appconfig.AppDataException;
import com.sureshatcode.springmvc.model.User;

/**
 * 
 * @author Suresh Palanisamy
 *
 */
public interface AuthenticationDao {

	public User registerNewUser(User user) throws AppDataException;
}