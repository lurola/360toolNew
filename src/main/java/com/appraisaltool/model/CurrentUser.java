package com.appraisaltool.model;

import org.springframework.security.core.authority.AuthorityUtils;

public class CurrentUser extends org.springframework.security.core.userdetails.User {

	private static final long serialVersionUID = 1L;
	
	private User user;

    public CurrentUser(User user) {
        super(user.getEmail(), user.getPassword(), AuthorityUtils.createAuthorityList(user.getAppRole().toString()));
        this.user = user;
    }

    public User getUser() {
        return user;
    }

    public Long getId() {
        return user.getUserId();
    }

    public ApplicationRole getRole() {
        return user.getAppRole();
    }
    
    public String getName() {
    	return user.getName();
    }
    
    public String getSurname() {
    	return user.getSurname();
    }
    
    public ApplicationRole getAppRole() {
    	return user.getAppRole();
    }

    @Override
    public String toString() {
        return "CurrentUser{user=" + user + "} " + super.toString();
    }
}
