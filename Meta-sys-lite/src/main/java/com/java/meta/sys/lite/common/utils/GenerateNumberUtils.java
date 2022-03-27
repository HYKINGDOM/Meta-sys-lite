package com.java.meta.sys.lite.common.utils;

import cn.hutool.core.date.DateUtil;

import static com.java.meta.sys.lite.common.utils.RanDomUtils.generateSixRandomInteger;

/**
 * @author HY
 */
public class GenerateNumberUtils {


    public static Long generateUserIdByNowDate() {
        String generatedUserIdByDate = DateUtil.today().replace("-", "") + generateSixRandomInteger();
        return Long.valueOf(generatedUserIdByDate);
    }
}
