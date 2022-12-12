package com.capstone.nationalparkvisits.security;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.capstone.nationalparkvisits.database.DAO.UserRolesDAO;
import com.capstone.nationalparkvisits.database.DAO.UsersDAO;
import com.capstone.nationalparkvisits.database.entities.UserRoles;
import com.capstone.nationalparkvisits.database.entities.Users;

@Component
public class UserDetailsServiceImpl implements UserDetailsService {

	public static final Logger LOG = LoggerFactory.getLogger(UserDetailsServiceImpl.class);

	@Autowired
	private UsersDAO usersDao;
	
	@Autowired
	private UserRolesDAO userRolesDao;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// this class is used by spring security to fetch the user from the database 
		// and create the user roles
		
		Users user = usersDao.findByUsername(username);

		if (user == null) {
			throw new UsernameNotFoundException("Username '" + username + "' not found in database");
		}

		List<UserRoles> userRoles = userRolesDao.findByUserId(user.getId());

		boolean accountIsEnabled = true;
		boolean accountNonExpired = true;
		boolean credentialsNonExpired = true;
		boolean accountNonLocked = true;

		// setup user roles
		Collection<? extends GrantedAuthority> springRoles = buildGrantAuthorities(userRoles);

		return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), accountIsEnabled, accountNonExpired, credentialsNonExpired, accountNonLocked, springRoles);
	}


	private Collection<? extends GrantedAuthority> buildGrantAuthorities(List<UserRoles> userRoles) {
		List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();

		for (UserRoles role : userRoles) {
			authorities.add(new SimpleGrantedAuthority(role.getRoleName()));
		}

		return authorities;
	}

}
