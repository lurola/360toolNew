package com.appraisaltool.dto;

import java.util.ArrayList;
import java.util.List;

import com.appraisaltool.model.Evaluations;

import lombok.Getter;

@Getter
public class EvaluationsDTO {

	
	Integer value;
	String name;
	
	public EvaluationsDTO() { }
	
	public EvaluationsDTO(Integer value, String name) {
		this.value = value;
		this.name = name;
	}
	
	public final static List<EvaluationsDTO> getAllEvaluations() {
		
		List<EvaluationsDTO> list = new ArrayList<EvaluationsDTO>();
		
		list.add(new EvaluationsDTO(0, "Irreconducible"));
		list.add(new EvaluationsDTO(1, "Reconducible"));
		list.add(new EvaluationsDTO(2, "Mejorable"));
		list.add(new EvaluationsDTO(3, "Bueno"));
		list.add(new EvaluationsDTO(4, "Destacado"));
		list.add(new EvaluationsDTO(5, "Excelente"));

		
		return list;
	}
}
