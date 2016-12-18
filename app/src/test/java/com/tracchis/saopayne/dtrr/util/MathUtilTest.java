package com.tracchis.saopayne.dtrr.util;

import org.junit.Test;

import static junit.framework.Assert.assertEquals;

/**
 * Created by saopayne on 12/18/16.
 */
public class MathUtilTest {

    @Test
    public void testGetNoDecimal() throws Exception{
        Float number = Float.valueOf("2.123123");
        assertEquals("2", MathUtil.getNoDecimal(number));
    }
}
