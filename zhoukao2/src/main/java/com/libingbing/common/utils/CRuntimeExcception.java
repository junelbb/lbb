package com.libingbing.common.utils;

//继承RuntimeException类，创建自定义异常
public class CRuntimeExcception extends RuntimeException {

	/**
	 * @fieldName: serialVersionUID
	 * @fieldType: long
	 * @Description: TODO
	 */
	private static final long serialVersionUID = 1L;

	public CRuntimeExcception() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CRuntimeExcception(String message, Throwable cause,
			boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

	public CRuntimeExcception(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public CRuntimeExcception(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public CRuntimeExcception(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}
	
	

}
