package com.base.wang.util;

import com.google.common.primitives.Doubles;

import java.math.BigDecimal;

/**
 * Created by YS on 2018/5/14.
 */
public class BigDecimalUtil {


    public static Double getDoubleFromBigDecimal(BigDecimal bigDecimal) {
        if(bigDecimal != null && Doubles.tryParse(bigDecimal.toString()) != null){
            return Doubles.tryParse(bigDecimal.toString());
        }
        return new Double(0);
    }

    public static Boolean compare(BigDecimal bigDecimalOne,BigDecimal bigDecimalTwo) {
        if(bigDecimalOne == null && bigDecimalTwo == null){
            return true;
        }
        if((bigDecimalOne !=null && bigDecimalTwo == null) || (bigDecimalOne ==null && bigDecimalTwo != null)){
            return false;
        }
        if(bigDecimalOne.compareTo(bigDecimalTwo) == 0){
            return true;
        }else {
            return false;
        }

    }
}