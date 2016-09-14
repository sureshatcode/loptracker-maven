package com.sureshatcode.springmvc.controller;

import java.io.Serializable;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sureshatcode.springmvc.appconfig.AppConstants;
import com.sureshatcode.springmvc.appconfig.AppResponse;
import com.sureshatcode.springmvc.appconfig.AppServiceException;
import com.sureshatcode.springmvc.model.User;
import com.sureshatcode.springmvc.service.AuthenticationService;

/**
 * 
 * @author Suresh Palanisamy
 *
 */
@RestController
@RequestMapping(value = "/core/authentication/")
public class AuthenticationController implements Serializable {

	private static final long serialVersionUID = 1L;
	private static final Logger logTracker = LoggerFactory.getLogger(AuthenticationController.class);

	@Autowired
	private AuthenticationService authenticationService;

	/**
	 * @param user
	 * @return appResponse
	 */
	@RequestMapping(value = "signup", method = RequestMethod.POST, produces = "application/json")
	public AppResponse registerNewUser(@RequestBody User user) {
		AppResponse appResponse = new AppResponse();
		try {
			logTracker.debug("Signup was called in controller layer");
			authenticationService.doRegisterNewUser(user);

			appResponse.setCode(AppConstants.REQ_SUCCESS_CODE);
			appResponse.setMessage("User registered successfully.");
			appResponse.setData(null);
		} catch (AppServiceException e) {
			appResponse.setCode(AppConstants.SYSTEM_ERROR_CODE);
			appResponse.setMessage("Exception: " + e.getMessage());
			appResponse.setData(null);
		}
		return appResponse;
	}
}