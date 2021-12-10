package com.legaspicary.mvc;

//import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HelloWorldController {

	@RequestMapping("/show-form")
	public String showForm() {
		return "helloworld-form";
	}
	
	@RequestMapping("/process-form")
	public String processForm() {
		return "helloworld";
	}
	
	@RequestMapping("/process-form-v2")
	public String shoutTransform(@RequestParam("studentName") String name, Model model) {
//	public String shoutTransform(HttpServletRequest request, Model model) {
//		String name = request.getParameter("studentName");
		String upperCased = name.toUpperCase() + "!";
		model.addAttribute("message", upperCased);
		return "helloworld-v2";
	}
}
