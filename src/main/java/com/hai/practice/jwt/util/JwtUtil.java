package com.hai.practice.jwt.util;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import java.util.Date;

public class JwtUtil {

    private static final String SECRET = "2020-haige-Key";
    private static long EXPIRE_30_MINUTE = 1 * 60 * 1000;

    public static void main(String[] args) {
        String token = sign("admin", 1);
        System.out.println("token=" + token);
        System.out.println(getUserId(token));
        System.out.println(getLoginName(token));
        System.out.println("verify=" + verify(token));
    }

    public static Integer getUserId(String token){
        return JWT.decode(token).getClaim("userId").asInt();
    }

    public static String getLoginName(String token){
        return JWT.decode(token).getClaim("loginName").asString();
    }

    public static boolean verify(String token){
        try {
            JWT.require(Algorithm.HMAC256(SECRET))
                    .build().verify(token);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public static String sign(String loginName, Integer userId){
        Algorithm algorithm = Algorithm.HMAC256(SECRET);
        return JWT.create().withClaim("loginName", loginName)
                .withClaim("userId", userId)
                .withExpiresAt(new Date(System.currentTimeMillis() + EXPIRE_30_MINUTE))
                .sign(algorithm);
    }


}
