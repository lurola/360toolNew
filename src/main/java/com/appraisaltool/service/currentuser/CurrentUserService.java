package com.appraisaltool.service.currentuser;

import com.appraisaltool.model.CurrentUser;

public interface CurrentUserService {

    boolean canAccessUser(CurrentUser currentUser, Long userId);

}
