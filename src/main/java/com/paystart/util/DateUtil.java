package com.paystart.util;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;

import org.springframework.stereotype.Component;

@Component
public class DateUtil{
	public static final String YYYY_MM_DD_HH_MM_SS = "yyyy-MM-dd HH:mm:ss";
	public static final String YYYY_MM_DD = "yyyy-MM-dd";
	public static final String DATETIME_DTO = "dd-MMM-yyyy HH:mm:ss"; //format for response
	public static final String DATETIME_REQ = "yyyyMMddHHmmss"; //format for vendor request
	public static final String DATETIME_TRANID = "yyyyMMddHHmmssSSS"; //format for generating tran id
	
	public static final String ZONE_UTC = "UTC";
	public static final String ZONE_DEFAULT = "DEFAULT";
	
	public static LocalDateTime toDate(String date, String dateFormat)
    {
	    DateTimeFormatter formatter = DateTimeFormatter.ofPattern(dateFormat);
 
        LocalDateTime localDateTime = LocalDateTime.parse(date, formatter); 
 
        System.out.println(formatter.format(localDateTime));
        
        return localDateTime;
      
    }
	
	public static String toStringDateTime(LocalDateTime date, String dateFormat)
    {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern(dateFormat);
 
		String formatDateTime = date.format(formatter);
 
        System.out.println(formatDateTime);
        
        return formatDateTime;
    }
	
	public static String toStringDate(LocalDate date, String dateFormat)
    {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern(dateFormat);
 
		String formatDateTime = date.format(formatter);
 
        System.out.println(formatDateTime);
        
        return formatDateTime;
    }
	
	public String getTimeStamp(String format, String zone, LocalDateTime dateTime){
		LocalDateTime timestamp = dateTime; 
		if(zone.equals(ZONE_UTC)){
			timestamp = LocalDateTime.ofInstant(Instant.now(), ZoneOffset.UTC);
		}
		return timestamp.format(DateTimeFormatter.ofPattern(format)); 
	}
	
	public LocalDateTime parseTimeStamp(String format, String dateTime){
		return LocalDateTime.parse(dateTime, DateTimeFormatter.ofPattern(format));
	}
}
