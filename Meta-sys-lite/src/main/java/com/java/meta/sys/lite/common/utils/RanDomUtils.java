package com.java.meta.sys.lite.common.utils;

import org.apache.commons.lang3.RandomStringUtils;

import java.util.concurrent.ThreadLocalRandom;

import static com.java.meta.sys.lite.common.constant.user.SysUserValidConstant.*;
import static com.java.meta.sys.lite.common.utils.GenerateNumberUtils.generateUserIdByNowDate;

/**
 * @author HY
 */
public class RanDomUtils {


    public static final String EXP_USER_ACCOUNT = randomAlphanumeric(MAX_USER_ACCOUNT_LENGTH);
    public static final String EXP_USER_NAME = randomAlphanumeric(MAX_USER_NAME_LENGTH);
    public static final String EXP_USER_EMAIL = randomNumeric(MIN_USER_EMAIL_LENGTH) + "@qq.com";
    public static final String EXP_USER_PASSWORD = randomGraph(MAX_PASSWORD_LENGTH-1);
    public static final Long EXP_USER_ID = generateUserIdByNowDate();


    /**
     * 业务中需要使用到的随机数必须使用ThreadLocalRandom来生成
     *
     * @return 随机六位数
     */
    public static Integer generateSixRandomInteger() {
        return ThreadLocalRandom.current().nextInt(100000, 999999);
    }

    /**
     * 随机大小写字符串
     *
     * @param strLength
     * @return
     */
    public static String randomAlphabetic(Integer strLength) {
        return RandomStringUtils.randomAlphabetic(strLength);
    }


    /**
     * 随机字符串大小写和各种字符带空格 如下
     * l4Vq Um<o-eXz_+jj<_)(gn(ez88GsBQE$4DXGtfh7C[{q:4:%rgFKiKt]e8uf"z!Xnqg[-l=8MS8]Cd6w_VuypMhGioKv=!;~>'
     *
     * @param strLength
     * @return
     */
    public static String randomStringAsci(Integer strLength) {
        return RandomStringUtils.randomAscii(strLength);
    }

    /**
     * 随机各种语言特殊字符 如下
     * 𡜂𢫶🅣鑋膱𡠃槬𣢚𧑫칻𧱮𦷪𨊨쀝𡩗𧈍럦𩓔⒴㊛䯛㟠㤉𡒨𝆐줎𣑋叿싄㩃𠢝摃皊⋢𩜌ᚁ𣘲𠁖Ｚ䔌Ϧ𤸰냢𣎸𩸘⪲𦯦忉찼豢𣚹𪅰𩁓𦯑ᇐ봲௸躚核戙𧆾쮙𑄻𢓏𪈟𪯯꾕⺎
     *
     * @param strLength
     * @return
     */
    public static String randomString(Integer strLength) {
        return RandomStringUtils.random(strLength);
    }

    /**
     * 随机大小写带数字字符串
     *
     * @param strLength
     * @return
     */
    public static String randomAlphanumeric(Integer strLength) {
        return RandomStringUtils.randomAlphanumeric(strLength);
    }

    /**
     * 随机数字
     *
     * @param strLength
     * @return
     */
    public static String randomNumeric(Integer strLength) {
        return RandomStringUtils.randomNumeric(strLength);
    }

    /**
     * 随机字符串大小写和各种字符带 如下
     * L2A<S1i`T!t4VXfqF%k/nf[x&m>t,/co/$o2(4-*3FV%0#,yF<i_hR*Uw)$E{mU`FXVw84!a6NLI3vzkK1mO($J,%ZrXi*ca`1vt
     *
     * @param strLength
     * @return
     */
    public static String randomGraph(Integer strLength) {
        return RandomStringUtils.randomGraph(strLength);
    }

    /**
     * 随机字符串大小写和各种字符带空格 如下
     * i-9U#+[wy;KYWdbV`}6F` 7Z_s!(x1dT(x mH{*@>q,*1^AA5B^A,YC#2thuE"(5ZDMV(bSe1xQD](q<ifEtBu83/F2*FeQ(+R8A
     *
     * @param strLength
     * @return
     */
    public static String randomPrint(Integer strLength) {
        return RandomStringUtils.randomPrint(strLength);
    }

    /**
     * 随机小写字符串
     *
     * @param strLength
     * @return
     */
    public static String randomByLowString(Integer strLength) {
        return RandomStringUtils.randomAlphabetic(strLength).toLowerCase();
    }

    /**
     * 随机大写字符串
     *
     * @param strLength
     * @return
     */
    public static String randomByUpString(Integer strLength) {
        return RandomStringUtils.randomAlphabetic(strLength).toUpperCase();
    }


    /**
     * 按照输入的字符随机字符串
     *
     * @param strLength
     * @return
     */
    public static String randomByInputString(Integer strLength, String strInput) {
        return RandomStringUtils.random(strLength, strInput);
    }

}
