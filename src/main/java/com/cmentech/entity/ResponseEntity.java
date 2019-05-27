package com.cmentech.entity;

public class ResponseEntity {
	
	private Integer code;
	
	private Object data;
	
	private String message;

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return "ResponseEntity [code=" + code + ", data=" + data + ", message=" + message + "]";
	}
}
