package com.tracchis.saopayne.dtrr.util;

import java.math.BigDecimal;
import java.text.DecimalFormat;

public class MathUtil {

    /**
     * Return a number with no decimal, it means the number will be rounded to the nearest one.
     * As an example, 2.3 will return 2, and 2.8 will return 3.
     *
     * @param temp
     * @return
     */
    public static String getNoDecimal(float temp) {

        BigDecimal bigDecimal = new BigDecimal(String.valueOf(temp));
        bigDecimal = bigDecimal.setScale(0, BigDecimal.ROUND_HALF_UP);
        DecimalFormat decimalFormat = new DecimalFormat();
        decimalFormat.applyPattern("#,##0");

        return decimalFormat.format(bigDecimal);
    }
}
