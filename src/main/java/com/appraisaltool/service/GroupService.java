package com.appraisaltool.service;

import java.util.List;
import javax.validation.Valid;
import com.appraisaltool.model.Group;

public interface GroupService {

    public Group createNewGroup(@Valid String groupName);

    public List<Group> getAllGroups();

}
