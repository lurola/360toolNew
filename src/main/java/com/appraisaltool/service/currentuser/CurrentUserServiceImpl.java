package com.appraisaltool.service.currentuser;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

import com.appraisaltool.model.ApplicationRole;
import com.appraisaltool.model.CurrentUser;

@Service
public class CurrentUserServiceImpl implements CurrentUserService {

	private static final Logger logger = LogManager.getLogger(CurrentUserServiceImpl.class);

    @Override
    public boolean canAccessUser(CurrentUser currentUser, Long userId) {
        logger.debug("Checking if user={} has access to user={}", currentUser, userId);
        return currentUser != null
                && (currentUser.getRole() == ApplicationRole.ADMIN || currentUser.getId().equals(userId));
    }

}
