package com.appraisaltool.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import com.appraisaltool.config.CurrentUserDetailsService;
import com.appraisaltool.model.ApplicationRole;
import com.appraisaltool.model.CurrentUser;
import com.appraisaltool.service.CurrentUserService;

@Service
public class CurrentUserServiceImpl implements CurrentUserService {

    private static final Logger LOGGER = LoggerFactory.getLogger(CurrentUserDetailsService.class);

    @Override
    public boolean canAccessUser(CurrentUser currentUser, Long userId) {
        LOGGER.debug("Checking if user={} has access to user={}", currentUser, userId);
        return currentUser != null
                && (currentUser.getRole() == ApplicationRole.ADMIN || currentUser.getId().equals(userId));
    }

}
