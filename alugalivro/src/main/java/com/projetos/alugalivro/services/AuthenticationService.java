package com.projetos.alugalivro.services;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {	
	
	public AuthenticationService() {}
	
	public String getLoggedUserName() {
		try {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String currentName = authentication.getName();
		return currentName;
		
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return null;
		
	}
	
	public boolean isLogged(){
		try {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		
		if(authentication.getName().equals("anonymousUser")) {
			return false;
		}
		else return true;
		}
		catch(Exception e) {
			e.printStackTrace();
			}

		return false;
	
	}
}
