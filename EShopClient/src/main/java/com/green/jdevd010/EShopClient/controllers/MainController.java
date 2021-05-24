package com.green.jdevd010.EShopClient.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.green.jdevd010.EShopClient.controllers.services.ProductService;
import com.green.jdevd010.EShopClient.controllers.services.RoleService;
import com.green.jdevd010.EShopClient.controllers.services.UserRoleService;
import com.green.jdevd010.EShopClient.controllers.services.UserService;
import com.green.jdevd010.EShopClient.daos.ProductRepository;
import com.green.jdevd010.EShopClient.models.Product;
import com.green.jdevd010.EShopClient.models.Roles;
import com.green.jdevd010.EShopClient.models.User;
import com.green.jdevd010.EShopClient.models.UserRole;

@Controller
public class MainController {

	@Autowired
	private UserService userService;
	@Autowired
	private RoleService roleService;
	@Autowired
	private UserRoleService userRoleService;
	@Autowired
	private ProductService productService;
	
	private BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
	@GetMapping("/")
	public String showIndex(Model model) {
		List<Product> allLatest = productService.getAllProduct();
		model.addAttribute("allLatest", allLatest);
		return "index";
	}
	@GetMapping("/login")
	public String showLoginView() {
		
		return "login";
	}
	
	@GetMapping("/signup")
	public String showSignupView(Model model) {
		User account = new User();
		model.addAttribute("account", account);
		return "signup";
	}
	@RequestMapping(value = "/save", method = RequestMethod.POST, params = "submit")
	public String saveUser(@ModelAttribute("account") User account) {
		account.setEnabled(true);
		List<User> ListUser = new ArrayList<User>();
		ListUser = userService.getAllUser();
		User temp = new User();
		UserRole role = new UserRole();
		role.setRole_ID(3);
		
		
		
		temp = ListUser.get(ListUser.size()-1);
		account.setId(temp.getId()+1);
		account.setPassword(encoder.encode(account.getPassword()));
		role.setUser_id(account.getId());
		for(User acc : ListUser) {
			if(account.getUsername().equals(acc.getUsername())) {
				
			}
		}
		
		System.out.println("Add user ****");
		userService.addUser(account);
		userRoleService.addUserRole(role);
		
		return "redirect:/login";
	}
	
	@GetMapping("/login2")
	public String showLogin2View(Model model) {
		
		User user = new User();
		model.addAttribute("user", user);
		
		return "login2";
	}
	
	@PostMapping("/login2")
	public String doLogin2(@ModelAttribute("user") User formUser) {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		User dbUser = userService.getUserByUsername(formUser.getUsername());
		if (dbUser != null && encoder.matches(formUser.getPassword(), dbUser.getPassword())) {
			return "redirect:/";
		} else {
			return "redirect:/login";
		}
	}
	
	@GetMapping("/product")
	public String showProductView() {
		
		return "product";
	}
	@GetMapping("/login_error")
	public String showError() {
		
		return "login_error";
	}
	@GetMapping("/single-product")
	public String single_product() {
		
		return "single-product";
	}
	@RequestMapping("/single-product/{id}")
	public ModelAndView updateProduct(@PathVariable(name = "id") Integer id, Model model) {
		ModelAndView modelAndView = new ModelAndView("single-product");
		
		Product product = productService.get(id);
		modelAndView.addObject(product);
		model.addAttribute("info", product);
		
		return modelAndView;
		
	}
}
