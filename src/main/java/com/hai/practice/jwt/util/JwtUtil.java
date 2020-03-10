package com.hai.practice.jwt.util;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;

import java.util.Date;

public class JwtUtil {

    private static final String SECRET = "2020-haige-Key";
    private static long EXPIRE_60_MINUTE = 60 * 60 * 1000;
    private static int REFRESH_MINUTE = 30;
    private static final String USER_NAME = "userName";
    private static final String USER_ID = "userId";
    private static Algorithm ALGORITHM = Algorithm.HMAC256(SECRET);

    public static void main(String[] args) {
        String token = sign("admin", 1);

        token = JWT.create().withClaim(USER_NAME, "admin")
                .withClaim(USER_ID, 10086)
                .withExpiresAt(new Date(System.currentTimeMillis() + 40 * 60 * 1000))
                .sign(ALGORITHM);
        System.out.println("token=" + token);
        System.out.println(getUserId(token));
        System.out.println("verify=" + isValid(token));
    }

    public static Integer getUserId(String token){
        return JWT.decode(token).getClaim(USER_ID).asInt();
    }

    public static String getUserName(String token){
        return JWT.decode(token).getClaim(USER_NAME).asString();
    }

    public static boolean isExpired(String token){
        Date expiresAt = JWT.decode(token).getExpiresAt();
        if (expiresAt != null) {
            return expiresAt.after(new Date());
        }
        return true;
    }

    public static boolean isValid(String token){
        try {
            JWT.require(ALGORITHM)
                    .build().verify(token);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public static void verify(String token) throws JWTVerificationException {
            JWT.require(ALGORITHM)
                    .build().verify(token);
    }

    public static String sign(String loginName, Integer userId){
        return JWT.create().withClaim(USER_NAME, loginName)
                .withClaim(USER_ID, userId)
                .withExpiresAt(new Date(System.currentTimeMillis() + EXPIRE_60_MINUTE))
                .sign(ALGORITHM);
    }

    public static String refreshToken(String oldToken){
        DecodedJWT decode = JWT.decode(oldToken);
        Date expiresDate = decode.getExpiresAt();
        Date now = new Date();
        if (expiresDate == null || expiresDate.before(now)) {
            return null;
        }
        // 时间尚早，不在刷新的时间范围内
        if (now.before(DateUtil.addMinute(expiresDate, -REFRESH_MINUTE))) {
            return null;
        }
        // 刷新token，返回新的token
        String userName = decode.getClaim(USER_NAME).asString();
        Integer userId = decode.getClaim(USER_ID).asInt();
        return sign(userName, userId);
    }


}
