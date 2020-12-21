package com.appraisaltool.model;

import java.util.ArrayList;
import java.util.List;

import lombok.Getter;

public enum Evaluations {

	INSOLVABLE (0, "Insolvable"),
    SOLVABLE (1, "Solvable"), 
    IMPROVABLE (2, "Improvable"), 
    GOOD (3 , "Good"),
    REMARKABLE  (4, "Remarkable"),
    EXCELENT (5, "Excelent");
	
	public final Integer value; 
	public final String name;
	

	public Integer getValue() {
		return this.value;
	}
	
	public String getName() {
		return this.name;
	}
	
	Evaluations(int i, String name) {
		this.value = i;
		this.name = name;
	}
	
	public static List<Evaluations> getEvaluationsAsAList() {
		List<Evaluations> list = new ArrayList<Evaluations>();
		
		list.add(INSOLVABLE);
		list.add(SOLVABLE);
		list.add(IMPROVABLE);
		list.add(GOOD);
		list.add(REMARKABLE);
		list.add(EXCELENT);
		return list;
	}

}
