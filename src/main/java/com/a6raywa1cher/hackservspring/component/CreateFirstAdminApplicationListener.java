package com.a6raywa1cher.hackservspring.component;

import com.a6raywa1cher.hackservspring.model.User;
import com.a6raywa1cher.hackservspring.model.UserRole;
import com.a6raywa1cher.hackservspring.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class CreateFirstAdminApplicationListener implements ApplicationListener<ApplicationReadyEvent> {
	private static final Logger logger = LoggerFactory.getLogger(CreateFirstAdminApplicationListener.class);

	private final String email;

	private final String password;

	private final UserService userService;

	public CreateFirstAdminApplicationListener(@Value("${app.first-admin.email}") String email,
	                                           @Value("${app.first-admin.password}") String password,
	                                           UserService userService) {
		this.email = email;
		this.password = password;
		this.userService = userService;
	}

	@Override
	public void onApplicationEvent(ApplicationReadyEvent event) {
		if (userService.findFirstByUserRole(UserRole.ADMIN).isEmpty()) {
			User user = userService.create(UserRole.ADMIN, email, password);
			userService.editEmailValidated(user, true);
			logger.info("Created admin-user");
		}
	}
}
