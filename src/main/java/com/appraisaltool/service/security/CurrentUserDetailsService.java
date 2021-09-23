package com.appraisaltool.service.security;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import com.appraisaltool.model.CurrentUser;
import com.appraisaltool.model.User;
import com.appraisaltool.service.UserService;

@Service
public class CurrentUserDetailsService implements UserDetailsService {

	private static final Logger logger = LogManager.getLogger(CurrentUserDetailsService.class);
    private final UserService userervice;

    @Autowired
    public CurrentUserDetailsService(UserService userService) {
        this.userervice = userService;
    }

    @Override
    public CurrentUser loadUserByUsername(String email) throws UsernameNotFoundException {
        logger.debug("Authenticating user with email={}", email.replaceFirst("@.*", "@***"));
        User user = userervice.getUserByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException(String.format("User with email=%s was not found", email)));
        return new CurrentUser(user);
    }

}
