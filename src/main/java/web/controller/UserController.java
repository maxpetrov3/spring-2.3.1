package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import web.model.User;
import web.service.UserService;

@Controller
public class UserController {

	@Autowired
	UserService userService;

	@GetMapping(value = "/")
	public String getUsers(ModelMap model) {
		model.addAttribute("users", userService.getAllUsers());
		return "index";
	}

	@GetMapping(value = "/user")
	public String getUserData(@RequestParam(name = "userId") String userId, ModelMap model) {
		model.addAttribute("tuser", userService.getUserById(userId));
		return "user";
	}

	@PostMapping(name = "/")
	public String updateUserData(@ModelAttribute User user) {
		userService.updateUser(user);
		return "redirect:/";
	}

	@RequestMapping(value = "/delete/{id}")
	public String deleteUser(@PathVariable Long id) {
		userService.deleteUserById(id);
		return "redirect:/";
	}

}