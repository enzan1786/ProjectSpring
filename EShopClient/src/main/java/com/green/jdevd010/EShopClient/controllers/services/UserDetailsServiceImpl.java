package com.green.jdevd010.EShopClient.controllers.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.green.jdevd010.EShopClient.daos.UserRepository;
import com.green.jdevd010.EShopClient.helpers.AppString;
import com.green.jdevd010.EShopClient.models.Roles;
import com.green.jdevd010.EShopClient.models.User;
import com.green.jdevd010.EShopClient.security.MyUserDetails;


public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	private UserRepository userRepository;
	
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		User user = userRepository.getUserByUsername(username);
		
		System.out.println("loadUserByUsername ** : " + username);
		
		
		if (user == null) {
			System.out.println("loadUserByUsername with not found username");
			throw new UsernameNotFoundException(AppString.usernameNotFound);
		}	
		for(Roles role : user.getRoles()) {
			System.out.println("user: "+ username + " has role: "+role.getName());
		}
		return new MyUserDetails(user);
	}
}
