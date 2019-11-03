package com.base.wang.util;

import java.util.regex.Pattern;

public class IDCardUtil {

    /**
     * 对证件号中间加星号隐藏处理
     * @param idCard
     * @return
     */
    public static String hideIdCardHandle (String idCard) {
        if(idCard == null || idCard.trim().equals(""))return null;
        if (idCard.length() == 15) {
            return idCard.substring(0, 6) + "****" + idCard.substring(12, 15);
        } else if (idCard.length() == 18) {
            return idCard.substring(0, 6) + "****" + idCard.substring(14, 18);
        }else if(idCard.length()>10){
            return idCard.substring(0, 4) + "****" + idCard.substring(idCard.length()-4);
        }else if(idCard.length()>5){
            return idCard.substring(0, 3) + "****" + idCard.substring(idCard.length()-2);
        }else {
            return idCard;
        }

    }

    /**
     * 15位和18位ID号码的基本数字和位数验校.
     *
     * @param idcard
     * @return
     */
    public static boolean isIdcard(String idcard) {
        return idcard != null && !"".equals(idcard) && Pattern.matches("(^//d{15}$)|(//d{17}(?://d|x|X)$)", idcard);
    }

    /**
     * 15位ID号码的基本数字和位数验校.
     *
     * @param idcard
     * @return
     */
    public static boolean is15Idcard(String idcard) {
        return idcard != null && !"".equals(idcard) && Pattern.matches(
                "^[1-9]\\d{7}((0\\d)|(1[0-2]))(([0|1|2]\\d)|3[0-1])\\d{3}$", idcard);
    }

    /**
     * 18位ID号码的基本数字和位数验校.
     *
     * @param idcard
     * @return
     */
    public static boolean is18Idcard(String idcard) {
        return idcard != null && !"".equals(idcard) && Pattern.matches(
                "^[1-9]\\d{5}[1-9]\\d{3}((0\\d)|(1[0-2]))(([0|1|2]\\d)|3[0-1])\\d{3}([\\d|x|X]{1})$", idcard);
    }

    public static void main(String[] args) {
        // 130503670401001
        // 330411199505092616
        System.out.println(hideIdCardHandle("130503670401001"));
    }
}
