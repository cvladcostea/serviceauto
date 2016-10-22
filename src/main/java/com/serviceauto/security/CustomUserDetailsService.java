package com.serviceauto.security;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.entity.UserEntity;
import com.serviceauto.dao.IUserEntityDao;
import com.serviceauto.dao.IUserRoleEntityDao;



@Service("customUserDetailsService")
public class CustomUserDetailsService implements UserDetailsService{
	private final IUserEntityDao userRepository;
	private final IUserRoleEntityDao userRolesRepository;
	
	@Autowired
    public CustomUserDetailsService(IUserEntityDao userRepository,IUserRoleEntityDao userRolesRepository) {
        this.userRepository = userRepository;
        this.userRolesRepository=userRolesRepository;
    }
	
        
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UserEntity user=userRepository.findByUsername(username);
		if(user.equals(null)){
			throw new UsernameNotFoundException("No user present with username: "+username);
		}else{
			List<String> userRoles=userRolesRepository.findRoleByUserName(username);
			return new CustomUserDetails(user,userRoles);
		}
	}
		
}
