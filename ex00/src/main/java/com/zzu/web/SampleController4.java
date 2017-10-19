package com.zzu.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.zzu.domain.ProductVO;

	@Controller
	public class SampleController4 {
	private static final Logger logger = LoggerFactory.getLogger(SampleController.class);
		
		@RequestMapping("doE")
		public String doE(RedirectAttributes rttr) {  //RedirectAttributes->휘발성메세지 
			
			logger.info("doE called.....");
			rttr.addFlashAttribute("msg","This is the Message!! with redireted");
			
			return "redirect:/doF";
		}
		
		@RequestMapping("doF")
		public String doF(@ModelAttribute("msg") String msg) {
			logger.info("doF called ....."+msg);
			
			return "result";
		}
		
}
