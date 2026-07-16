package com.shibananda.etms.jwt;

import java.nio.charset.StandardCharsets;
import java.util.Date;

import javax.crypto.SecretKey;

import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;

@Component
public class JwtUtil {

	private static final String SECRET_KEY = "mySecretKeyForEmployeeTaskManagementSystem123456";

	private static final long EXPIRATION_TIME = 1000 * 60 * 60;

	private final SecretKey key = Keys.hmacShaKeyFor(SECRET_KEY.getBytes(StandardCharsets.UTF_8));

	public String generateToken(String email) {

		return Jwts.builder().subject(email).issuedAt(new Date())
				.expiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
				.signWith(key)
				.compact();
	}
	
	public Claims extractClaims(String token) {

	    return Jwts.parser()
	               .verifyWith(key)
	               .build()
	               .parseSignedClaims(token)
	               .getPayload();
	}
	
	public String extractEmail(String token) {
			return extractClaims(token).getSubject();
	}

	
	public Date extractExpiration(String token) {
		return extractClaims(token).getExpiration();
	}
	
	public boolean isTokenExpired(String token) {
			return extractExpiration(token).before(new Date());
	}
	
	public boolean validateToken(String token,String email) {
			return extractEmail(token).equals(email) && !isTokenExpired(token);
	}
}
