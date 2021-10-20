package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.model.User;
import web.service.UserService;

@Controller
public class UserController {

	@Autowired
	UserService userService;

	@RequestMapping(value = "/")
	public String getUsers(ModelMap model) {
		userService.saveUser(new User("Max", "Petrov", 22));
		userService.saveUser(new User("Ivan", "Ivanov", 24));
		model.addAttribute("users", userService.getAllUsers());
		return "index";
	}

	@GetMapping(value = "/user")
	public String getUserData(@RequestParam(name = "userId") String userId, ModelMap model) {
		model.addAttribute("user", userService.getUserById(userId));
		return "user";
	}

	@PostMapping(name = "/save")
	public String updateUserData(@RequestParam(name = "user") User user, ModelMap model) {
		userService.updateUser(user);
		return "index";
	}

}