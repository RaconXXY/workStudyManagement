package com.workstudy.ssm.utils;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA
 * Created By fukaiqi
 * Date: 2017/7/31 0031
 * Time: 18:53
 */
public class CookieUtil {
    public static void setTokenCookie(HttpServletResponse response, String token, String userId, int maxAgeSecs) {
        Cookie cookieToken = new Cookie("token", token);
        cookieToken.setMaxAge(maxAgeSecs);// 设置为30min
        cookieToken.setPath("/");
        response.addCookie(cookieToken);
        Cookie cookieUserId = new Cookie("userId", userId);
        cookieUserId.setMaxAge(maxAgeSecs);// 设置为30min
        cookieUserId.setPath("/");
        response.addCookie(cookieUserId);
    }

    public static Cookie getCookieByName(HttpServletRequest request, String name){
        Map<String,Cookie> cookieMap = ReadCookieMap(request);
        if(cookieMap.containsKey(name)){
            Cookie cookie = cookieMap.get(name);
            return cookie;
        }else{
            return null;
        }
    }

    private static Map<String,Cookie> ReadCookieMap(HttpServletRequest request){
        Map<String,Cookie> cookieMap = new HashMap<>();
        Cookie[] cookies = request.getCookies();
        if(null!=cookies){
            for(Cookie cookie : cookies){
                cookieMap.put(cookie.getName(), cookie);
            }
        }
        return cookieMap;
    }
}
