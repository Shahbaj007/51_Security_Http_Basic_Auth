package in.rahulit.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MsgRestController {
	
	@GetMapping("/welcome")
	public String getMsg() {
		
		return "Welcome to Spring Security";
		
	}
	
	@GetMapping("/greet")
	public String getGreetMsg() {
		return "Good Morning...!";
	}
	
	@GetMapping("/contact")
	public String contactUs() {
		return "Contact : +91 - 9988776655";
	}
}
