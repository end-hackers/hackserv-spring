package com.a6raywa1cher.hackservspring.security.authentication;

import com.a6raywa1cher.hackservspring.security.jwt.JwtToken;
import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;

public class JwtAuthentication extends AbstractAuthenticationToken {
	private final JwtToken jwtToken;

	public JwtAuthentication(Collection<? extends GrantedAuthority> authorities, JwtToken jwtToken) {
		super(authorities);
		this.jwtToken = jwtToken;
	}

	@Override
	public JwtToken getCredentials() {
		return jwtToken;
	}

	@Override
	public Long getPrincipal() {
		return jwtToken.getUid();
	}
}
