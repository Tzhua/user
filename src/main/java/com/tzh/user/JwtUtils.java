package com.tzh.user;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.util.StringUtils;

import java.util.Date;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: TZH
 * @Date: 2023-06-11 17:41
 * @Description: JWT工具类
 */
public class JwtUtils {
    private static final String SIGN_KEY = "laohuang";
    //生成
    public static String generateJwt(Map<String,Object> claims){
        return Jwts.builder()
                .setClaims(claims) //自定义内容
                .signWith(SignatureAlgorithm.HS256, SIGN_KEY)//签名算法
                .setExpiration(new Date(System.currentTimeMillis() +  60 * 60 * 1000)) //有效期
                .compact();
    }
    //解析
    public static Claims parseJwt(String token){
        return Jwts.parser()
                .setSigningKey(SIGN_KEY)
                .parseClaimsJws(token)
                .getBody();
    }
}
