package com.zzu.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zzu.domain.ProductVO;

@Controller
public class SampleController5 {
	@RequestMapping("doJson")
	public @ResponseBody ProductVO doJSON() {
		ProductVO vo = new ProductVO("zzu",3000);
		return vo;
	}
}
// 