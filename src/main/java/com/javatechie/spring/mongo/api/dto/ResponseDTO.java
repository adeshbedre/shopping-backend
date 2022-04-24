package com.javatechie.spring.mongo.api.dto;

public class ResponseDTO <T>{

	T data;
	
	String statusCode;
	
	String statusMsg;
	
	public ResponseDTO(T data, String statusCode, String statusMsg) {
		this.data = data;
		this.statusCode = "200";
		this.statusMsg = "SUCCESS";
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public String getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(String statusCode) {
		this.statusCode = statusCode;
	}

	public String getStatusMsg() {
		return statusMsg;
	}

	public void setStatusMsg(String statusMsg) {
		this.statusMsg = statusMsg;
	}
	
	
}
