package com.appraisaltool.service;

import com.appraisaltool.model.CurrentUser;

public interface CurrentUserService {

    boolean canAccessUser(CurrentUser currentUser, Long userId);

}
