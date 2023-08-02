package douglas.lol.match.controller;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import douglas.lol.match.error.ApiErrors;
import douglas.lol.match.exception.BussinesRuleException;

@RestControllerAdvice
public class ApplicationControllerAdvice {
	
	@ExceptionHandler(BussinesRuleException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public ApiErrors handleException(BussinesRuleException ex) {
		String errorMessage = ex.getMessage();
		return new ApiErrors(errorMessage);
	}
}
