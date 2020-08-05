package com.security.random;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * @Description TODO
 * @Author ex_langqf
 * @Date 2020/7/10 16:40
 */
public class TestCookie {
    public static void main(String[] args) {
        boolean isLogin = true;
        /*if(isLogin){
            String timeStampStr = (String)
                    map.get(UserAuthenticationContext.TIMESTAMP);
            long loginTime=0;
            try{
                loginTime = Long.parseLong(timeStampStr);
            }catch(NumberFormatException e){
                if(logger.isInfoEnabled()){
                    logger.info("loginid:" +  usr.getLoginld() + "timestamp has exception" + timeStamStr):
                }
            }
            long  now = System.currentTimeMillis()/1000;
            if(now - loginTime > UserAuthenticationContext.COOKIE_VALIDITY){
                usr.setAuthenticated(false, true);
                if(logger.inInfoEnabled()){
                    logger.info("loginId:" + usr.getLoginid() + "loginTime:" + loginTime + "nowTime:" + now);
                }
            }
        }*/

    }
    private static Map<String, Cookie> ReadCookieMap(HttpServletRequest request){
        Map<String,Cookie> cookieMap = new HashMap<String,Cookie>();
        Cookie[] cookies = request.getCookies();
        if(null != cookies){
            for(Cookie cookie : cookies){
                cookieMap.put(cookie.getName(), cookie);
            }
        }
        return cookieMap;
    }

}
