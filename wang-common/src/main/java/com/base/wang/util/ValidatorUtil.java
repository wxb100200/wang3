package com.base.wang.util;

import java.math.BigDecimal;

/**
 * 校验格式类 工具类
 *
 * @author YANHUI
 * @date 2017/11/29 14:23
 */
public class ValidatorUtil {


    /**
     * 校验 运营后台-平台账号 用户名格式（单位名称缩写+姓名缩写+手机后4位）
     * @param userName    用于校验的用户名
     * @return boolean	true-格式正确；false-格式错误
     */
    public static boolean checkAdminUserName(String userName) {
        if(userName == null || "".equals(userName.trim())){
            return false;
        }
        return userName.matches("^(?!\\d+$)[0-9a-zA-Z_]{0,30}$");
    }

    /**
     * 校验 运营后台-平台账号密码（6-16位 数字、字母、下划线（_）的任意组合）
     * @param password    用于校验的密码
     * @return boolean	true-格式正确；false-格式错误
     */
    public static boolean checkAdminPassword(String password) {
        if(password == null || "".equals(password.trim())){
            return false;
        }
        return password.matches("[a-zA-Z0-9`~!@#$%^&*()_\\-+=<>?:\"{}|,.\\/;'\\[\\]·~！@#￥%……&*（）——\\-+={}|《》？：“”【】、；‘’，。、]{6,16}");
    }

    public static void main(String[] args) {
        System.out.println(checkAdminPassword("y@301y@301y@301y"));
    }

    /**
     * 校验 金融端-平台账号密码（9-18位 数字、字母、下划线（_）的任意组合）
     * @param password    用于校验的密码
     * @return boolean	true-格式正确；false-格式错误
     */
    public static boolean checkBankUserPassword(String password) {
        if(password == null || "".equals(password.trim())){
            return false;
        }
        return password.matches("^[0-9a-zA-Z]{9,18}$");
    }


    /**
     * 校验 手机号格式
     * @param mobile    用于校验的手机号
     * @return boolean	true-格式正确；false-格式错误
     */
    public static boolean checkMobile(String mobile) {
        //判断输入的手机号码
        if(mobile == null || "".equals(mobile.trim())){
            return false;
        }
        return mobile.matches("^1[34578]\\d{9}$");
    }

    /**
     * 验证邮箱格式
     * @param email	邮箱
     * @return boolean	true-格式正确；false-格式错误
     */
    public static boolean checkEmail(String email) {
        //判断输入的邮箱
        if(StringUtil.isEmpty(email)){
            return false;
        }
        return email.trim().matches("^([a-zA-Z0-9_\\-\\.]+)@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.)|(([a-zA-Z0-9\\-]+\\.)+))([a-zA-Z]{2,4}|[0-9]{1,3})(\\]?)$");
    }


    /**
     * 验证 是否idCard
     * @param str   idCard
     * @return boolean	true-格式正确；false-格式错误
     */
    public static boolean checkIdCard(String str) {
        if (str == null) {
            return false;
        }
        return str.matches("\\d{6}(18|19|20)\\d{2}(0[1-9]|1[012])(0[1-9]|[12]\\d|3[01])\\d{3}(\\d|X|x)");
    }

    /**
     * 校验 是否正数且最多两位小数
     * @param num   double类型数值
     * @return boolean	true-格式正确；false-格式错误
     */
    public static boolean checkPlusAndUpToTwoDecimalPlaces(double num) {
        return String.valueOf(num).matches("^\\d+([.]\\d{0,2})?$");
    }

    /**
     * 校验 贷款利息是否是36（含）以内的非负数
     * @param loanRate
     * @return
     */
    public static boolean checkLoanRate(BigDecimal loanRate){
        if(loanRate.compareTo(BigDecimal.ZERO) == -1|| loanRate.compareTo(new BigDecimal(36)) == 1)
            return false;

        return true;
    }

}
