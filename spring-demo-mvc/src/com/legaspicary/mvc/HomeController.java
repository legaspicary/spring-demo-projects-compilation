package com.legaspicary.mvc;

import java.sql.DriverManager;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

	@RequestMapping("/")
	public String showPage() {
		String jdbcUrl = "jdbc:mysql://localhost:3306/hibernate-demo?useSSL=false&serverTimezone=UTC";
		try {
			DriverManager.getConnection(jdbcUrl, "root", "root");
			System.out.println("Successfully connected!");
		} catch (Exception e) {
			System.out.println(e);
		}

		return "main-menu";
	}
}
