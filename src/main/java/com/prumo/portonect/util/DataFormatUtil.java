/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.prumo.portonect.util;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.joda.time.LocalDateTime;
import org.joda.time.format.DateTimeFormat;

/**
 *
 * @author 120000499
 */
public class DataFormatUtil {
    
    private static final String format = "dd/MM/YYYY";
    private static final DateFormat df = new SimpleDateFormat(format);
    
    public static String getDataString(Date data) {
		
	String dataS = df.format(data);
	return dataS;
        
    }
    
    public static Date getData(String dataS) {
        
        LocalDateTime localData = LocalDateTime.parse(dataS, DateTimeFormat.forPattern(format));        
        return localData.toDate();
        
    }
    
}
