package com.example.electionApp.ElectionApp.Security;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;


import io.jsonwebtoken.Claims;
import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

@Component
public class TokenProvider {

    private static final String SECRET_KEY = "404E635266556A586E3272357538382F413F4428472B4B625064537566B5970";
    public String extractUserEmail(String jwtToken) {
        return extractClaim(jwtToken , Claims::getSubject);
    }


    public String generateToken(UserDetails userDetails){
        return generateToken(new HashMap<>(),userDetails);
    }
    public String generateToken(Map<String, Object> extractClaims, UserDetails userDetails){
        return Jwts.builder().
                setClaims(extractClaims)
                .setSubject(userDetails.getUsername())
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60* 24))
                .signWith(getSignInkey(), SignatureAlgorithm.HS256)
                .compact();

    }
    public  boolean isTokenValid(String jwtToken, UserDetails userDetails) {
        final String username =  extractUserEmail(jwtToken);
        return username.equals(userDetails.getUsername()) && !isTokenExpired(jwtToken);
    }

    private boolean isTokenExpired(String jwtToken) {
        return extractExpiration(jwtToken).before(new Date());
    }

    private Date extractExpiration(String jwtToken) {
        return extractClaim(jwtToken, Claims::getExpiration );
    }

    public <T> T extractClaim(String jwtToken, Function<Claims,T> claimsResolver){
        final Claims claims = extractAllClaims(jwtToken);
        return claimsResolver.apply(claims);

    }

    public Claims extractAllClaims(String jwtToken) {
        return Jwts.parserBuilder()
                .setSigningKey(getSignInkey()).
                build().
                parseClaimsJws(jwtToken).
                getBody();
    }

    private Key getSignInkey() {
        byte [] keyBytes = Decoders.BASE64.decode(SECRET_KEY);
        return Keys.hmacShaKeyFor(keyBytes);
    }
}
