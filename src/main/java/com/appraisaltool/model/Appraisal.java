package com.appraisaltool.model;

import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import com.appraisaltool.dto.domain.AppraisalTypeType;
import lombok.AllArgsConstructor;
import lombok.Data;

@Entity
@Data
@Table (name = "APPRAISAL")
@AllArgsConstructor()
public class Appraisal {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer appraisalId;
	
    @ManyToOne
    @JoinColumn(name = "evaluatedPersonId", insertable = true, updatable = true)
    private User evaluatedPerson;

    @ManyToOne
    @JoinColumn(name = "appraiserId", insertable = true, updatable = true)
    private User appraiser;
	
	@Column (name = "evalDate")
	private Integer evalDate;
	
    @Column(name = "type")
    @Enumerated(EnumType.STRING)
    private AppraisalTypeType type;

	@Column (name = "status")
	private Integer status;

    @OneToMany(mappedBy = "appraisal", cascade = CascadeType.ALL)
	private List<AppraisalItem> apprItemList;
}
