package com.a6raywa1cher.hackservspring.security.jpa;

import com.a6raywa1cher.hackservspring.model.User;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Data
public class RefreshToken {
	@Id
	@GeneratedValue
	private long id;

	@Column(unique = true)
	private String token;

	@Column
	private LocalDateTime expiringAt;

	@ManyToOne
	private User user;
}
