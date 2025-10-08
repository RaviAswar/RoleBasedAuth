package com.authentication.rolebased.security;


import io.jsonwebtoken.*;
import org.springframework.stereotype.Component;
import java.util.*;
import java.util.stream.Collectors;

@Component
public class JwtUtil {
    private final String SECRET = "mysecretkey";  // use env variable in production
    private final long EXPIRATION = 1000 * 60 * 60; // 1 hour

    // Generate token
    public String generateToken(org.springframework.security.core.userdetails.User userDetails) {
        Map<String, Object> claims = new HashMap<>();
        claims.put("roles", userDetails.getAuthorities()
                .stream().map(Object::toString).collect(Collectors.toList()));
        return Jwts.builder()
                .setClaims(claims)
                .setSubject(userDetails.getUsername())
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION))
                .signWith(SignatureAlgorithm.HS512, SECRET)
                .compact();
    }

    // Extract username
    public String extractUsername(String token) {
        return getClaims(token).getSubject();
    }

    // Extract roles
    public List<String> extractRoles(String token) {
        return getClaims(token).get("roles", List.class);
    }

    // Validate token
    public boolean validateToken(String token, org.springframework.security.core.userdetails.User userDetails) {
        return extractUsername(token).equals(userDetails.getUsername()) && !isTokenExpired(token);
    }

    private Claims getClaims(String token) {
        return Jwts.parser().setSigningKey(SECRET).parseClaimsJws(token).getBody();
    }

    private boolean isTokenExpired(String token) {
        return getClaims(token).getExpiration().before(new Date());
    }
}
