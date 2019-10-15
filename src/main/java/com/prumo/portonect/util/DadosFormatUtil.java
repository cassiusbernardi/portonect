/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.prumo.portonect.util;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author cassius.janoario
 */
public final class DadosFormatUtil {

    private static final NumberFormat DECIMAL_FORMAT = new DecimalFormat("#,###.00");

    public static Double getDecimal(double valor) {
        
        Double value = null;   
        try {
            DecimalFormatSymbols symbols = DecimalFormatSymbols.getInstance();
            symbols.setDecimalSeparator('.');
            DecimalFormat format = new DecimalFormat("#.#####", symbols);
                 
            value = format.parse(format.format(valor)).doubleValue();
        } catch (ParseException ex) {
            Logger.getLogger(DadosFormatUtil.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return value;

    }

    public static String getDecimalString(double valor) {

        return DECIMAL_FORMAT.format(valor);

    }

}
