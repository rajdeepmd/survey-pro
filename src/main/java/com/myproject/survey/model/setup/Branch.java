package com.myproject.survey.model.setup;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "branch")

public class Branch {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@Column(name = "branch_name", nullable = false)
	private String branchName;

	@ManyToOne
	@JoinColumn(name = "com_id")
	private Company com;	
	
	public Branch() {
		super();
	}

	public Branch(int id) {
		super();
		this.id = id;
	}


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getBranchName() {
		return branchName;
	}

	public void setBranchName(String branchName) {
		this.branchName = branchName;
	}

	public Company getCom() {
		return com;
	}

	public void setCom(Company com) {
		this.com = com;
	}

}
