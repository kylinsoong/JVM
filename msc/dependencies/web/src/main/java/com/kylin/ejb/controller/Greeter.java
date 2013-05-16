package com.kylin.ejb.controller;

import com.kylin.ejb.greeter.GreeterSession;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import java.io.Serializable;

@Named("greeter")
@SessionScoped
public class Greeter implements Serializable {

	/**
	 * Injected GreeterEJB client
	 */
	@EJB
	private GreeterSession greeterEJB;

	/**
	 * Stores the response from the call to greeterEJB.sayHello(...)
	 */
	private String message;

	/**
	 * Invoke greeterEJB.sayHello(...) and store the message
	 * 
	 * @param name
	 *            The name of the person to be greeted
	 */
	public void setName(String name) {
		message = greeterEJB.sayHello(name);
	}

	/**
	 * Get the greeting message, customized with the name of the person to be
	 * greeted.
	 * 
	 * @return message. The greeting message.
	 */
	public String getMessage() {
		return message;
	}

}
