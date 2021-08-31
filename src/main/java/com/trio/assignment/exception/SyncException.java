package com.trio.assignment.exception;

import org.springframework.http.HttpStatus;

public class SyncException extends RuntimeException {

	private static final long serialVersionUID = 7161881165183095584L;

	public SyncException() {

	}

	public SyncException(HttpStatus status) {
		this.status = status;
	}

	public SyncException(String message) {
		super(message);
	}
	
	private HttpStatus status;

	public HttpStatus getStatus() {
		return status;
	}

	public void setStatus(HttpStatus status) {
		this.status = status;
	}
	
}
