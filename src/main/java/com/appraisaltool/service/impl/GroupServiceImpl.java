package com.appraisaltool.service.impl;

import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.appraisaltool.model.Group;
import com.appraisaltool.repository.GroupRepository;
import com.appraisaltool.service.GroupService;

@Service
public class GroupServiceImpl implements GroupService {

	@Autowired GroupRepository groupRepo;
	


	public Group createNewGroup(@Valid Group groupName) {
		return groupRepo.save(groupName);
	}

	public Group createNewGroup(@Valid String groupName) {
        Group g = new Group(null, groupName);
		return groupRepo.save(g);
		
	}
	
	public List<Group> getAllGroups() {
		return groupRepo.findAll();
	}

	
    public Group getGroupById(Integer id) {
        return groupRepo.getOne(id);
    }
	
	
	
}
