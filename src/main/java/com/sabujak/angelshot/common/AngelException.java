package com.sabujak.angelshot.common;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;

public class AngelException extends RuntimeException{
	private Logger logger = Logger.getLogger(this.getClass());
	

	 
	/**
	 * 
	 */
	private static final long serialVersionUID = -4963423193338743488L;

 
	public AngelException(HttpServletRequest request,String customMsg) {
		
		logger.error("TmapException : " + customMsg);
		request.setAttribute("customMsg", customMsg);
	}
}
