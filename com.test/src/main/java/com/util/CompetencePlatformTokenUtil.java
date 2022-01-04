package com.util;




import org.springframework.util.DigestUtils;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by reeves on 2021/3/22.
 */
public class CompetencePlatformTokenUtil {




    /**
     * 生成md5
     * @param str
     * @return
     */
    public static String getMD5(String str) {
        String md5 = DigestUtils.md5DigestAsHex(str.getBytes());
        return md5;
    }


}
