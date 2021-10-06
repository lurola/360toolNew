package com.appraisaltool.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Table(name = "TEAM")
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Team {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer teamId;
	
	@Column(name = "teamName")
	String teamName;

}
