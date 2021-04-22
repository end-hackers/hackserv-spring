package com.a6raywa1cher.hackservspring.model;

import com.a6raywa1cher.hackservspring.utils.Views;
import com.fasterxml.jackson.annotation.*;
import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import java.time.ZonedDateTime;
import java.util.List;

@Entity
@Data
@JsonIdentityInfo(
		generator = ObjectIdGenerators.PropertyGenerator.class,
		property = "id")
@ToString(exclude = {"members"})
public class Team {
	@Id
	@GeneratedValue
	@JsonView(Views.Public.class)
	private Long id;

	@Column
	@JsonView(Views.Public.class)
	private String name;

	@OneToMany(mappedBy = "team")
	@JsonView(Views.Public.class)
	@JsonIdentityReference(alwaysAsId = true)
	private List<User> members;


	@OneToMany(mappedBy = "request")
	@JsonView(Views.Internal.class)
	@JsonIdentityReference(alwaysAsId = true)
	private List<User> requests;

	@OneToOne
	@JsonView(Views.Public.class)
	@JsonIdentityReference(alwaysAsId = true)
	private User captain;

	@ManyToOne
	@JsonView(Views.Public.class)
	@JsonIdentityReference(alwaysAsId = true)
	private Track track;

	@Column
	@JsonView(Views.Public.class)
	@JsonFormat(shape = JsonFormat.Shape.STRING)
	private ZonedDateTime createdAt;
}
