package com.appraisaltool.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.appraisaltool.model.Group;

@Repository
public interface GroupRepository extends JpaRepository<Group, Integer> {


		
	}

