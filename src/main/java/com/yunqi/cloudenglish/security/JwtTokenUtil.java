package com.yunqi.cloudenglish.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @描述:
 * @版权: Copyright (c) 2018
 * @创建人 Jesse Xue
 * @创建时间 12:06 2018/5/14
 * @版本 v1.0
 */
@Component
public class JwtTokenUtil implements Serializable{
    private static final String CLAIM_KEY_USERNAME="sub";

    @Value("${jwt.secret}")
    private String secret;
    
    @Value("${jwt.expiration}")
    private Long expiration;
    
    public String getUserNameFromToken(String token){
        String userName;
        try {
            final Claims claims = getClaimsFromToken(token);
            userName = claims.getSubject();
        } catch (Exception e) {
            userName = null;
        }
        return userName;
    }

    public Date getExpirationDateFromToken(String token){
        Date expiration;
        try {
            final Claims claims = getClaimsFromToken(token);
            expiration = claims.getExpiration();
        } catch (Exception e) {
            expiration = null;
        }
        return expiration;
    }

    private Claims getClaimsFromToken(String token) {
        Claims claims;
        try {
            claims = Jwts.parser()
                    .setSigningKey(secret)
                    .parseClaimsJws(token)
                    .getBody();
        } catch (Exception e) {
            claims = null;
        }
        return claims;
    }

    private Date generateExpirationDate(){
        return new Date(System.currentTimeMillis()+expiration*1000);
    }
    private Boolean isTokenExpired(String token){
        final Date expiration=getExpirationDateFromToken(token);
        return expiration.before(new Date());

    }

    public String generateToken(UserDetails userDetails){
        Map<String,Object> claims=new HashMap<>();
        claims.put(CLAIM_KEY_USERNAME,userDetails.getUsername());
        return generateToken(claims);
    }
    String generateToken(Map<String,Object> claims){
        return Jwts.builder()
                .setClaims(claims)
                .setExpiration(generateExpirationDate())
                .signWith(SignatureAlgorithm.HS512,secret)
                .compact();
    }

    public String refreshToken(String token){
        String refreshedToken;
        try {
            final Claims claims=getClaimsFromToken(token);
            refreshedToken = generateToken(claims);
        }catch (Exception e){
            refreshedToken=null;
        }
        return refreshedToken;
    }

    public Boolean validateToken(String token,UserDetails userDetails){
        JwtUserModel user= (JwtUserModel) userDetails;
        final String identity = getUserNameFromToken(token);
        return (identity.equals(user.getUsername()))&& !isTokenExpired(token);
    }


}
