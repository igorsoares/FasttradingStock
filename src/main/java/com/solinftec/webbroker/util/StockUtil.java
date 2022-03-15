package com.solinftec.webbroker.util;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;

public class StockUtil {

    private static DecimalFormatSymbols symbols = new DecimalFormatSymbols(Locale.US);
    private static DecimalFormat df = new DecimalFormat("####.##", symbols);

    public static BigDecimal formatNumber(BigDecimal number) {
        // this will format a number with two decimal places
        if (number == null)
            return null;
        df.setMinimumFractionDigits(2);
        return new BigDecimal(df.format(number));
    }
}
