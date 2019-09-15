package com.imoveis.raymara2.controle;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {
	
	
	@GetMapping("/login")
	public String formLogin() {
		return "usuario/login-form";
	}

}
