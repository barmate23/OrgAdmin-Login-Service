package com.AccessManagement.Config;

import com.AccessManagement.Model.Users;
import com.AccessManagement.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class JwtUserDetailsService implements UserDetailsService {

	@Autowired
	UserRepository userRepository;
	@Autowired
	PasswordEncoder bcryptEncoder;

	@Autowired
	UserExtendedDao userExtendedDao;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		final org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(JwtUserDetailsService.class);
		bcryptEncoder.encode(username);
		   System.out.println(" +++++++++++++++++++++++++++++++ "+ bcryptEncoder.encode(username));
		Users user = userRepository.findByUsername(username);
		if (user ==null) {
			log.error("User not found in the database");
			throw new UsernameNotFoundException("User not found with username: " + username);

	}
		else {
			log.info("User found in the database: {}", username);
			return new User(user.getUsername(),user.getPassword(),new ArrayList<>());
	}

	}

	public List<JwtRequest> getDetailsAll(String username) {
		return userExtendedDao.getDetailsAll(username);

	}
}









