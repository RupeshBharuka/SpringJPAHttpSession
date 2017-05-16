package com.spring.jpa.app;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "coadingskill")
public class CoadingSkills {
	
	@Id
	@Column(name = "skillid")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer skillId;
	
	@Column(name = "java")
	private String java;
	
	@Column(name = "dotnet")
	private String dotNet;
	
	@Column(name = "python")
	private String python;

	
	public CoadingSkills(){
		
	}
	
	public CoadingSkills(String java, String dotNet, String python) {
		this.java = java;
		this.dotNet = dotNet;
		this.python = python;
	}

	public Integer getSkillId() {
		return skillId;
	}

	public void setSkillId(Integer skillId) {
		this.skillId = skillId;
	}

	public String getJava() {
		return java;
	}

	public void setJava(String java) {
		this.java = java;
	}

	public String getDotNet() {
		return dotNet;
	}

	public void setDotNet(String dotNet) {
		this.dotNet = dotNet;
	}

	public String getPython() {
		return python;
	}

	public void setPython(String python) {
		this.python = python;
	}

	@Override
	public String toString() {
		return "CoadingSkills [skillId=" + skillId + ", java=" + java + ", dotNet=" + dotNet + ", python=" + python
				+ "]";
	}
	
}
