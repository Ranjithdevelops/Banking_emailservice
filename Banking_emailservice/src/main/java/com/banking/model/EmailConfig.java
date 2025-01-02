package com.banking.model;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class EmailConfig {
	@Value("${mail.host}")
	private String host;
	@Value("${mail.port}")
	private int port;
	@Value("${mail.username}")
	private String username;
	@Value("${mail.password}")
	private String password;
	@Value("${mail.subject}")
	private String subject;
	@Value("${mail.message}")
	private String message;

	public String getHost() {
		return host;
	}

	public void setHost(String host) {
		this.host = host;
	}

	public int getPort() {
		return port;
	}

	public void setPort(int port) {
		this.port = port;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	

}
