package com.vaya.bestpractice.controller;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.error.ErrorAttributes;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MyErrorController { //  implements ErrorController

	private ErrorAttributes errorAttributes = null;

	@Autowired
	  public void SimpleErrorController(ErrorAttributes errorAttributes) {
	    Assert.notNull(errorAttributes, "ErrorAttributes must not be null");
	    this.errorAttributes = errorAttributes;
	  }

//	@RequestMapping("/error")
//	public String handleError(HttpServletRequest request) {
//		Object status = request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);
//
//		if (status != null) {
//			Integer statusCode = Integer.valueOf(status.toString());
//
//			if (statusCode == HttpStatus.NOT_FOUND.value()) {
//				return "error-404";
//			} else if (statusCode == HttpStatus.INTERNAL_SERVER_ERROR.value()) {
//				return "error-500";
//			}
//		}
//		return "error";
//	}

//	@Override
//	public String getErrorPath() {
//		// TODO Auto-generated method stub
//		return "error";
//	}

}
