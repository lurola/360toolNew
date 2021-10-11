package com.appraisaltool.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.appraisaltool.model.AppraiserAssignement;

public interface AppraiserAssignementRepository extends JpaRepository<AppraiserAssignement, Integer> {

}
