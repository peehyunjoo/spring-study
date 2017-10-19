package com.zzu.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SampleController2 {
	private static final Logger logger = LoggerFactory.getLogger(SampleController.class);
	
	@RequestMapping("doC")
	public String doC(@ModelAttribute("msg") String msg) {   //"msg"->파라미터 ex)http://url?msg=zzu
		logger.info("doC called.....");
		return "result";
	}
	
}
