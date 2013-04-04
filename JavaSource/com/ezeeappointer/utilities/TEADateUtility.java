/**
 * 
 */
package com.ezeeappointer.utilities;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author dreddy
 *
 */
public class TEADateUtility {

	/*
	Convert date string from one format to another format using SimpleDateFormat.
	Here format of fromDate is dd/MM/yy
	*/
	public static String convertDateFromddMMyySlashedToMMddyyyyHiphened(String fromDate){
        String convertedDate = "";
        try
        {
                    //create SimpleDateFormat object with source string date format
                    SimpleDateFormat sdfFrom = new SimpleDateFormat("dd/MM/yy");
                    sdfFrom.setLenient(false);
                    //parse the string into Date object
                    Date date = sdfFrom.parse(fromDate);
                    //create SimpleDateFormat object with desired date format
                    SimpleDateFormat sdfTo = new SimpleDateFormat("MM-dd-yyyy");
                    //parse the date into another format
                    convertedDate = sdfTo.format(date);
        }
        catch(ParseException pe)
        {
                    return("Parse Exception : " + pe);
        }
        return convertedDate;
	}
	
	/*
	Method to parse date/time string into date. The return type of this method is Date. 
	This method throws ParseException if the given string cannot be parsed as a date.
	*/
	public static Date convertStringddMMyyyyHiphnedToDate(String dateString) {
	            Date date = null;
	            try
	            {
	                        //create SimpleDateFormat object with source string date format
	                        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
	                        sdf.setLenient(false);
	                        //parse the string into Date object
	                        date = sdf.parse(dateString);
	            }catch(ParseException pe){
	                        System.out.println("Parse Exception : " + pe);
	            }
	            return date;
	}
	
	public static Date convertStringddMMyyyyToDate(String dateString) {
        Date date = null;
        try
        {
                    //create SimpleDateFormat object with source string date format
                    SimpleDateFormat sdf = new SimpleDateFormat("ddMMyyyy");
                    sdf.setLenient(false);
                    //parse the string into Date object
                    date = sdf.parse(dateString);
        }catch(ParseException pe){
                    System.out.println("Parse Exception : " + pe);
        }
        return date;
	}
	
	public static String convertDateObjectToEEEEMMMMyyyyWithCommasAndSpaces(Date inDate) {
        String date = null;
        try
        {
                    //create SimpleDateFormat object with source string date format
                    SimpleDateFormat sdf = new SimpleDateFormat("EEEE, dd MMMM yyyy");
                    sdf.setLenient(false);
                    //parse the string into Date object
                    date = sdf.format(inDate);
        }catch(Exception pe){
        }
        return date;
	}
	
	public static String convertDateObjectToddMMMyyyyWithCommasAndSpaces(Date inDate) {
        String date = null;
        try
        {
                    //create SimpleDateFormat object with source string date format
                    SimpleDateFormat sdf = new SimpleDateFormat("dd MMM yyyy");
                    sdf.setLenient(false);
                    //parse the string into Date object
                    date = sdf.format(inDate);
        }catch(Exception pe){
        }
        return date;
	}
}
