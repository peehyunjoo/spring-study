package com.zzu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomeController {
@RequestMapping(value = "/test", method = RequestMethod.GET)
	public String ajaxTest() {

		return "test";
	}
}
