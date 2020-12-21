package com.appraisaltool.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.appraisaltool.model.Office;


@Repository
public interface OfficeRepository extends JpaRepository<Office, Long>{
	
	 Office getOfficeByOfficeName(String officeName);
	
}
