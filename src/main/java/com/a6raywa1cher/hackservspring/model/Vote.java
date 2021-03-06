package com.a6raywa1cher.hackservspring.model;

import com.a6raywa1cher.hackservspring.utils.Views;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.JsonView;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(uniqueConstraints = {
		@UniqueConstraint(columnNames = {"criteria_id", "judge_id", "team_id"})
})
@JsonIdentityInfo(
		generator = ObjectIdGenerators.PropertyGenerator.class,
		property = "id")
public class Vote {
	@Id
	@GeneratedValue
	@JsonView(Views.Public.class)
	private Long id;

	@ManyToOne(optional = false)
	@JsonView(Views.Public.class)
	@JsonIdentityReference(alwaysAsId = true)
	private VoteCriteria criteria;

	@ManyToOne(optional = false)
	@JsonView(Views.Public.class)
	@JsonIdentityReference(alwaysAsId = true)
	private User judge;

	@ManyToOne(optional = false)
	@JsonView(Views.Public.class)
	@JsonIdentityReference(alwaysAsId = true)
	private Team team;

	@Column(nullable = false)
	@JsonView(Views.Public.class)
	private int vote;
}
