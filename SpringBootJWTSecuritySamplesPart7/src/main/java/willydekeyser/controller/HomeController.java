package willydekeyser.controller;

import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

	@GetMapping("/")
	public String home(Authentication authentication) {
		return "Hello, " + authentication.getName() + " - " + authentication.getAuthorities();
	}
	
	@GetMapping("/user")
	public String user(Authentication authentication) {
		return "Hello User, " + authentication.getName() + " - " + authentication.getAuthorities();
	}
	
	@GetMapping("/admin")
	public String admin(Authentication authentication) {
		return "Hello Admin, " + authentication.getName() + " - " + authentication.getAuthorities();
	}
}
